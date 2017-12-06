/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jordi.demo;

import java.io.IOException;
import java.util.Date;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
        name = "dateServlet",
        urlPatterns = {"/data"}
)
public class DataPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse res) throws ServletException, IOException {
		res.getWriter()
				.append(String.format("It's %s now\n\n\n\nwww.hascode.com",
						new Date()));
	}
}