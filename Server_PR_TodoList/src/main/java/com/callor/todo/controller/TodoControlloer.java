package com.callor.todo.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

@WebServlet("/todo/*")
public class TodoControlloer extends HttpServlet {
	TodoService tdService;

	public TodoControlloer() {
		tdService = new TodoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		String rootPath = req.getContextPath();
		System.out.println(rootPath);
		System.out.println(subPath);
		if (subPath.equals("/insert")) {
			TodoVO tdVO = new TodoVO();

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			tdVO.setLi_seq(0L);
			tdVO.setLi_date(sd.format(date));
			tdVO.setLi_time(st.format(date));

			req.setAttribute("TD", tdVO);
			ReqController.forward(req, resp, "insert");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String li_todo = req.getParameter("li_todo");
		String li_date = req.getParameter("li_date");
		String li_time = req.getParameter("li_time");
		String li_place = req.getParameter("li_place");
		TodoVO vo = new TodoVO();
		vo.setLi_todo(li_todo);
		vo.setLi_date(li_date);
		vo.setLi_time(li_time);
		vo.setLi_place(li_place);
		tdService.insert(vo);
		System.out.println(vo.toString());
		resp.sendRedirect("/todo");
	}

}
