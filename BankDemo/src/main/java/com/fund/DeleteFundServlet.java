package com.fund;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteFundServlet")
public class DeleteFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		
		boolean isTrue;
		
		isTrue = FundDBUtil.deleteFund(id);
		
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<Fund> payDetails = FundDBUtil.getFundDetails(id);
			request.setAttribute("payDetails", payDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("unsucess.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
