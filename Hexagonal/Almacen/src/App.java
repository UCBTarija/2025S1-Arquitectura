import java.util.List;

import catalogo.application.InsertarProductoUseCase;
import catalogo.domain.Producto;
import catalogo.infrastructure.CatalogoRepositoryPgImpl;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        CatalogoRepositoryPgImpl catalogoRepository = new CatalogoRepositoryPgImpl();
        InsertarProductoUseCase insertarProductoUseCase = 
        new InsertarProductoUseCase(catalogoRepository);

        int id = insertarProductoUseCase.execute("Clase 1", "Codigo 1", "Nombre 1");
        System.out.println("Producto insertado con id: " + id);

        // CatalogoRepositoryPgImpl catalogoRepository = new CatalogoRepositoryPgImpl();

        // // Producto producto = new Producto(7, 
        // // "Producto1xxx", "Descripcion 1xxx", "Nombre 1xxx");
        // Producto producto = catalogoRepository.getById(1);
        // if(producto == null) {
        //     System.out.println("No existe el producto con id 1");
        // } else {
        //     System.out.println("Producto encontrado: " + producto);
        // }

        // Producto producto2 = catalogoRepository.getById(7);
        // if(producto2 == null) {
        //     System.out.println("No existe el producto con id 7");
        // } else {
        //     System.out.println("Producto encontrado: " + producto2);
        // }

        // List<Producto> productos = catalogoRepository.find("%");
        // System.out.println("Lista de productos: ");
        // for(Producto p : productos) {
        //     System.out.println(p);
        // }

        //catalogoRepository.store(producto);

    }
}
