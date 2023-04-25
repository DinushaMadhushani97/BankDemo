package com.fund;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FundInsert")
public class FundInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String accNo = request.getParameter("accNo");
		String branch = request.getParameter("branch");
		String amount = request.getParameter("amount");
		String message = request.getParameter("message");
		
		
		boolean isTrue;
		
		isTrue = FundDBUtil.insertfund(name, accNo, branch, amount, message);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}

