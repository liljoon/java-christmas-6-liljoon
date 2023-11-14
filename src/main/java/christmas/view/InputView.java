package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Menu;
import christmas.model.Date;
import christmas.model.Order;
import christmas.model.Orders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public Date readDate() {
        Integer date;

        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        date = Integer.parseInt(input);

        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }

        return new Date(date);
    }

    public Orders readOrders() {
        String ordersString;
        String[] splitedOrderString;
        List<Order> orders = new ArrayList<>();

        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        ordersString = Console.readLine();
        splitedOrderString = ordersString.split(",");

        Arrays.stream(splitedOrderString).forEach((orderString) -> {
            String[] nameAndNumber = orderString.split("-");
            orders.add(new Order(Menu.getMenuByName(nameAndNumber[0]), Integer.parseInt(nameAndNumber[1])));
        });

        return new Orders(orders);
    }
}
