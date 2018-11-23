public enum PlaneType {
    BOEING777(10),
    BOEING747(20),
    TWINOTTER(5),
    CESNA187(2),
    LEARJET(6),
    AIRBUSA380(25);

    private final int capacity;

    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
