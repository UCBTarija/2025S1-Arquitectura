package catalogo.domain;

import java.util.List;

public interface CatalogoRepositoryPort {
    public Producto getById(int id);
    public boolean store(Producto producto);
    public boolean delete(int id);
    public int nextIdentity();
    public List<Producto> find(String filtro);
}