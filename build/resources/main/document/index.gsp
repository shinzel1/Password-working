<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
    #mySearch {
        width: 100%;
        font-size: 18px;
        padding: 11px;
        border: 1px solid #ddd;
    }
    .search-container{
        position: absolute;
        padding: 10px;
    }
    .search-result{
        position:relative;
        background: white;
        width: 75%;
        padding: 5px;
        border:1px solid grey;
        text-align: center;

    }
    </style>
</head>

<body>
    <!-- Sidebar-->
    <div class="sidenav" style="width: 200px;" id="sidebar-wrapper">
        <div class="w3-sidebar w3-bar-block w3-light-grey w3-card" style="width:20%; height: 75%;position:absolute" >
            %{--            <input type="text" id="mySearch"  placeholder="Search.." title="Type in a category">--}%
            <div class="search-container my-3">

                <g:form action="index">
                    <label for=>Search here</label>

                    <g:textField name="searchText" />
                    <g:submitButton name="search" value="Search"/>
                </g:form>
                <div class=search-result>
                    <g:each in="${documents}" var="doc" status="i">
                        <ul>
                            <a href="#" class="w3-bar-item w3-button"><li>${doc.name}</li></a>
                        </ul>
                    </g:each>
                </div>




                <div class="w3-dropdown-hover">
                    <button class="w3-button">Documents
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="w3-dropdown-content w3-bar-block">
                        <ul>
                            <g:each in="${document}" var="doc" status="i">

                                <li><a href="#" class="w3-bar-item w3-button"><ul>${i+1}. ${doc.name}</ul></a></li>

                            </g:each>
                        </ul>

                    </div>
                </div>
                <a href="#" class="w3-bar-item w3-button">PDFs</a>
                <a href="#" class="w3-bar-item w3-button">ZIP</a>
                <a href="#" class="w3-bar-item w3-button">CSV</a>
            </div>
        </div>
    </div>

        <div style="margin-left: 300px">
            <nav class="navbar" style="color: #062c33">
                <div class="container-fluid">
                    <button type="button" class="btn btn-outline-secondary"><g:link class="list" action="list">Upload New Document</g:link></button>

                </div>
            </nav>
                <h1 style="margin-left: 30px">
                    Document Page
                </h1>



<g:uploadForm action="upload">
    <input type="file" name="docToUpload"/>
    <input type = text  name = "tagsToSave"/>
    <g:submitButton name="Upload document" />
</g:uploadForm>

            <g:link controller="user" action="forgotPassword">forgotPassword</g:link>
    </body>
</html>