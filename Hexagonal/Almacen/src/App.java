import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import catalogo.application.InsertarProductoUseCase;
import catalogo.domain.CatalogoRepositoryPort;
import catalogo.infrastructure.CatalogoRepositoryPgImpl;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.setExecutor(java.util.concurrent.Executors.newFixedThreadPool(1));
        server.createContext("/add-producto", new AddProductoHandler());
        // Start the server
        System.out.println("Server started on http://localhost:8080. Press Ctrl+C to stop.");
        server.start();
    }

    static class AddProductoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Map<String, String> params = getRequestParams(t);

            String clase = params.get("clase");
            String codigo = params.get("codigo");
            String nombre = params.get("nombre");

            CatalogoRepositoryPort catalogoRepository = new CatalogoRepositoryPgImpl(); // Implementar CatalogoRepository
            InsertarProductoUseCase useCase = new InsertarProductoUseCase(catalogoRepository);
            int id = useCase.execute(clase, codigo, nombre);

            StringBuilder response = new StringBuilder();
            response.append("{");
            response.append("\"status\":\"ok\"");
            response.append(",");
            response.append("\"id\":").append(id);
            response.append("}");

            t.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    // convierte en un mapa los parámetros de la url
    public static Map<String, String> getRequestParams(HttpExchange exchange) {
        String query = exchange.getRequestURI().getQuery();
        if (query == null || query.isEmpty())
            return Collections.emptyMap();

        return Stream.of(query.split("&"))
                .filter(s -> !s.isEmpty())
                .map(kv -> kv.split("=", 2))
                .collect(Collectors.toMap(x -> x[0], x -> x[1]));
    }
}