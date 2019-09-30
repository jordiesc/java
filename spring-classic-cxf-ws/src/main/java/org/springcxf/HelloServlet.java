package org.springcxf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloservlet")
public class HelloServlet extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Hello World HttpServlet Class Example</h1>");
        printWriter.print("<a href=\"http://www.javaguides.net\">Java Guides</a>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }

}
