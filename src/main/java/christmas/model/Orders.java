package christmas.model;

import java.util.List;

public class Orders {
    private List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getTotalPrice() {
        Integer sumOfPrice = 0;

        for (Order order : orders) {
            sumOfPrice += order.getPrice();
        }

        return sumOfPrice;
    }

    @Override
    public String toString() {
        StringBuilder allMenuString = new StringBuilder();

        for (Order order : orders) {
            allMenuString.append(order.toString() + "\n");
        }
        return allMenuString.toString();
    }

    // 할인 전 금액
    // 증정 이벤트
    // 배지 부여
    // 할인 금액
    // 할인 후 금액
}
