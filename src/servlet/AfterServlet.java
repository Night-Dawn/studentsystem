package servlet;

import dao.Impl.StudentDaoImpl;
import dao.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AfterServlet",urlPatterns = "/after")
public class AfterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        int i=Integer.parseInt(request.getParameter("page"));
        response.setContentType("text/javascript;charset=utf-8");
        PrintWriter out =response.getWriter();
        try
        {
            int pages =i+1;
            out.println("$('#page').val("+pages+")");
            pages=pages*10;
            List<Student> list =studentDao.querryALL(pages-10,pages);
            out.println("var carousel = $('#carousel').empty();");
            for (Student student :list)
            {
                out.println("carousel.append(\"<div id='data' style='margin: 20px;'><input type='checkbox'><div class='datalist'><span class='data'>"+student.getStudent_ID()+"</span><span class='data'>"+student.getStudent_Name()+"</span><span class='data'>"+student.getStudent_Sex()+"</span><span class='data'>"+student.getStudent_Age()+"</span><span class='data'>"+student.getStudent_Telephone()+"</span><span class='data'>"+student.getStudent_Class()+"</span><span class='data'>"+student.getStudent_Birthday()+"</span><span class='data'>"+student.getStudent_Nativeplace()+"</span><span class='data'>"+student.getStudent_Nation()+"</span><span class='data'>"+student.getStudent_Major()+"</span></div></div>\")");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
