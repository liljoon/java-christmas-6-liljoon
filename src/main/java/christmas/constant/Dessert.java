package christmas.constant;

public enum Dessert {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000),
    ;
    final private String name;
    final private Integer price;

    Dessert(String name, Integer price) {
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