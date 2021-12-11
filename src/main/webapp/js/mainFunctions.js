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
    ingredientTypeDiv.setAttribute("id", "ingredientTypeDiv" + ingredienti);
    ingredientTypeDiv.setAttribute("class", "form-group col-6");

    /** Create Ingredient label */
    let labelForIngredient = document.createElement('label');
    labelForIngredient.setAttribute("for", "ingredient" + ingredienti);
    labelForIngredient.innerText = "Ingredient:";

    /** Create Ingredient input */
    let ingredientInput = document.createElement('input');
    ingredientInput.setAttribute("type", "text");
    ingredientInput.setAttribute("id", "ingredient" + ingredienti);
    ingredientInput.setAttribute("name", "ingredient");
    ingredientInput.setAttribute("class", "form-control");

    /* Create div for amount */
    let amountDiv = document.createElement('div');
    amountDiv.setAttribute("id", "amountDiv" + ingredienti);
    amountDiv.setAttribute("class", "form-group col-6");

    /** Create Amount label */
    let labelForAmount = document.createElement('label');
    labelForAmount.setAttribute("for", "amount" + ingredienti);
    labelForAmount.innerText = "Quantity:";

    /** Create Amount input */
    let amountInput = document.createElement('input');
    amountInput.setAttribute("type", "text");
    amountInput.setAttribute("id", "amount" + ingredienti);
    amountInput.setAttribute("name", "amount");
    amountInput.setAttribute("class", "form-control");

    /** Add ingredient elements to form */
    document.getElementById("addIngredientDiv").appendChild(ingredientTypeDiv);
    document.getElementById("ingredientTypeDiv" + ingredienti).appendChild(labelForIngredient);
    document.getElementById("ingredientTypeDiv" + ingredienti).appendChild(ingredientInput);

    /** Add amount elements to form */
    document.getElementById("addIngredientDiv").appendChild(amountDiv);
    document.getElementById("amountDiv" + ingredienti).appendChild(labelForAmount);
    document.getElementById("amountDiv" + ingredienti).appendChild(amountInput);

    i++;
}

/**
 * Method to process clicking of Add Another Step button
 */
const processAddStepClick = () => {
    /** Create div to store order input and label */
    let orderDiv = document.createElement('div');
    orderDiv.setAttribute("id", "orderDiv" + stepi);
    orderDiv.setAttribute("class", "form-group col-1");

    /** Create Order label */
    let labelForOrder = document.createElement('label');
    labelForOrder.setAttribute("for", "order" + stepi);
    labelForOrder.innerText = "Order #:";

    /** Create Order input */
    let orderInput = document.createElement('input');
    orderInput.setAttribute("type", "text");
    orderInput.setAttribute("id", "orderNumber" + stepi);
    orderInput.setAttribute("name", "orderNumber");
    orderInput.setAttribute("class", "form-control");

    /** Create div to store direction input and label */
    let stepDiv = document.createElement('div');
    stepDiv.setAttribute("id", "stepDiv" + stepi);
    stepDiv.setAttribute("class", "form-group col-11");

    /** Create Direction label */
    let labelForDirection = document.createElement('label');
    labelForDirection.setAttribute("for", "direction" + stepi);
    labelForDirection.innerText = "Step:";

    /** Create Direction input */
    let directionInput = document.createElement('input');
    directionInput.setAttribute("type", "text");
    directionInput.setAttribute("id", "direction" + stepi);
    directionInput.setAttribute("name", "direction");
    directionInput.setAttribute("class", "form-control");

    /** Add order elements to form */
    document.getElementById("addStepDiv").appendChild(orderDiv);
    document.getElementById("orderDiv" + stepi).appendChild(labelForOrder);
    document.getElementById("orderDiv" + stepi).appendChild(orderInput);

    /** Add direction elements to form */
    document.getElementById("addStepDiv").appendChild(stepDiv);
    document.getElementById("stepDiv" + stepi).appendChild(labelForDirection);
    document.getElementById("stepDiv" + stepi).appendChild(directionInput);

    i++;
}


window.onload = init;