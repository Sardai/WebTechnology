

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/ShowParametersServlet")
public class ShowParametersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowParametersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debuggen");
		PrintWriter out = response.getWriter();
		  out.println("<!doctype html>\n"
	                 + "<html>\n"
	                 + "<head><title>Show some paramaters</title></head>\n"
	                 + "<body>\n"
	                 + " Waarde van 'aName':" + request.getParameter("aName") + "<br>\n"
	                 + " Waarde van 'aNothername': " + request.getParameter("aNothername") + "<br>\n"
	                 + " Waarde van 'anotherName': " + request.getParameter("anotherName")
	                 + "</body></html>");	
	}

}
