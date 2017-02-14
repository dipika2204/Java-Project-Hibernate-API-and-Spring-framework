package com.project1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project2.Implementation.restDaoImplementation;
import com.project2.Model.Rest;
@WebServlet(name = "adminServlet", urlPatterns = { "/admin" }, loadOnStartup = 1)
public class AdminServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/view/admin.jsp").forward(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String restName=request.getParameter("restaurant_name");
		String rest_location=request.getParameter("location");
		
		System.out.println("ADMIN"+restName);
		
		ServletContext servletContext = getServletContext();
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		restDaoImplementation restDaoImplementation = (restDaoImplementation) appContext
				.getBean("restDaoImplementation");

		/** insert **/
		
		Rest rest = new Rest();
		rest.setRestName(restName);
		rest.setLocation(rest_location);
		restDaoImplementation.insert(rest);
	
		response.sendRedirect("admin");
		

	}

}
