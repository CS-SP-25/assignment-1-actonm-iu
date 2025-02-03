public class State {
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

    public void showTax(Double value) { //declare a method called show tax that can be implemented by the 3 states
        Double tax = taxBehavior.compute(value); //create a tax variable of the double type and set it equal to the computed tax value based on state input
        System.out.printf("The sales tax on $%.2f in %s is $%.2f.%n", value, this.name, tax); //print the input and calculated values for state name, value, and value after tax.
    }
}


