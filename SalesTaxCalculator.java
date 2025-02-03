public class SalesTaxCalculator {
     public static void main(String[] args) {
             if (args.length != 2) { //check if user input has 2 parameters: state name and a dollar amount
                 System.out.println("Error: Invalid number of arguments.%n"); //output error message if number of arguments is incorrect
                 return;
             }

         if (args[0].equals("Alaska")) { //if input stateName is Alaska, create new Alaska object
             State alaska = new Alaska();
             alaska.showTax(Double.valueOf(args[1]));
         } else if (args[0].equals("Indiana")) { //if input stateName is Indiana, create new Indiana object
             State indiana = new Indiana();
             indiana.showTax(Double.valueOf(args[1]));
         }else if (args[0].equals("Hawaii")) { //if input stateName is Hawaii, create new Hawaii object
             State hawaii = new Hawaii();
             hawaii.showTax(Double.valueOf(args[1]) );
         } else { //if input isn't one of the 3 states, output error message for user
             System.out.printf("Error: The state sales tax for '%s' is not computable. Please enter Alaska, Indiana, or Hawaii.%n", args[0]);
             return;
         }
     }
 }
