/**
 * Counter for ingredient addons
 * @type {number}
 */
let ingredienti = 1;

/**
 * Counter for step addons
 * @type {number}
 */
let stepi = 1;

/**
 * Method onload to add event listeners
 */
const init = () => {
    document.querySelector("#addIngredient").addEventListener("click", processAddIngredientClick);
    document.querySelector("#addStep").addEventListener("click", processAddStepClick);
}

/**
 * Method to process clicking of Add Another Ingredient button
 */
const processAddIngredientClick = () => {

    /* Create div for ingredient */
    let ingredientTypeDiv = document.createElement('div');
    ingredientTypeDiv.setAttribute("class", "form-group col-6");
    ingredientTypeDiv.setAttribute("id", "ingredientTypeDiv" + ingredienti);

    /** Create Ingredient label */
    let labelForIngredient = document.createElement('label');
    labelForIngredient.setAttribute("for", "ingredient" + ingredienti);
    labelForIngredient.innerText = "Ingredient:";

    /** Create Ingredient input */
    let ingredientInput = document.createElement('input');
    ingredientInput.setAttribute("type", "text");
    ingredientInput.setAttribute("class", "form-control");
    ingredientInput.setAttribute("id", "ingredient" + ingredienti);
    ingredientInput.setAttribute("name", "ingredient[]");

    /* Create div for amount */
    let amountDiv = document.createElement('div');
    amountDiv.setAttribute("class", "form-group col-6");
    amountDiv.setAttribute("id", "amountDiv" + ingredienti);

    /** Create Amount label */
    let labelForAmount = document.createElement('label');
    labelForAmount.setAttribute("for", "quantity" + ingredienti);
    labelForAmount.innerText = "Quantity:";

    /** Create Amount input */
    let amountInput = document.createElement('input');
    amountInput.setAttribute("type", "text");
    amountInput.setAttribute("class", "form-control");
    amountInput.setAttribute("id", "quantity" + ingredienti);
    amountInput.setAttribute("name", "quantity[]");

    /** Add ingredient elements to form */
    document.getElementById("addIngredientDiv").appendChild(ingredientTypeDiv);
    document.getElementById("ingredientTypeDiv" + ingredienti).appendChild(labelForIngredient);
    document.getElementById("ingredientTypeDiv" + ingredienti).appendChild(ingredientInput);

    /** Add amount elements to form */
    document.getElementById("addIngredientDiv").appendChild(amountDiv);
    document.getElementById("amountDiv" + ingredienti).appendChild(labelForAmount);
    document.getElementById("amountDiv" + ingredienti).appendChild(amountInput);

    ingredienti++;
}

/**
 * Method to process clicking of Add Another Step button
 */
const processAddStepClick = () => {
    /** Create div to store order input and label */
    let orderDiv = document.createElement('div');
    orderDiv.setAttribute("class", "form-group col-1");
    orderDiv.setAttribute("id", "orderDiv" + stepi);

    /** Create Order label */
    let labelForOrder = document.createElement('label');
    labelForOrder.setAttribute("for", "order" + stepi);
    labelForOrder.innerText = "Order #:";

    /** Create Order input */
    let orderInput = document.createElement('input');
    orderInput.setAttribute("type", "text");
    orderInput.setAttribute("class", "form-control");
    orderInput.setAttribute("id", "order" + stepi);
    orderInput.setAttribute("name", "order[]");
    orderInput.setAttribute("value", '' + (stepi + 1) + '');

    /** Create div to store direction input and label */
    let stepDiv = document.createElement('div');
    stepDiv.setAttribute("class", "form-group col-11");
    stepDiv.setAttribute("id", "stepDiv" + stepi);

    /** Create Direction label */
    let labelForDirection = document.createElement('label');
    labelForDirection.setAttribute("for", "direction" + stepi);
    labelForDirection.innerText = "Step:";

    /** Create Direction input */
    let directionInput = document.createElement('textarea');
    directionInput.setAttribute("class", "form-control");
    directionInput.setAttribute("id", "direction" + stepi);
    directionInput.setAttribute("name", "direction[]");
    directionInput.setAttribute("rows", "2");
    directionInput.setAttribute("maxlength", "400");

    /** Add order elements to form */
    document.getElementById("addStepDiv").appendChild(orderDiv);
    document.getElementById("orderDiv" + stepi).appendChild(labelForOrder);
    document.getElementById("orderDiv" + stepi).appendChild(orderInput);

    /** Add direction elements to form */
    document.getElementById("addStepDiv").appendChild(stepDiv);
    document.getElementById("stepDiv" + stepi).appendChild(labelForDirection);
    document.getElementById("stepDiv" + stepi).appendChild(directionInput);

    stepi++;
}


window.onload = init;