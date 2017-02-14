package com.project1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project2.Implementation.restDaoImplementation;
import com.project2.Implementation.rrDaoImplementation;
import com.project2.Implementation.userDaoImplementation;
import com.project2.Model.RateReview;
import com.project2.Model.Rest;
import com.project2.Model.User;

@WebServlet(name = "loginServlet", urlPatterns = { "/login" }, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (request.getParameter("logout") != null) {
			session.invalidate();
			response.sendRedirect("login");
			return;
		} else if (session.getAttribute("username") != null) {
			response.sendRedirect("restaurant");
			return;
		} else {
			request.setAttribute("loginFailed", false);
			ServletContext servletContext = getServletContext();
			WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			restDaoImplementation restDaoImplementation = (restDaoImplementation) appContext
					.getBean("restDaoImplementation");
			List<Rest> rest = null;
			Rest res = null;
			rest = (List<Rest>) restDaoImplementation.getAllRest();

			//res = (Rest) rest.get(0);
			//System.out.println("Pagal::" + res.getLocation());
			request.setAttribute("rest_details", rest);

			request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
			System.out.println("VALUE NAHI JATE");
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			response.sendRedirect("restaurant");
			return;
		}

		String input_case = request.getParameter("input_case");

		switch (input_case) {
		case "login-page":
			this.login_form(request, response);
			break;
		case "Home-page":
			this.home_page(request, response);
			break;
		case "login":
			this.login_check(request, response);
			break;
		case "signup":
			this.signinForm(request, response);
			break;
		case "sign-up":
			this.signup_add(request, response);
			break;
		case "Review":
			this.show_review(request, response);
			break;
		case "back":
			this.back_home(request, response);
			break;
		}

	}

	private void back_home(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login");
		return;
	}

	private void show_review(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String restaurant = request.getParameter("key");
		String restaurant_Name = request.getParameter("key_Name");
		ServletContext servletContext = getServletContext();
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		rrDaoImplementation rrDaoImplementation = (rrDaoImplementation) appContext.getBean("rrDaoImplementation");

		List<RateReview> rate = null;
		Rest ret = new Rest();
		// =ret.getRestName();
		rate = (List<RateReview>) rrDaoImplementation.gettAllRatenReview();
		System.out.println("Review Sati" + rate);
		request.setAttribute("rrid", restaurant);
		request.setAttribute("rrname", restaurant_Name);
		request.setAttribute("rate_review", rate);
		request.getRequestDispatcher("/WEB-INF/jsp/view/reviewpublicpage.jsp").forward(request, response);
	}

	private void home_page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.sendRedirect("login");
	}

	private void login_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/view/loginForm.jsp").forward(request, response);

	}

	private void login_check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("admin") && (password.equals("admin"))) {
			request.getRequestDispatcher("/WEB-INF/jsp/view/admin.jsp").forward(request, response);
		} else {
			ServletContext servletContext = getServletContext();
			WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

			userDaoImplementation userDaoImplementation = (userDaoImplementation) appContext
					.getBean("userDaoImplementation");

			/** insert **/
			User user1 = null;
			user1 = userDaoImplementation.login(username, password);

			if (user1 == null) {
				request.setAttribute("loginFailed", true);
				request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
			} else {
				session.setAttribute("username", username);
				request.changeSessionId();
				response.sendRedirect("restaurant");
			}
		}

	}

	private void signinForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/view/signinForm.jsp").forward(request, response);
	}

	private void signup_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signin_username = request.getParameter("input_username");
		String signin_password = request.getParameter("input_password");
		ServletContext servletContext = getServletContext();
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		userDaoImplementation userDaoImplementation = (userDaoImplementation) appContext
				.getBean("userDaoImplementation");

		/** insert **/
		User user = new User();
		user.setUsername(signin_username);
		user.setPassword(signin_password);
		userDaoImplementation.insert(user);
		response.sendRedirect("login");
	}

}
