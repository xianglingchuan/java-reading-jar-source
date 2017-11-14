package com.javax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.bean.Message;
import com.mybatis.service.MessageService;

/**
 * 自动回复功能控制层 
 */
@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();		
		
		MessageService service = new MessageService();
		Message message = new Message();
		List<Message> list =   service.queryList(message);
		System.out.println("list.size:"+list.size());
		
		
		String resultStr = "Hello world";
		out.write(resultStr);
		out.close();
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}	
	
}

