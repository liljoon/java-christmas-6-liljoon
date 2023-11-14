package christmas.constant;

public enum Drink {
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000),
    ;

    final private String name;
    final private Integer price;

    Drink(String name, Integer price) {
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