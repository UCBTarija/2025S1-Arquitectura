package catalogo.application;

import catalogo.domain.Catalogo;
import catalogo.domain.CatalogoRepositoryPort;
import catalogo.domain.Producto;

public class InsertarProductoUseCase {
    private CatalogoRepositoryPort catalogoRepository;

    public InsertarProductoUseCase(
            CatalogoRepositoryPort catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    public int execute(String clase, String codigo, String nombre) {
        int id = this.catalogoRepository.nextIdentity();
        Producto producto = new Producto(id, clase, codigo, nombre);
        this.catalogoRepository.store(producto);        
        return id;
    }

    public int executeComplejo(String clase, String codigo, String nombre) {
        Catalogo catalogo = new Catalogo(this.catalogoRepository);
        return catalogo.adicionarProducto(codigo, nombre, clase);
    }
}
