

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class ListStudents
 */
@WebServlet("/ListStudents")
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String printStringFormat  = "[%-35.35s] - %-15s : %s\n";
	private static final String printIntegerFormat = "[%-35.35s] - %-15s : %d\n";	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Gets the ClassName and MethodName (just to display for students).
		String cm = getClass().getName() + "::" + Thread.currentThread().getStackTrace()[1].getMethodName();
		
		System.out.format(printStringFormat, cm, "Started", "Showing when is called.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gets the ClassName and MethodName (just to display for students).
		String cm = getClass().getName() + "::" + Thread.currentThread().getStackTrace()[1].getMethodName();
		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = request.getServletContext();
		
		out.println("<!doctype html>\n"
	                 + "<html>\n"
	                 + "<head><title>Student List</title></head>\n"
	                 + "<body>\n"
	                 + "<h1>List of Students</h1>"
	                 + "<table width=\"450\" style=\"border:1px solid blue;\"><thead><tr>"
	                 + "<th width=\"225\" style=\"text-align:left;border:1px solid blue;\">Name</th>"
	                 + "<th width=\"225\" style=\"text-align:left;border:1px solid blue;\">Address</th></tr></thead><tbody>");
		
		
		Enumeration <String>enumNames = servletContext.getAttributeNames();
		for (; enumNames.hasMoreElements(); ) {
			String attName = (String) enumNames.nextElement();
			System.out.format(printStringFormat, cm, "Attribute", attName);
			
			// Selects the students
			if (attName.toLowerCase().contains("student")) {
				Student student = null;
				StringBuffer sb = new StringBuffer();
				student = (Student) servletContext.getAttribute(attName);
				sb.append("<tr><td>");
				sb.append( student.getName());
				sb.append("</td><td>");
				sb.append( student.getAdd());
				sb.append("</td></tr>");
				out.println(sb.toString());
			}
		}

		out.println("</tbody></table>\n</body></html>");
		
	}

}
