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

@WebServlet(name = "CreateServlet",urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
    Student student=null;
    StudentDaoImpl studentDao = new StudentDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javascript;charset=utf-8");
        PrintWriter out =response.getWriter();
        int page =Integer.parseInt(request.getParameter("page"));
        try
        {
            student=new Student();
            student.setStudent_ID(Integer.parseInt(request.getParameter("stu_id")));
            student.setStudent_Name(request.getParameter("stu_name"));
            student.setStudent_Sex(request.getParameter("stu_sex"));
            student.setStudent_Age(Integer.parseInt(request.getParameter("stu_age")));
            student.setStudent_Telephone(Long.parseLong(request.getParameter("stu_phone")));
            student.setStudent_Class(request.getParameter("stu_class"));
            student.setStudent_Birthday(request.getParameter("stu_birth"));
            student.setStudent_Nativeplace(request.getParameter("stu_place"));
            student.setStudent_Nation(request.getParameter("stu_nation"));
            student.setStudent_Major(request.getParameter("stu_major"));
            studentDao.insert(student);

            page=page*10;
            List<Student> list =studentDao.querryALL(page-10,page);
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
