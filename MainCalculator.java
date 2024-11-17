package Simple_Calculator;

import java.util.*;
public class MainCalculator {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		CalculatorLogic cl = new CalculatorLogic();
		
		Boolean input = true;
		do {
			System.out.println("Enter the expression you want to evaluate.");
			String expression = scanner.nextLine();
			cl.ParsingExpression(expression);
			
			System.out.println("Do you want to calcualte again (Yes/No)");
			String opinion = scanner.nextLine();
			if(opinion.equalsIgnoreCase("Yes")) {
				input = true;
			}
			else {
				input = false;
			}
		}while(input);
		
		scanner.close();
	}
}
