<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>

    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/favicon.png" sizes="32x32" />
        <title>${teacher.t_name} on Hi! School</title>
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
                    <img src="assets/Non.png" class="profilepic">
                </div>
                <div class="col-12 col-md-8">
                    <h1>${teacher.t_name} ${teacher.t_lastname}</h1>
                    <h4>คุณครูประจำชั้นห้อง ${room.r_name}</h4>
                    <button type="button" class="btn btn-secondary">แก้ไขข้อมูลส่วนตัว</button>
                </div>
            </div>
            <div class="row">
                <div class="col-12 col-md-4 bg-grey">
                    <center><button class="btn btn-secondary text-center" type="button">
                        <a href="TaskList.jsp">งาน</a>
                    </button></center>
                </div>
                <div class="col-12 col-md-8 profile-top">
                    <p class="profile-label">เลขประจำตัวประชาชน</p>
                    <p class="profile-details">${teacher.national_id}</p>
                    <p class="profile-label">เลขประจำตัวครู</p>
                    <p class="profile-details">${teacher.t_no}</p>
                    <p class="profile-label">เพศ</p>
                    <p class="profile-details">${teacher.gender}</p>
                    <p class="profile-label">ที่อยู่</p>
                    <p class="profile-details">${teacher.address}</p>
                    <p class="profile-label">อีเมล</p>
                    <p class="profile-details">${teacher.email}</p>
                    <p class="profile-label">เบอร์โทรศัพท์</p>
                    <p class="profile-details">${teacher.tel}</p>
                </div>
            </div>
    </body>

    </html>