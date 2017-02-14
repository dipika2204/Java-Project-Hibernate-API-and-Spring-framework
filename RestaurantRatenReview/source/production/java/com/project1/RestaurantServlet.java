package com.project1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project2.Implementation.restDaoImplementation;
import com.project2.Implementation.rrDaoImplementation;
import com.project2.Implementation.userDaoImplementation;
import com.project2.Model.RateReview;
import com.project2.Model.Rest;
import com.project2.Model.User;

@WebServlet(name = "restuarantServlet", urlPatterns = { "/restaurant" }, loadOnStartup = 1)

public class RestaurantServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("login");
			return;
		}

		ServletContext servletContext = getServletContext();
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		restDaoImplementation restDaoImplementation = (restDaoImplementation) appContext
				.getBean("restDaoImplementation");

		List<Rest> rest = null;
		Rest res = null;

		rest = (List<Rest>) restDaoImplementation.getAllRest();

		//res = (Rest) rest.get(0);
		request.setAttribute("rest_details", rest);
		request.getRequestDispatcher("/WEB-INF/jsp/view/privatepage.jsp").forward(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("login");
			return;

		}

		String input_case = request.getParameter("review");

		switch (input_case) {
		case "Review":
			this.show_review(request, response);
			break;

		case "givereview":
			this.show_reviewform(request, response);
			break;

		case "add":
			this.add_ratereview(request, response);
			break;

		case "back":
			this.back_home(request, response);
			break;
		}

	}

	private void add_ratereview(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int hotel_userid;
		String name_user = (String) request.getSession().getAttribute("username");
		ServletContext servletContext = getServletContext();
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		userDaoImplementation userDaoImplementation = (userDaoImplementation) appContext
				.getBean("userDaoImplementation");
		User user1 = null;
		user1 = userDaoImplementation.getuserbyid(name_user);
		hotel_userid = user1.getUserId();
		String hotel_id = request.getParameter("key");
		String hotel_name = request.getParameter("key_Name");
		String hotel_loc = request.getParameter("key_loc");
		String rrate = request.getParameter("review_rate");
		String rreview = request.getParameter("rate_review");
		RateReview rateReview = new RateReview();
		rateReview.setRest_id(Integer.parseInt(hotel_id));
		System.out.println("sddede"+hotel_id);
		rateReview.setUser_id(hotel_userid);
		rateReview.setRate(Integer.parseInt(rrate));
		rateReview.setReview(rreview);
		restDaoImplementation restDaoImplementation = (restDaoImplementation) appContext
				.getBean("restDaoImplementation");
		Rest rest1 = null;
		rest1 = restDaoImplementation.getrestbyid(Integer.parseInt(hotel_id));
		int count = rest1.getCount();
		float ratefrmrest = rest1.getRate_avg();
		float totalrating = (count * ratefrmrest) + (Integer.parseInt(rrate));
		int updated_count = count + 1;
		float final_rate = totalrating / updated_count;
		Rest rest = new Rest();
		rest.setCount(updated_count);
		rest.setRate_avg(final_rate);
		rest.setLocation(hotel_loc);
		rest.setRestId(Integer.parseInt(hotel_id));
		rest.setRestName(hotel_name);
		restDaoImplementation.updateRest_info(rest);
		rrDaoImplementation rrDaoImplementation = (rrDaoImplementation) appContext.getBean("rrDaoImplementation");
		rrDaoImplementation.insert(rateReview);
		response.sendRedirect("restaurant");

	}

	private void show_reviewform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String restaurant = request.getParameter("key_id");
		String restaurant_Name = request.getParameter("key_restName");
		String restaurant_loc = request.getParameter("key_restloc");
		request.setAttribute("rrid", restaurant);
		request.setAttribute("rrname", restaurant_Name);
		request.setAttribute("rrloc", restaurant_loc);
		request.getRequestDispatcher("/WEB-INF/jsp/view/reviewform.jsp").forward(request, response);

	}

	private void back_home(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("restaurant");
		return;
	}

	private void show_review(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SecurityException {
		// TODO Auto-generated method stub
		String restaurant = request.getParameter("key");
		String restaurant_Name = request.getParameter("key_Name");
		String restaurant_loc = request.getParameter("key_loc");
		ServletContext servletContext = getServletContext();
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		rrDaoImplementation rrDaoImplementation = (rrDaoImplementation) appContext.getBean("rrDaoImplementation");

		List<?> rate = null;
		rate = (List<?>) rrDaoImplementation.gettAllRatenReview();
		System.out.println("Review Sati" + restaurant);
		request.setAttribute("rrid", restaurant);
		request.setAttribute("rrname", restaurant_Name);
		request.setAttribute("rrloc", restaurant_loc);
		request.setAttribute("rate_review", rate);
		request.getRequestDispatcher("/WEB-INF/jsp/view/reviewpage.jsp").forward(request, response);
	}

}
