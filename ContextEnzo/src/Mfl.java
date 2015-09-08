

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Brain;
import model.Student;

/**
 * Application Lifecycle Listener implementation class Mfl.
 * NB:
 * - Annotations
 * - Usage of the Initialize and Destroy
 */
@WebListener
public class Mfl implements ServletContextListener {

	// Useful for making clean debug messages.
	private static final String printStringFormat  = "[%-35.35s] - %-15s : %s\n";
	private static final String printIntegerFormat = "[%-35.35s] - %-15s : %d\n";
	
    /**
     * Default constructor. 
     */
    public Mfl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	String cm = getClass().getName() + "::" + Thread.currentThread().getStackTrace()[1].getMethodName();    	
    	System.out.format(printStringFormat, cm, "ServletContext", "Initialized");
    	
    	// Sets an object
         arg0.getServletContext().setAttribute("myModel", new Brain());
         
         // Sets a string
         arg0.getServletContext().setAttribute("myStringData", "Some text to store");
         
         // Sets an integer
         arg0.getServletContext().setAttribute("myIntegerData", 10);
         
         // Inserting 3 students
         Student student1 = new Student("Piet", "Enschede");
         Student student2 = new Student("Jan", "Deventer");
         Student student3 = new Student("Klaas", "Hengelo");
         arg0.getServletContext().setAttribute("Student001", student1);
         arg0.getServletContext().setAttribute("Student002", student2);
         arg0.getServletContext().setAttribute("Student003", student3);
    }	// contextInitialized

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	String cm = getClass().getName() + "::" + Thread.currentThread().getStackTrace()[1].getMethodName();
    	System.out.format(printStringFormat, cm, "ServletContext", "Destroyed");
    }	// contextDestroyed
	
}
