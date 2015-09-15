package helper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Huurder;
import model.User;
import model.Verhuurder;

public class AuthHelper {
	
	public static User getUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.html");
			return null;
		}

		return (User) session.getAttribute("User");
	}
	
	public static boolean isVerhuurderIngelogd(HttpServletRequest request, HttpServletResponse response) {
		try {
		
			User user = getUser(request, response);
			if (user != null && !(user instanceof Verhuurder)) {
				response.sendRedirect("login.html");
				return false;
			}
		} catch (IOException e) {
		}
		return true;
	}
	
	public static boolean isHuurderIngelogd(HttpServletRequest request, HttpServletResponse response) {
		try {
		
			User user = getUser(request, response);
			if (user != null && !(user instanceof Huurder)) {
				response.sendRedirect("login.html");
				return false;
			}
		} catch (IOException e) {
		}
		return true;
	}

	public static boolean isAdminIngelogd(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			User user = getUser(request, response);
			if (user != null && !(user instanceof Admin)) {
				response.sendRedirect("login.html");
				return false;
			}
		} catch (IOException e) {
		}
		return true;
	}
	
	
	
}
