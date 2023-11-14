package christmas.model;

import christmas.constant.Menu;

public class Order {
    Menu menu;
    Integer number;

    public Order(Menu menu, Integer number) {
        this.menu = menu;
        this.number = number;
    }
}
