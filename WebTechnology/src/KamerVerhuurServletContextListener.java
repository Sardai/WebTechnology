import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Admin;
import model.Huurder;
import model.Kamer;
import model.KamerVerhuur;
import model.Verhuurder;

@WebListener
public class KamerVerhuurServletContextListener implements ServletContextListener {
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	KamerVerhuur kamerVerhuur = new KamerVerhuur();
    	Admin admin = new Admin("Admin","test123");
    	Verhuurder verhuurder = new Verhuurder("Verhuurder", "test123");
    	Huurder huurder = new Huurder("Huurder", "test123");
    	kamerVerhuur.addUser(admin);
    	kamerVerhuur.addUser(verhuurder);
    	kamerVerhuur.addUser(huurder);
    	
    	Kamer kamer1 = new Kamer(1, 20, 500.0, "Enschede", 5);
    	Kamer kamer2 = new Kamer(2, 20, 500.0, "Enschede", 3);
    	Kamer kamer3 = new Kamer(3, 20, 700.0, "Enschede", 5);
    	Kamer kamer4 = new Kamer(4, 20, 500.0, "Hengelo", 5);
    	Kamer kamer5 = new Kamer(5, 12, 500.0, "Enschede", 5);
    	
    	kamerVerhuur.addKamer(kamer1);
    	kamerVerhuur.addKamer(kamer2);
    	kamerVerhuur.addKamer(kamer3);
    	kamerVerhuur.addKamer(kamer4);
    	kamerVerhuur.addKamer(kamer5);
    	
    	
    	arg0.getServletContext().setAttribute("KamerVerhuur",kamerVerhuur );
    	    	
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
