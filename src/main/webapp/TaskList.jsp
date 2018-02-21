<%@page import="model.Task"%>
<%@page import="model.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Subject"%>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/favicon.png" sizes="32x32" />
        <title>Task on Hi! School</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/HiSchool.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/HiSchool.js"></script>
    </head>

    <body>
        <jsp:include page="header.jsp" />
        <!--<nav class="navbar navbar-light bg-hischool">
            <a class="navbar-brand" href="#">
                <img src="assets/HiSchool Icon.png" height="30" alt="">
            </a>
        </nav>-->
        <div class="container Top-Margin">
            <div class="row">
                <div class="col-12 col-md-4 text-center bg-grey">

                </div>
                <div class="col-12 col-md-8">
                    <h1>งาน</h1>
                    <form name="listSubjects" action="TeacherTaskServlet" method="GET" onchange="document.listSubjects.submit();">
                        <select id="subjects" class="form-control btn-fullwidth-dropdown" name="subjectslist">
                            <option value="" hidden>วิชา</option>
                            <%
                                ArrayList<Subject> ars = (ArrayList) request.getAttribute("subject");
                                for (Subject s : ars) {
                                    if (request.getAttribute("subSelect") != null) {
                                        if (Integer.parseInt((String) request.getAttribute("subSelect")) == s.getS_no()) {%>
                            <option value="<%= s.getS_no()%>" selected>                                  
                                <%= s.getS_name()%>
                            </option>
                            <% } else {%> 
                            <option value="<%= s.getS_no()%>">                                  
                                <%= s.getS_name()%>
                            </option>
                            <%}
                            } else {%>
                            <option value="<%= s.getS_no()%>">                                  
                                <%= s.getS_name()%>
                            </option>
                            <% }
                                } %>      
                        </select>
                    </form>
                    <% if (request.getAttribute("room") != null) {%>
                    <form name="listRooms" action="TeacherTaskServlet" method="GET" onchange="document.listRooms.submit();">
                        <input type="hidden" name="subjectSelect" value="<%=Integer.parseInt((String) request.getAttribute("subSelect"))%>">
                        <select id="rooms" class="form-control btn-fullwidth-dropdown" name="roomslist">
                            <option value="" hidden>ห้อง</option>
                            <%
                                ArrayList<Room> ars2 = (ArrayList) request.getAttribute("room");
                                for (Room r : ars2) {
                                    if (request.getAttribute("roomSelect") != null) {
                                        if (Integer.parseInt((String) request.getAttribute("roomSelect")) == r.getR_no()) {
                            %>
                            <option value="<%= r.getR_no()%>" selected>                                  
                                <%= r.getR_name()%>
                            </option>
                            <% } else {%> 
                            <option value="<%= r.getR_no()%>">                                  
                                <%= r.getR_name()%>
                            </option>
                            <% } %> 
                            <% } else {%>
                            <option value="<%= r.getR_no()%>">                                  
                                <%= r.getR_name()%>
                            </option>
                            <% }} %>
                        </select>
                    </form>
                     <% } %>
                    <!--<button type="submit" class="btn btn-secondary btn-fullwidth">ค้นหา</button>-->
                </div>
            </div>
            <% if (request.getAttribute("task") != null) {%>
            <div class="row">
                <div class="col-12 col-md-4 bg-grey">
                    <center><button class="btn btn-secondary text-center" type="button">
                        <a href="profile.jsp">ข้อมูลส่วนตัว</a>
                    </button></center>
                    <center><button class="btn btn-secondary text-center" type="button">
                        <a href="AddTask.jsp">เพิ่มงาน</a>
                    </button></center>
                </div>
                <div class="col-12 col-md-8 profile-top">
                    <%
                        ArrayList<Task> ars3 = (ArrayList) request.getAttribute("task");
                        for (Task task : ars3) {
                    %>
                    <option value="<%= task.getTask_No()%>">
                    <p class="profile-details"><%= task.getTask_Name()%></p>
                    <p class="profile-label"><%=task.getDeadline()%></p>
                    <p class="profile-label"><%=task.getDescription()%></p>
                    </option>
                    <% } %>
                </div>
            </div>
            <% }%>
        </div>
    </body>

</html>