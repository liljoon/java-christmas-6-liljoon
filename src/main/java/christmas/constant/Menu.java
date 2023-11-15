package christmas.constant;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6000, Category.APPETIZER),
    TAPAS("타파스", 5500, Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER),

    CHOCOLATE_CAKE("초코케이크", 15000, Category.DESSERT),
    ICE_CREAM("아이스크림", 5000, Category.DESSERT),

    ZERO_COLA("제로콜라", 3000, Category.DRINK),
    RED_WINE("레드와인", 60000, Category.DRINK),
    CHAMPAGNE("샴페인", 25000, Category.DRINK),

    T_BONE_STEAK("티본스테이크", 55000, Category.MAIN_DISH),
    BARBECUE_RIBS("바비큐립", 54000, Category.MAIN_DISH),
    SEAFOOD_PASTA("해산물파스타", 35000, Category.MAIN_DISH),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, Category.MAIN_DISH),
    ;

    enum Category {
        APPETIZER, DESSERT, DRINK, MAIN_DISH,
    }

    final private String name;
    final private Integer price;
    final private Category category;

    Menu(String name, Integer price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public static Menu getMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equalsIgnoreCase(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isDessert() {
        if (category == Category.DESSERT) {
            return true;
        }
        return false;
    }

    public boolean isMainDish() {
        if (category == Category.MAIN_DISH) {
            return true;
        }
        return false;
    }
}
