package net.lermex.up.level3;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServletStudy {
    public static void main (String[] args) throws Exception {
        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(InfoServlet.class, "/*"); // все запросы ачинающиеся с /
        server.start();
        server.join();

    }

}
