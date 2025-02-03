class NoTax implements SalesTaxBehavior { //create NoTax class that implements the SalesTaxBehavior interface
    @Override //override compute method for specific definition of no sales tax
    public double compute(double value) { //implement compute method from interface compute skeleton method
        return 0.00; //return 0.00 for a state with no state sales tax (Alaska)
    }
}
