class FourPointFivePercent implements SalesTaxBehavior { //create FourPointFivePercent class that implements the SalesTaxBehavior interface
    @Override //override compute method for specific definition of 4.5%  state sales tax
    public double compute(double value) { //implement compute method from interface compute skeleton method
        return value * 0.045; //multiply value (user input dollar amount) by 0.045 and return the value to show what the state sales tax dollar amount will be.
    }
}
