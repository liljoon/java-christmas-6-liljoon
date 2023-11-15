package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
        validate();
    }

    private void validate() {
        if (isDuplicated()) {
            throw new IllegalArgumentException();
        }
        if (isOver20()) {
            throw new IllegalArgumentException();
        }
        if (isOnlyDrink()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated() {
        List<String> orderMenunames = new ArrayList<>();

        orders.forEach(order -> {
            orderMenunames.add(order.getMenu().getName());
        });
        if (orderMenunames.stream().distinct().count() != orderMenunames.size()) {
            return true;
        }
        return false;
    }

    private boolean isOver20() {
        Integer count = 0;

        for (Order order : orders) {
            count += order.getNumber();
        }
        if (count > 20) {
            return true;
        }
        return false;
    }

    private boolean isOnlyDrink() {
        for (Order order : orders) {
            if (!order.getMenu().isDrink()) {
                return false;
            }
        }
        return true;
    }

    // 할인 전 금액
    public Integer getTotalPrice() {
        Integer sumOfPrice = 0;

        for (Order order : orders) {
            sumOfPrice += order.getPrice();
        }

        return sumOfPrice;
    }

    // 증정 이벤트
    public boolean isGiftEvent() {
        Integer totalPrice = getTotalPrice();

        if (totalPrice >= 120000) {
            return true;
        }
        return false;
    }

    public Integer getWeekdaysDiscount() {
        Integer dessertNumber = 0;
        for (Order order : orders) {
            dessertNumber += order.getDessertNumber();
        }
        return dessertNumber * 2023;
    }

    public Integer getWeekendDiscount() {
        Integer mainDishNumber = 0;
        for (Order order : orders) {
            mainDishNumber += order.getMainDishNumber();
        }
        return mainDishNumber * 2023;
    }

    @Override
    public String toString() {
        StringBuilder allMenuString = new StringBuilder();

        for (Order order : orders) {
            allMenuString.append(order.toString() + "\n");
        }
        return allMenuString.toString();
    }
}
