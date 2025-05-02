package web.handler;

import web.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws IOException, ServletException {

	    System.out.println("[LoginServlet] POST");

	    String username = req.getParameter("username") != null ? req.getParameter("username") : "";
	    String password = req.getParameter("passwd") != null ? req.getParameter("passwd") : "";
	    String dob = req.getParameter("dob") != null ? req.getParameter("dob") : "";

	    System.out.println("Username/password/dob: " + username + ", " + password + ", " + dob);

	    String loginStatus = "fail"; // default

	    if (!username.isEmpty() && !password.isEmpty() && !dob.isEmpty()) {
	        if (LoginService.login(username, password, dob)) {
	            loginStatus = "success";
	        }
	    }

	    System.out.println("Login Status: " + loginStatus);

	    String htmlResponse = "<html>";
	    htmlResponse += "<head><title>" + loginStatus + "</title></head>";
	    htmlResponse += "<body><h2>Login status: " + loginStatus + "</h2></body>";
	    htmlResponse += "</html>";

	    resp.setContentType("text/html");
	    PrintWriter writer = resp.getWriter();
	    writer.println(htmlResponse);
	}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        doPost(req, resp); // Delegate GET to POST
    }
}
