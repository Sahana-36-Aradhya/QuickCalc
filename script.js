// Get references to elements
const display = document.getElementById("display");
const buttons = document.querySelectorAll(".button");

// Variable to hold the current input expression
let currentInput = "";

// Add click event listeners to buttons
buttons.forEach(button => {
    button.addEventListener("click", function() {
        const value = this.getAttribute("data-value");

        // Handle different button types
        if (value === "=") {
            // Evaluate the expression
            try {
                currentInput = eval(currentInput).toString();
                display.value = currentInput;
            } catch (e) {
                display.value = "Error";
            }
        } else if (value === "c") {
            // Clear the input
            currentInput = "";
            display.value = "";
        } else {
            // Add the value to the current input
            currentInput += value;
            display.value = currentInput;
        }
    });
});
