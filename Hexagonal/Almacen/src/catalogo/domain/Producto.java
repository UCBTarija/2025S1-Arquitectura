package catalogo.domain;

public class Producto {
    private int id;
    private String clase;
    private String codigo;
    private String nombre;


    public Producto(int id, String clase, String codigo, String nombre) {
        this.id = id;
        this.clase = clase;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public String getClase() {
        return this.clase;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setClase(String valor) {
        this.clase = valor;
    };

    public void setCodigo(String valor) {
        this.codigo = valor;
    };

    public void setNombre(String valor) {
        this.nombre = valor;
    };

    @Override
    public String toString() {
        return "Producto [id=" + id + ", clase=" + clase + ", codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}
