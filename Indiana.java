class Indiana extends State { //create new class that represents Indiana and its tax behavior
    public Indiana() { //create constructor called Indiana that initializes the SevenPercent behavior
        super("Indiana", new SevenPercent()); //call State constructor using Indiana's name and tax behavior
    }
}