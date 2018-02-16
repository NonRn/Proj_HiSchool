<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form action="TaskList.jsp" method="GET">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle btn-fullwidth-dropdown" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            วิชา
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <select id="subjects" name="subjectslist">
                                <c:forEach items="${subject.s_no}" var="subject">
                                    <option value="${subject.s_no}">
                                        <li>
                                            <a class="dropdown-item" href="#">${subject.s_name}</a>
                                        </li>
                                    </option>
                                </c:forEach>
                            </select>
                        </ul>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle btn-fullwidth-dropdown" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            ห้อง
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <select id="rooms" name="roomslist">
                                <c:forEach items="${room.r_no}" var="room">
                                    <option value="${room.r_no}">
                                        <li>
                                            <a class="dropdown-item" href="#">${room.r_name}</a>
                                        </li>
                                    </option>
                                </c:forEach>
                            </select>
                        </ul>
                    </div>
                </form>
                <button type="submit" class="btn btn-secondary btn-fullwidth">ค้นหา</button>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-4 bg-grey"></div>
            <div class="col-12 col-md-8 profile-top">
                    <c:forEach items="${task.task_no}" var="task">
                        <option value="${task.task_no}">
                            <p class="profile-details">${task.task_name}</p>
                            <p class="profile-label">${category.c_name} / ${task.deadline}</p>
                        </option>
                    </c:forEach>
            </div>
        </div>
</body>

</html>