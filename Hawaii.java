class Hawaii extends State { //create new class that represents Hawaii and its tax behavior
    public Hawaii() { //create constructor called Hawaii that initializes the FourPointFivePercent behavior
        super("Hawaii", new FourPointFivePercent()); //call State constructor using Hawaii's name and tax behavior
    }
}