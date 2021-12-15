<!DOCTYPE html>
<html lang="en" class="h-100">

<%@include file="taglib.jsp"%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${title}</title>

    <script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- The next two items are to support jQuery datatables. Learn more about datatables here:https://datatables.net -->
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
    <!-- used for add, edit, delete icons -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!-- css for datepicker -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <!-- Personal CSS -->
    <link rel="stylesheet" href="styles/styles.css">
    <!-- Personal JavaScript -->
    <script src="js/mainFunctions.js"></script>

</head>

<body class="d-flex flex-column h-100">
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid align-items-end">
            <div class="navbar-brand"><img src="images/RAFLogo.png"></div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link link-dark m-2 fw-bold">Home</a>
                    </li>
                    <c:choose>
                        <c:when test="${empty userName}">
                            <li class="nav-item">
                                <a href = "logIn" class="nav-link link-dark m-2 fw-bold">Log in</a>
                            </li>
                            <li class="nav-item">
                                <a href="viewParties.jsp" class="nav-link link-dark m-2 fw-bold">View My Parties</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>Welcome ${userName}</li>
                            <li class="nav-item">
                                <a href="viewProfile" class="nav-link link-dark m-2 fw-bold">Profile</a>
                            </li>
                            <li class="nav-item">
                                <a href="viewParties.jsp" class="nav-link link-dark m-2 fw-bold">View My Parties</a>
                            </li>
                            <li class="nav-item">
                                <a href="addRecipe.jsp" class="nav-link link-dark m-2 fw-bold">Add Recipe</a>
                            </li>
                            <li class="nav-item">
                                <a href="logOut" class="nav-link link-dark m-2 fw-bold">Log Out</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid">