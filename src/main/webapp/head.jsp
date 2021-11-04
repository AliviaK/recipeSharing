<!DOCTYPE html>

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
    <link rel="stylesheet" href="resources/styles.css">
    <!-- Personal JavaScript -->
    <script src="js/mainFunctions.js"></script>

</head>

<body>
    <div class="container-fluid">
            <nav class="navbar navbar-expand-lg p-2 m-2">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Recipes Among Friends</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <c:choose>
                                <c:when test="${empty userName}">
                                    <li class="nav-item">
                                        <a href = "logIn">Log in</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <a class="navbar-brand">Welcome ${userName}</a>
                                    <li class="nav-item">
                                        <a href="viewProfile.jsp" class="text-white">Profile</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                            <li class="nav-item">
                                <a href="index.jsp" class="nav-link text-white">Home</a>
                            </li>
                            <li class="nav-item">
                                <a href="recipeSearch.jsp" class="nav-link text-white">Recipe Search</a>
                            </li>
                            <li class="nav-item">
                                <a href="addRecipe.jsp" class="nav-link text-white">Add Recipe</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>