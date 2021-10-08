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
    <title>forget password</title>
</head>
<body>
<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
    <div class="card card-signin my-5">
        <div class="card-body">
            <h5 class="card-title text-center">Forget Password</h5>
            <label class="card-title text-left font-weight-light font-weight-bold">Enter Your e-mail address and we'll send you a link to reset your password.</label>
            <hr class="my-4">
            <g:if test='${flash.message}'>
                <div class="alert alert-danger" role="alert">${flash.message}</div>
            </g:if>
            <g:form name="myForm" action="invite" id="forgetForm" onsubmit="return validateForm()" autocomplete="off">
                <div class="form-group">
                    <label for="username">E-mail</label>
                    <input placeholder="e-mail address" type="text" class="form-control" name="${usernameParameter ?: 'username'}" id="username" autocapitalize="none"/>
                </div>
                <p><g:link controller="login" action="auth">You can login here</g:link></p>
                <hr class="my-4">

                <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Next</button>

            </g:form>

        </div>
    </div>
</div>

<script type="text/javascript">

    document.addEventListener("DOMContentLoaded", function(event) {
        $("#username").focus();
    });

    function validateForm() {

        let username = $("#username").val().trim();
        if (username === "") {
            $("#username").val("");
            $("#username").focus();
            swal.fire("Email must be filled out");
            return false;
        }
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(username))
        {
            return true;

        }
        alert("You have entered an invalid email address!");
        return false;

    }

</script>
</body>
</html>