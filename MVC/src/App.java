import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import com.sun.net.httpserver.HttpServer;

public class App {
   // private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {       
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);

        server.createContext("/productos", new  ListaProductosHandler());
        server.setExecutor(threadPoolExecutor);
        server.start();
        //logger.info(" Server iniciado en puerto 8080");
    }
}
