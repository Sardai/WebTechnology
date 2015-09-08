package helper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.User;
import model.Verhuurder;

public class AuthHelper {
	
	public static boolean isVerhuurderIngelogd(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(false);
			if (session == null) {
				response.sendRedirect("login.html");
				return false;
			}

			User user = (User) session.getAttribute("User");

			if (!(user instanceof Verhuurder)) {
				response.sendRedirect("login.html");
				return false;
			}
		} catch (IOException e) {
		}
		return true;
	}

	public static boolean isAdminIngelogd(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(false);
			if (session == null) {
				response.sendRedirect("login.html");
				return false;
			}

			User user = (User) session.getAttribute("User");

			if (!(user instanceof Admin)) {
				response.sendRedirect("login.html");
				return false;
			}
		} catch (IOException e) {
		}
		return true;
	}
	
}
