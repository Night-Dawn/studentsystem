<%@ page import="dao.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Night_Dawn
  Date: 2018/12/26
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/index.js"></script>
</head>
<body>
<img id="backgroundimage" src="images/background.png"  height="99.5%" width="100%"  style="opacity: 0.8; background-size: cover;"/>
<div class="maindiv"></div>
<div class="content">
    <span style="font-size: 20px;">
        当前用户:${sessionScope.currentUser}
    </span>
    <div style="float: right">
        <button class="curd" id="CreateButton"  onclick="showCreate()">增加</button>
        <button class="curd" id="UpdateButton" onclick="showUpdate()">修改</button>
        <button class="curd" id="RetrieveButton" onclick="showRetrieve()">查询</button>
        <button class="curd" id="DeleteButton" onclick="deletedata()">删除</button>

    </div>

    <div style="color: white;margin-top: 80px;" >
        <div style="margin: 20px"><span class="data">学号</span> <span class="data">姓名</span><span class="data">性别</span><span class="data">年龄</span><span class="data">电话</span><span class="data">班级</span><span class="data">出生年月</span><span class="data">出生地</span><span class="data">民族</span><span class="data">专业</span></div>
        <div id="carousel">
      <%
            List<Student> list = (List<Student>)request.getSession().getAttribute("key_list");
            for(Student student:list){
      %>
        <div id="data" style="margin: 20px;"><input type="checkbox"><div id="deletediv" class="datalist"><span  class="data"><%=student.getStudent_ID()%></span><span class="data"><%=student.getStudent_Name()%></span><span class="data"><%=student.getStudent_Sex()%></span><span class="data"><%=student.getStudent_Age()%></span><span class="data"><%=student.getStudent_Telephone()%></span><span class="data"><%=student.getStudent_Class()%></span><span class="data"><%=student.getStudent_Birthday()%></span><span class="data"><%=student.getStudent_Nativeplace()%></span><span class="data"><%=student.getStudent_Nation()%></span><span class="data"><%=student.getStudent_Major()%></span></div></div>
        <%}%>
        </div>
    </div>
    <form><input type="button" id="initbutton" onclick="initPages()" value="上一页"/>当前页数:<input style="width: 50px;" disabled="disabled" type="number" name="page" id="page" value="1"/><input type="button" id="presbutton" onclick="presPages()" value="下一页"/></form>
</div>
<div id="creatediv">
    <form id="form">
        <p style="font-size: 20px;margin: 20px;">添加学生信息</p>
        <div style="margin-left: 30px;margin-top: 40px">
            学号<input type="text" name="stu_id" id="stu_id">(格式10位)<br>
            姓名<input type="text" name="stu_name" id="stu_name"><br>
            性别<input type="text" name="stu_sex" id="stu_sex"><br>
            年龄<input type="text" name="stu_age" id="stu_age"><br>
            电话<input type="text" name="stu_phone" id="stu_phone">(格式11位)<br>
            班级<input type="text" name="stu_class" id="stu_class"><br>
            出生年月<input type="text" name="stu_birth" id="stu_birth">(格式yyyyMMdd)<br>
            出生地<input type="text" name="stu_place" id="stu_place"><br>
            民族<input type="text" name="stu_nation" id="stu_nation"><br>
            专业<input type="text" name="stu_major" id="stu_major"><br>


        </div>
        <div style="margin-left:  30px;margin-top: 40px">
            <input style="margin-left: 80px" type="button" onclick="Create();" value="提交" ><input style="margin-left: 100px" type="reset">
        </div>
    </form>
</div>
<div id="retrievediv">
    <form  method="post" >
        <p style="font-size: 20px;margin: 20px;">查询学生信息</p>
        <div style="margin-left: 30px;vertical-align: center;margin-top: 40px" >
            学号:<input name="retrieve_id" id="retrieve_id" type="text">(格式10位)
        </div>
        <div style="margin-left:  30px;margin-top: 40px">
            <input style="margin-left: 80px" type="button" onclick="Retrieve();" value="提交" ><input style="margin-left: 100px" type="reset">
        </div>
    </form>
</div>
<div id="updatediv">
    <form >
        <p style="font-size: 20px;margin: 20px;">添加学生信息</p>
        <div style="margin-left: 30px;margin-top: 40px">
            学号<input type="text" name="update_id" id="update_id"><br>
            姓名<input type="text" name="update_name" id="update_name"><br>
            性别<input type="text" name="update_sex" id="update_sex"><br>
            年龄<input type="text" name="update_age" id="update_age"><br>
            电话<input type="text" name="update_phone" id="update_phone">(格式11位)<br>
            班级<input type="text" name="update_class" id="update_class"><br>
            出生年月<input type="text" name="update_birth" id="update_birth">(格式yyyyMMdd)<br>
            出生地<input type="text" name="update_place" id="update_place"><br>
            民族<input type="text" name="update_nation" id="update_nation"><br>
            专业<input type="text" name="update_major" id="update_major"><br>
        </div>
        <div style="margin-left:  30px;margin-top: 40px">
            <input style="margin-left: 80px" type="button" onclick="Update();" value="提交" ><input style="margin-left: 100px" type="reset">
        </div>
    </form>
</div>
</body>
</html>
