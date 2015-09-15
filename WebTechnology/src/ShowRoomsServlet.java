

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helper.AuthHelper;
import model.Kamer;
import model.KamerVerhuur;

/**
 * Servlet implementation class ShowRoomsServlet
 */
@WebServlet("/ShowRoomsServlet")
public class ShowRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KamerVerhuur kamerVerhuur;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomsServlet() {
        super();
    }
    
	@Override
	public void init() throws ServletException {		
		super.init();
		kamerVerhuur = (KamerVerhuur) getServletContext().getAttribute("KamerVerhuur");
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!AuthHelper.isVerhuurderIngelogd(request, response))
		{
			return;
		}		 			
		
		PrintWriter writer = response.getWriter();
		
		writer.append("<a href='AddRoom	Servlet'>Kamer toevoegen</a>");
		writer.append("<table>"
				+ "<tr><th>Nummer</th><th>Aantal personen</th><th>Huur prijs</th><th>Vierkante meters</th><th>Plaats</th></tr>"
				); 
		for(Kamer kamer : kamerVerhuur.getKamers()){
			writer.append(String.format(""
					+ "<tr>"
					+ "<td>%d</td>"
					+ "<td>%d</td>"
					+ "<td>%.2f</td>"
					+ "<td>%d</td>"
					+ "<td>%s</td>"
					+ "</tr>",
					kamer.getKamerNummer(),kamer.getAantalPersonen(),
					kamer.getHuurprijs(),kamer.getVierkanteMeters(),kamer.getPlaats()));
		}
		writer.append("</table>");
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
