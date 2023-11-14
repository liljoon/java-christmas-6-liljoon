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

    boolean isDessert() {
        if (menu.isDessert()) {
            return true;
        }
        return false;
    }

    boolean isMainDish() {
        if (menu.isMainDish()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d개", menu.getName(), number);
    }
}
