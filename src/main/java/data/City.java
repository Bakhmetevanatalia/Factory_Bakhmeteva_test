package data;

public enum City {
    MOSCOW("Москва");

    private String name;

    City(String name){
        this.name =name;
    }

    public String getName(){
        return name;
    }
}
