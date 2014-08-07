package opendolphin.gwt.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "InvalidateSessionServlet", urlPatterns = "/opendolphininvalidate", loadOnStartup = 1)
public class ODSessionInvalidationServlet extends HttpServlet {

	private static final long serialVersionUID = 6503677376241505406L;

	public ODSessionInvalidationServlet() {
		super();
	}

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		System.out.println("HttpSession invalidated");
	}
}