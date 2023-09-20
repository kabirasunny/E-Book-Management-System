package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDaoImpl;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name=req.getParameter("fname");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");
			String password=req.getParameter("password");
			String check=req.getParameter("check");
			
//			System.out.println(name+" "+email+" "+phno+" "+password+" "+check);
			
			User us=new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);
			
			HttpSession session=req.getSession();
			
			if(check!=null) {
			
				UserDaoImpl dao=new UserDaoImpl(DBConnect.getConn());
				
				boolean f2=dao.checkUser(email);
				
				if(f2) {
					
					boolean f=dao.userRegister(us);
					if(f) {
						session.setAttribute("succMsg","Registration Successfully...");
						resp.sendRedirect("register.jsp");
//						System.out.println("User Register Success...");
					}else {
//						System.out.println("Something Wrong On Server...");
						session.setAttribute("errorMsg","Something Wrong On Server...");
						resp.sendRedirect("register.jsp");
					}
					
				}else {
					
					session.setAttribute("errorMsg","User Already Exits Try Another Email id");
					resp.sendRedirect("register.jsp");
				}
			}else {
//				System.out.println("Please check agree terms & conditions");
				session.setAttribute("errorMsg","Please check agree terms & conditions");
				resp.sendRedirect("register.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
