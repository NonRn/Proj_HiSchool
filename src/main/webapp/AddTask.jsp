<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" type="image/png" href="assets/favicon.png" sizes="32x32" />
    <title>Add Task on Hi! School</title>
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
                <h1>เพิ่มงาน</h1>
                <h4>วิชา ${Subject.s_name} ห้อง ${Room.r_name}</h4>
                <form action="AddTask.jsp" method="POST">
                    <div class="form-group">
                        <p class="profile-label">ชื่องาน</p>
                        <input type="text" class="form-control btn-fullwidth-dropdown" id="taskname" placeholder="คัดลายมือ">
                    </div>
                    <div class="form-group">
                        <p class="profile-label">คะแนนเต็ม</p>
                        <input type="number" class="form-control btn-fullwidth-dropdown" id="score" placeholder="10">
                    </div>
                    <div class="form-group">
                        <p class="profile-label">วันกำหนดส่ง</p>
                        <input type="date" class="form-control btn-fullwidth-dropdown" id="deadline" placeholder="">
                    </div>
                    <div class="form-group">
                        <p class="profile-label">รายละเอียด</p>
                        <input type="text" class="form-control btn-fullwidth-dropdown" id="description" placeholder="งานง่าย ๆ ก็ช่วย ๆ กันทำนะ นะ">
                    </div>
                    <div class="form-group">
                        <p class="profile-label">หมวดหมู่</p>
                        <select class="form-control btn-fullwidth-dropdown" id="c_no">
                            <option>1</option>
                            <option>2<!--loop รอพี่ก่อนนะจ๊ะ--></option>
                          </select>
                    </div>
                </form>
                <button type="submit" class="btn btn-secondary btn-fullwidth">บันทึก</button>
            </div>
        </div>
    </div>
</body>

</html>