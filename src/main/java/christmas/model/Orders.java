package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders;

    private final static int maxOfOrderNumber = 20;
    private final static int giftEventCutLine = 120000;
    private final static int discountPrice = 2023;

    public Orders(List<Order> orders) {
        this.orders = orders;
        validate();
    }

    private void validate() {
        if (isDuplicated()) {
            throw new IllegalArgumentException();
        }
        if (isOverMax()) {
            throw new IllegalArgumentException();
        }
        if (isOnlyDrink()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated() {
        List<String> orderMenuNames = new ArrayList<>();

        orders.forEach(order -> {
            orderMenuNames.add(order.getMenu().getName());
        });
        if (orderMenuNames.stream().distinct().count() != orderMenuNames.size()) {
            return true;
        }
        return false;
    }

    private boolean isOverMax() {
        Integer count = 0;

        for (Order order : orders) {
            count += order.getNumber();
        }
        if (count > maxOfOrderNumber) {
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

        if (totalPrice >= giftEventCutLine) {
            return true;
        }
        return false;
    }

    public Integer getWeekdaysDiscount() {
        Integer dessertNumber = 0;
        for (Order order : orders) {
            dessertNumber += order.getDessertNumber();
        }
        return dessertNumber * discountPrice;
    }

    public Integer getWeekendDiscount() {
        Integer mainDishNumber = 0;
        for (Order order : orders) {
            mainDishNumber += order.getMainDishNumber();
        }
        return mainDishNumber * discountPrice;
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
