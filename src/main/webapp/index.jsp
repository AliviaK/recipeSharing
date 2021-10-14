<%@include file="head.jsp"%>
<html>
<body>

<h2>User Display Exercise</h2>
<form action="searchUser" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" class="searchTerm">
    </div>
    <button class="btn btn-info" type="submit" name="submit" value="searchLast">Search by last name</button>
    <button type="submit" name="submit" value="searchFirst">Search by first name</button>
    <button type="submit" name="submit" value="searchAll">See All Users</button>
</form>
</body>
</html>