package catalogo.domain;

import java.util.List;

public class Catalogo {

    private CatalogoRepositoryPort repository;

    public Catalogo(CatalogoRepositoryPort repository) {
        this.repository = repository;
    }

    public int adicionarProducto(
            String codigo,
            String nombre,
            String clase) {

        int id = this.repository.nextIdentity();
        // valido los datos

        Producto producto = new Producto(
                id,
                clase,
                codigo,
                nombre);

        this.repository.store(producto);
        return id;
    }

    public Producto getProducto(int id) {
        return this.repository.getById(id);
    }

    public List<Producto> find(String filtro) {
        return this.repository.find(filtro);
    }

    public boolean modificarProducto(
            int id,
            String codigo,
            String nombre,
            String clase) {

        Producto producto = this.repository.getById(id);

        // valido los datos

        producto.setClase(clase);
        producto.setNombre(nombre);
        producto.setCodigo(codigo);

        return this.repository.store(producto);
    }
}
