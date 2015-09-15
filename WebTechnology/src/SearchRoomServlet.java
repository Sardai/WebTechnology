

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
 * Servlet implementation class SearchRoomServlet
 */
@WebServlet("/SearchRoomServlet")
public class SearchRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!AuthHelper.isHuurderIngelogd(request, response))
		{
			return;
		}
		
		int oppervlakte = Integer.parseInt(request.getParameter("oppervlakte"));
		int personen = Integer.parseInt(request.getParameter("personen"));
		double max_prijs = Double.parseDouble(request.getParameter("max_prijs"));
		String plaats = request.getParameter("plaats");
		
		KamerVerhuur kamerVerhuur = (KamerVerhuur) request.getServletContext().getAttribute("KamerVerhuur");
		
		PrintWriter writer = response.getWriter();
		
		writer.append("<table>"
				+ "<tr><th>Nummer</th><th>Aantal personen</th><th>Huur prijs</th><th>Vierkante meters</th><th>Plaats</th></tr>"
				); 
		for(Kamer kamer : kamerVerhuur.getKamers()){
			if (kamer.getVierkanteMeters() >= oppervlakte && kamer.getAantalPersonen() >= personen && kamer.getHuurprijs() <= max_prijs && kamer.getPlaats().equals(plaats)){
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
		}
		writer.append("</table>");
				
		doGet(request, response);
	}

}
