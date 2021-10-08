<%--
  Created by IntelliJ IDEA.
  User: Ajit.Mishra
  Date: 20-05-2020
  Time: 16:00
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title>forget password confirmation</title>
</head>

<body>
<div class="row">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
            <div class="card-body">
                <h5 class="card-title text-center">Forget Password confirmation</h5>
                <hr class="my-4">
                <label class="card-title text-left font-weight-light font-weight-bold">Instruction to re-set password has been mailed to you.</label>
                <g:link controller="login">Login here</g:link>
                <hr class="my-4">
            </div>
        </div>
    </div>
</div>
</body>
</html>