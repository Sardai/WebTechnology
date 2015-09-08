

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Brain;

/**
 * Servlet implementation class IsThereAnybody
 */
@WebServlet("/IsThereAnybody")
public class IsThereAnybodyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String printStringFormat  = "[%-35.35s] - %-15s : %s\n";
	private static final String printIntegerFormat = "[%-35.35s] - %-15s : %d\n";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsThereAnybodyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gets the ClassName and MethodName (just to display for students).
		String cm = getClass().getName() + "::" + Thread.currentThread().getStackTrace()[1].getMethodName();
		PrintWriter out = response.getWriter();
		
		ServletContext myAppContext = request.getServletContext();
		
		// out.println(myAppContext.getServerInfo());
		out.printf(printStringFormat, cm, "ServerInfo", myAppContext.getServerInfo());
		
		Brain myBrain = (Brain) myAppContext.getAttribute("myModel"); 
		// myBrain = null;
		if (myBrain != null) {
			out.printf(printStringFormat, cm, "Brain", myBrain.getBrainDump());
		}
		else {
			// out.println("<br> There is no brain");
			out.printf(printStringFormat, cm, "Brain", "There is no brain.");
		
			Enumeration<String> attribs=getServletContext().getAttributeNames();  
			while(attribs.hasMoreElements()){  
				String ctxAttribute= attribs.nextElement() ;  
				out.println("Attribute Name : "+ctxAttribute+", has value: "
						+getServletContext().getAttribute(ctxAttribute));  
			}  
		}
		
		getSCData(request, response);
	}	// doGet
	
	/**
	 * Gets the ServletContext.
	 * @param request HttpServletRequest parameter
	 * @param response HttpServletResponse parameter
	 * @return true/false
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean getSCData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gets the ClassName and MethodName (just to display for students).
		String cm = getClass().getName() + "::" + Thread.currentThread().getStackTrace()[1].getMethodName();
		PrintWriter out = response.getWriter();

		ServletContext myAppContext = request.getServletContext();
		String scStringData = (String) myAppContext.getAttribute("myStringData");
		out.printf(printStringFormat, cm, "StringData", scStringData);
		
		int scIntegerData = (int) myAppContext.getAttribute("myIntegerData");
		out.printf(printIntegerFormat, cm, "IntegerData", scIntegerData);
		
		return true;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
