package christmas.model;

import java.util.List;

public class Orders {
    private List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
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
            if (order.isDessert()) {
                dessertNumber++;
            }
        }
        return dessertNumber * 2023;
    }
    
    public Integer getWeekendDiscount() {
        Integer mainDishNumber = 0;
        for (Order order : orders) {
            if (order.isMainDish()) {
                mainDishNumber++;
            }
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

    // 배지 부여
    // 할인 금액
    // 할인 후 금액
}
