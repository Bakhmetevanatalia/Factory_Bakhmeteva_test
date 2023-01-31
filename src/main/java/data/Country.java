package data;

public enum Country {
    RUSSIA("Россия");

    private String name;

    Country(String name){
        this.name =name;
    }

    public String getName(){
        return name;
    }
}
