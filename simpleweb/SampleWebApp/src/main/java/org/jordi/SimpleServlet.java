package org.jordi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypath")
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>Hola Mundo</p>");

    
    	Enumeration<String> headerNames = req.getHeaderNames();

		while (headerNames.hasMoreElements()) {

			String headerName = headerNames.nextElement();
			writer.print(headerName);


			Enumeration<String> headers = req.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = headers.nextElement();
				writer.println("="+ headerValue);
				writer.println("<br/>");

			}

		}
		
        writer.println("</body>");
        writer.println("</html>");
    
    }

}