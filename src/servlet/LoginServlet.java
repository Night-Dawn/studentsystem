package servlet;

import dao.Impl.StudentDaoImpl;
import dao.Student;
import service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl us = new UserServiceImpl();
        String name = request.getParameter("loginusername");
        String pass = request.getParameter("loginpassword");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        try {
            if(name!=null && pass!=null && us.userLogin(name,pass))
            {
                List<Student> list =studentDao.querryALL(0,10);
                HttpSession session = request.getSession(true);
                session.setAttribute("currentUser",name);
                session.setAttribute("key_list",list);
                response.sendRedirect("second.jsp");
                request.getRequestDispatcher("second.jsp").forward(request, response);

            }
            else
            {
               out.println("<script language='javascript'>alert('用户名或密码输入错误！');window.location.href='index.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
