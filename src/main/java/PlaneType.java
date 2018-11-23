public enum PlaneType {
    BOEING777(10, 100),
    BOEING747(20, 280),
    TWINOTTER(5, 50),
    CESNA187(2, 10),
    LEARJET(6, 40),
    AIRBUSA380(25, 1000);

    private final int capacity;
    private final int luggageAllowance;

    PlaneType(int capacity, int luggageAllowance){
        this.capacity = capacity;
        this.luggageAllowance = luggageAllowance;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getLuggageAllowance(){
        return this.luggageAllowance;
    }
}
