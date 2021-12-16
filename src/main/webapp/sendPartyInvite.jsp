<header>
    <h3>Send Party Invite: </h3>
</header>
<div>
    <h4>Recipe to Share Among Friends: ${recipe.name}</h4>
</div>
<form method="post" action="dispatch-email">
    <div>
        <div class="row m-3 align-items-center">
            <div class="form-group col-12">
                <label for="email">Invite by Email Addresses (Separate by comma): </label>
                <input type="text" id="email" name="email" class="form-control">
            </div>
        </div>

        <input type="hidden" id="recipeName" name="recipeName" value="${recipe.name}">

        <div class="row m-3 align-items-center">
            <div class="form-group col-12">
                <label for="details" class="me-auto">Party Details: </label>
                <textarea id="details" name="details" maxlength="150" rows="3"></textarea>
            </div>
        </div>
        <div class="row m-3 align-items-center">
            <div class="form-group col-12">
                <input type="submit" class="blueButton" value="send">
            </div>
        </div>
    </div>
</form>