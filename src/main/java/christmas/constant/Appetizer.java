package christmas.constant;

public enum Appetizer implements Menu {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000),
    ;

    final private String name;
    final private Integer price;

    Appetizer(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}