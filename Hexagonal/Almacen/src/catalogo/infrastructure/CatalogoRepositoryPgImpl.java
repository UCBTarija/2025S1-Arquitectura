package catalogo.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import catalogo.domain.CatalogoRepositoryPort;
import catalogo.domain.Producto;

public class CatalogoRepositoryPgImpl implements CatalogoRepositoryPort {

    @Override
    public Producto getById(int id) {        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT id, clase,");
            sql.append(" codigo, nombre");
            sql.append(" FROM producto");
            sql.append(" WHERE id = ?");

            Connection conn = DB.getConnection();
            PreparedStatement stmt = 
            conn.prepareStatement(sql.toString());
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String clase = rs.getString("clase");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                return new Producto(id, clase, codigo, nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean store(Producto producto) {
        try {            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO producto (id, clase, codigo, nombre)");
            sql.append(" VALUES (?, ?, ?, ?)");
            sql.append(" ON CONFLICT (id) DO UPDATE");
            sql.append(" SET clase = EXCLUDED.clase,");
            sql.append(" codigo = EXCLUDED.codigo,");
            sql.append(" nombre = EXCLUDED.nombre");
            
            Connection conn = DB.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, producto.getId());
            stmt.setString(2, producto.getClase());
            stmt.setString(3, producto.getCodigo());
            stmt.setString(4, producto.getNombre());            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection conn = DB.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM producto WHERE id = ?");
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Producto> find(String filtro) {
        List<Producto> productos = new ArrayList<>();        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT id, clase, codigo, nombre");
            sql.append(" FROM producto");
            sql.append(" WHERE codigo||' '||nombre||' '|| clase LIKE ?");

            Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, filtro + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String clase = rs.getString("clase");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                productos.add(new Producto(id, clase, codigo, nombre));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public int nextIdentity() {
        try {
            String sql = "SELECT nextval('inventario.producto_id_seq')";
            Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
