package christmas.model;

import christmas.constant.Menu;

public class Order {
    private Menu menu;
    private Integer number;

    public Order(Menu menu, Integer number) {
        this.menu = menu;
        this.number = number;
    }

    public Integer getPrice() {
        return this.menu.getPrice() * this.number;
    }

    public Integer getDessertNumber() {
        if (menu.isDessert()) {
            return number;
        }
        return 0;
    }

    public Integer getMainDishNumber() {
        if (menu.isMainDish()) {
            return number;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %d개", menu.getName(), number);
    }
}
