<%@include file="head.jsp"%>

<header class="text-center">
    <h1>Add a New Recipe</h1>
</header>

<form method="post" action="add-recipe" class="w-75 mx-auto">
    <div class="row m-3 align-items-center">
        <div class="form-group col-6">
            <label for="name">Recipe Name: </label>
            <input type="text" class="form-control" id="name" name="name" class="name" placeholder="Recipe Name">
        </div>
        <div class="form-check col-6">
            <input class="form-check-input" type="checkbox" name="isPublic" id="isPublic">
            <label class="form-check-label" for="isPublic">This is a Public Recipe </label>
        </div>
        <div class="form-group col-12">
            <label for="notes">Description: </label>
            <input type="text" class="form-control" id="notes" name="notes" class="notes" maxlength="100"
                   placeholder="Add a short description about your recipe">
        </div>
    </div>

    <div class="row m-3" id="addIngredientDiv">
        <div class="form-group col-6">
            <label for="ingredient0">Ingredient: </label>
            <input type="text" class="form-control" id="ingredient0" name="ingredient[]" placeholder="Ingredient Name">
        </div>
        <div class="form-group col-6">
            <label for="quantity0">Quantity: </label>
            <input type="text" class="form-control" id="quantity0" name="quantity[]" placeholder="ex. 1/4 tsp">
        </div>
    </div>

    <div class="row m-3">
        <div class="col-12 mt-2">
            <button class="purpleButton text-white font-weight-bold mt-1" type="button" id="addIngredient">Add another ingredient</button>
        </div>
    </div>

    <div class="row m-3" id="addStepDiv">
        <div class="form-group col-sm-1">
            <label for="order0">Step #: </label>
            <input type="text" class="form-control" id="order0" name="order[]"  value="1">
        </div>
        <div class="form-group col-sm-11">
            <label for="direction0">Directions: </label>
            <textarea class="form-control" id="direction0" name="direction[]" rows="2" maxlength="400"></textarea>
        </div>
    </div>

    <div class="row m-3">
        <div class="col-12 mt-2">
            <button class="purpleButton text-white font-weight-bold mt-1" type="button" id="addStep">Add another step</button>
        </div>

        <div class="col-12 p-2 mt-2">
            <button class="blueButton mt-1" type="submit" id="createRecipe" value="createRecipe">Add new recipe</button>
        </div>
    </div>
</form>

<p>${confirmation}</p>
<c:remove var="confirmation" scope="session" />

<%@include file="footer.jsp"%>