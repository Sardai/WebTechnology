import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.KamerVerhuur;

@WebListener
public class KamerVerhuurServletContextListener implements ServletContextListener {
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	arg0.getServletContext().setAttribute("KamerVerhuur", new KamerVerhuur());
    	    	
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
