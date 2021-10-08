<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="21cceducation"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="logo1.png" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
    <style>
    #header{
        background-color: dimgrey;
        width:100%;
        height:100px;
        box-shadow: 0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24);
    }
    .header img{
        width: 90px;
        height: 60px;
        position: relative;
        margin-left: 30px;
        margin-top: 15px;
    }
    #foter{
        clear:both;
        position: fixed;
        height: 70px;
        width: 100%;
        bottom: 0;
        left: 0;
        right: 0;
    }

    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
    <a class="navbar-brand" href="/#"><asset:image src="logo.png" alt="21cceducation"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">
            <g:pageProperty name="page.nav"/>
        </ul>
    </div>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <sec:access expression="hasRole('ROLE_ADMIN')">
                <p style="color: white; text-align: center"> "Logged in as Administrator"</p>
            </sec:access>
        </li>

        <li class="nav-item">

            <a class="nav-link" href="#"><sec:loggedInUserInfo field='username'/></a>
        </li>
        <li class="nav-item controller">
            <sec:ifLoggedIn>
                <g:link controller="logout">(logout)</g:link>
            </sec:ifLoggedIn>

        </li>
    </ul>
</nav>

<g:layoutBody/>

<div class="footer " style="position:absolute; bottom:0; width:100%;" role="contentinfo">
    <div class="row">
        <div class="col">
            ©copyright
        </div>
        <div class="col">
           ContactUs
        </div>
        <div class="col">
            FAQs
        </div>
    </div>
</div>



<asset:javascript src="application.js"/>

</body>
</html>
