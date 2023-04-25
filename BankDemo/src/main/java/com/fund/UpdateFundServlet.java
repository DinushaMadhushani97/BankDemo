package com.fund;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateFundServlet")
public class UpdateFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String accNo = request.getParameter("accNo");
		String branch = request.getParameter("branch");
		String amount = request.getParameter("amount");
		String message = request.getParameter("message");
		
		boolean isTrue;
		
		isTrue = FundDBUtil.updatefund(id,name,accNo,branch,amount,message);
		
		if(isTrue == true) {
			
			List<Fund> payDetails = FundDBUtil.getFundDetails(id);
			request.setAttribute("payDetails", payDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
			dis.forward(request, response);
		}
		else {
			List<Fund> payDetails = FundDBUtil.getFundDetails(id);
			request.setAttribute("payDetails", payDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("unsucess.jsp");
			dis.forward(request, response);
		}
	}

}
