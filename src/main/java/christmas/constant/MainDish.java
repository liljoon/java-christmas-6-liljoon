package christmas.constant;

public enum MainDish {
    T_BONE_STEAK("티본스테이크", 55000),
    BARBECUE_RIBS("바비큐립", 54000),
    SEAFODD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),
    ;

    final private String name;
    final private Integer price;

    MainDish(String name, Integer price) {
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
