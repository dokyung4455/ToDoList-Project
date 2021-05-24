package com.callor.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqController {

	
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String file) throws ServletException, IOException {
		String reqFile = "/WEB-INF/views/" + file +".jsp";
		
		req.getRequestDispatcher(reqFile).forward(req, resp);
		
		
	}
	

}
