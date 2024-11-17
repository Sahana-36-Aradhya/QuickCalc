package Simple_Calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorLogic {

    private List<Double> numbers = new ArrayList<>();
    private List<Character> tokens = new ArrayList<>();
    private String temp = ""; // Temporary string to hold numbers
    
    // this is a method which is used to separate each character as digit or character 
    public void ParsingExpression(String exp) {
    	String expression = exp;
    	
    	//If the expression we took as an inpu is empty then print this statement.
    	if(expression.isEmpty() || expression == null) {
    		System.out.println("Cant evaluate the empty expression.");
    	}
    	
    	// if it contains information then do the following operation
    	else {
    		
    		//till the end of expression keep repeating this operation
    		for(int i=0;i<expression.length();i++) {
    			
    			// c will hold the character at index i
    			char c = expression.charAt(i);
    			
    			// if the c is digit or .(Double) value then append it to the temp variable till you get operator
    			if(Character.isDigit(c) || c=='.') {
    				temp+=c;
    			}
    			// if you come accross the operator then add the value in temp to numbers list then add the operator to tokens list
    			else if(c=='+' || c=='-'|| c=='*' || c=='/') {
    				numbers.add(Double.parseDouble(temp));
    				temp="";
    				
    				tokens.add(c);
    			}
    			
    			//if you come across the space just skip and continue the rest of operation
    			else if(c==' ') {
    				continue;
    			}
    		}
    		
    		//the above condition is satisified only when it ends with the operator what if it end with the number so check is temp is not empty
    		// is not then explicitly add it the numbers arraylist
    		if (!temp.isEmpty()) {
                numbers.add(Double.parseDouble(temp));
            }
    	}
    	
    	// in this method i am calling the evaluateExpression method so in main ill be just call this instead of two method in main
    	evaluateExpression();
    }
    
    public void evaluateExpression() {
    	
    	//if there is only operator no numbers at that time we say there is no number
    	if(numbers.size()==0) {
    		System.out.println("There is no number to evaluate");
    	}
    	
    	//if it has number and operator then we do the following operation
    	else {
    		
    		// in this while loop we are first evaluating the * and / 
    		int i=0;
    		// we will repeat this code till we have operator in tokens array
    		while(i<tokens.size()) {
    			
    			// if operator is * or / then pass the index to next method to perform calculation
    			if(tokens.get(i)=='*' || tokens.get(i)=='/') {
    				
    				// the calling function will return value and is stored in the result1 variable
    				double result1 = evaluation(i);
    				// after calculating the result stor that result in i index with the result value
    				numbers.set(i, result1);
    				// as we have alreay calculated the result of this values now we will remove that value the actuall value is stored at index i
    				// the next value which is already used to calculate will be removed. 
    				// EX : 3 + 5 = 7(stored in i(3) place and removing the 5(i+1) position.
    				numbers.remove(i+1);
    				//we have already used the token or operator at that position so we will remove that also
    				tokens.remove(i);
    			}
    			// if it not * or / then just increment the index and search for this operator
    			else {
    				i++;
    			}
    		}
    		// after completion of * and / move to + and - so start the index with 0 again
    		i=0;
    		
    		while(i<tokens.size()) {
    			// same process for + and - also
    			if(tokens.get(i)=='+' || tokens.get(i)=='-') {
    				double result1 = evaluation(i);
    				numbers.set(i, result1);
    				numbers.remove(i+1);
    				tokens.remove(i);
    				
    			}
    			else {
    				i++;
    			}
    		}
    	}
    	
    	// if there is only one number left in the number then print it
    	if (numbers.size() == 1) {
            System.out.println("Result: " + numbers.get(0));
        } 
    	else {
            System.out.println("Error: Unable to evaluate the expression.");
        }
    }
    
    // this is used to actually calculate the value depending on the expression above pass that value to this to evaluate
    public double evaluation(int i) {
    	
    	// get the number at i index that we passed
    	double num1 = numbers.get(i);
    	// get the number at i+1 index
    	double num2 = numbers.get(i+1);
    	double result = 0.0;
    	// get the token at i index and perform the operation depending on that operator.
    	switch(tokens.get(i)) {
    		case '*' : 
    					return result = num1 * num2;
    					
    		case '/' : 	
    					if (num2 == 0) {
    						System.out.println("Can't divide the number by 0");	
    					}
    					return result = num1 / num2;
    					
    		case '+' : 
    					return result = num1 + num2;
    					
    		case '-' : 
    					return result = num1 - num2;
    					
    		default : System.out.println("Invalid operator.");			
    	}
    	// this value will be stored in the variable in which we are calling this method
    	return result;
    }
}
