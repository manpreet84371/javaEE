package com.auribises.retrieve;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EE2Session.Response;
import com.EE2Session.User;
import com.auribises.db.JDBCHelper;
import com.google.gson.Gson;


@WebServlet("/RetrieveUserServlet")
public class RetrieveUserServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		ArrayList<User> users = helper.retrieveUsers();
				helper.closeConnection();
		
		Response res = new Response();
		
		if(users!=null && users.size()>0){
			res.success = 1;
			res.message = "Users Retrieved Successfully";
			res.users = users;
		}else{
			res.success = 0;
			res.message = "Users Not Found";
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(res);
		
		out.print(json); 
	}

}
