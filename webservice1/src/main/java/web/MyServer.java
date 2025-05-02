package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;

public class MyServer {

    private static int PORT = 8082;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        // 🔧 ABSOLUTE path to the folder containing login.html
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("E:/Deakin/GitRepo/SIT707/pages");
        resourceHandler.setWelcomeFiles(new String[]{"login.html"});

        // Register servlet handlers
        ServletContextHandler servletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletHandler.addServlet(new ServletHolder(new LoginServlet()), "/login");
        servletHandler.addServlet(new ServletHolder(new RegistrationServlet()), "/reg");

        // Combine both
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new org.eclipse.jetty.server.Handler[] { resourceHandler, servletHandler });
        server.setHandler(handlers);

        server.start();
        System.out.println("Server started on port " + PORT);
        server.join();
    }
}
