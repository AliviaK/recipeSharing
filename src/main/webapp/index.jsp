<%@include file="head.jsp"%>

<header>
    <h1>Search Users</h1>
</header>

<form action="searchUser" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" class="searchTerm">
    </div>
    <button class="btn btn-info" type="submit" name="submit" value="searchLast">Search by last name</button>
    <button type="submit" name="submit" value="searchFirst">Search by first name</button>
    <button type="submit" name="submit" value="searchAll">See All Users</button>
</form>

<%@include file="footer.jsp"%>
