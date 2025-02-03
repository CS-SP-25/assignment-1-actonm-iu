class Alaska extends State { //create new class that represents Alaska and its tax behavior
    public Alaska() { //create constructor called Alaska that initializes the noTax behavior
        super("Alaska", new NoTax()); //call State constructor using Alaska's name and tax behavior
    }
}

