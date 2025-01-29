interface SalesTaxBehavior { //create interface for tax behaviors to implement the method to compute its sales tax
    double compute(double value); //define a double method called compute that the tax behaviors will define and implement
}

class NoTax implements SalesTaxBehavior { //create NoTax class that implements the SalesTaxBehavior interface
    @Override //override compute method for specific definition of no sales tax
    public double compute(double value) { //implement compute method from interface compute skeleton method
        return 0.00; //return 0.00 for a state with no state sales tax (Alaska)
    }
}

class SevenPercent implements SalesTaxBehavior { //create SevenPercent class that implements the SalesTaxBehavior interface
    @Override //override compute method for specific definition of 7%  state sales tax
    public double compute(double value) { //implement compute method from interface compute skeleton method
        return value * 0.07; //multiply value (user input dollar amount) by 0.07 and return the value to show what the state sales tax dollar amount will be.
    }
}

class FourPointFivePercent implements SalesTaxBehavior { //create FourPointFivePercent class that implements the SalesTaxBehavior interface
    @Override //override compute method for specific definition of 7%  state sales tax
    public double compute(double value) { //implement compute method from interface compute skeleton method
        return value * 0.045; //multiply value (user input dollar amount) by 0.045 and return the value to show what the state sales tax dollar amount will be.
    }
}

abstract class State { //create an abstract class called State that will be implemented later by Alaska, Indiana, and Hawaii extensions
    private String name; //create a private string variable called name
    private SalesTaxBehavior taxBehavior; //declare private instance variable for TaxBehavior of type SalesTaxBehavior allowing for it to be dynamically changed

    public State(String name, SalesTaxBehavior taxBehavior) {//create constructor for the string variable name
        this.name = name;
        this.taxBehavior = taxBehavior; //assign relative taxBehavior using the State constructor, so it can be used dynamically when executed
    }

    public String getName() { //create an accessor method that returns name
        return name;
    }

    public void setTaxBehavior(SalesTaxBehavior taxBehavior) { //create mutator method that sets the taxBehavior to the corresponding tax behavior based on the input state
        this.taxBehavior = taxBehavior;
    }

    public void showTax(double value) { //declare a method called show tax that can be implemented by the 3 states
        double tax = taxBehavior.compute(value); //create a tax variable of the double type and set it equal to the computed tax value based on state input
        System.out.printf("The sales tax on $%.2f in %s is $%.2f.%n", value, getName(), tax); //instead of printing in main, print the input and calculated values for state name, value, and value after tax.
    }
}

class Alaska extends State { //create new class that represents Alaska and its tax behavior
    public Alaska() { //create constructor called Alaska that initializes the noTax behavior
        super("Alaska", new NoTax()); //call State constructor using Alaska's name and tax behavior
    }
}

class Indiana extends State { //create new class that represents Indiana and its tax behavior
    public Indiana() { //create constructor called Indiana that initializes the SevenPercent behavior
        super("Indiana", new SevenPercent()); //call State constructor using Indiana's name and tax behavior
    }
}

class Hawaii extends State { //create new class that represents Hawaii and its tax behavior
    public Hawaii() { //create constructor called Hawaii that initializes the FourPointFivePercent behavior
        super("Hawaii", new FourPointFivePercent()); //call State constructor using Hawaii's name and tax behavior
    }
}

public class SalesTaxCalculator {
    public static void main(String[] args) { //main method that handles user input and uses prior methods and classes to output correct state sale's tax info
        if (args.length != 2) { //check if user input has 2 parameters: state name and a dollar amount
            System.out.println("Error: Invalid number of arguments.%n"); //output error message if number of arguments is incorrect
            return;
        }

        String stateName = args[0]; //set a string variable called stateName to the first input parameter
        double saleAmount; //create a double amount called saleAmount that will later output the state sales tax dollar amount
        State state; //create a State variable called state which will be used to create a state variable for Alaska, Indiana, or Hawaii

        try { //google was used to research how to verify command line arguments
            saleAmount = Double.parseDouble(args[1]); //try parsing saleAmount (dollar input) from command-line arguments
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid dollar amount.%n"); //output error message for invalid money amount in command-line
            return;
        }

        if (stateName.equals("Alaska")) { //if input stateName is Alaska, create new Alaska object
            state = new Alaska();
        } else if (stateName.equals("Indiana")) { //if input stateName is Indiana, create new Indiana object
            state = new Indiana();
        } else if (stateName.equals("Hawaii")) { //if input stateName is Hawaii, create new Hawaii object
            state = new Hawaii();
        } else { //if stateName isn't one of the 2 provided, give error message for incorrect input
            System.out.printf("Error: The state sales tax for '%s' is not computable. Please enter Alaska, Indiana, or Hawaii.%n", stateName);
            return;
        }

        state.showTax(saleAmount); //call showTax method for the corresponding state name using the input dollar sale amount
    }
}
