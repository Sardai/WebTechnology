

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
    private KamerVerhuur kamerVerhuur;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRoomServlet() {
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
		if(!AuthHelper.isHuurderIngelogd(request, response)){
			return;
		}
		response.sendRedirect("huurder.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!AuthHelper.isHuurderIngelogd(request, response))
		{
			return;
		}
		
		if(request.getParameter("oppervlakte").isEmpty() || request.getParameter("personen").isEmpty() || request.getParameter("max_prijs").isEmpty() || request.getParameter("plaats").isEmpty()){
			getServletContext().getRequestDispatcher("/WEB-INF/emptyFields.html").forward(request, response);
			return;
		}
		
		int oppervlakte = 0;
		int personen = 0;
		double max_prijs = 0.0;
		String plaats = request.getParameter("plaats");
		try{
			oppervlakte = Integer.parseInt(request.getParameter("oppervlakte"));
			personen = Integer.parseInt(request.getParameter("personen"));
			max_prijs = Double.parseDouble(request.getParameter("max_prijs"));			
		}
		catch(NumberFormatException e){
			getServletContext().getRequestDispatcher("/WEB-INF/wrongDataType.html").forward(request, response);
			return;
		}

		
		
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
	}

}
