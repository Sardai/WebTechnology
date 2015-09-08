import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Admin;
import model.KamerVerhuur;

@WebListener
public class KamerVerhuurServletContextListener implements ServletContextListener {
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	KamerVerhuur kamerVerhuur = new KamerVerhuur();
    	Admin admin = new Admin("Admin","test123");
    	kamerVerhuur.addUser(admin);
    	arg0.getServletContext().setAttribute("KamerVerhuur",kamerVerhuur );
    	    	
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
