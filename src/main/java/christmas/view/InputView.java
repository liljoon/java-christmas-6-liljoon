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

        while (true) {
            try {
                String input = Console.readLine();
                date = Integer.parseInt(input);

                return new Date(date);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public Orders readOrders() {
        String ordersString;
        String[] splitedOrderString;
        List<Order> orders = new ArrayList<>();
        List<String> menuNames = new ArrayList<>();

        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        ordersString = Console.readLine();
        splitedOrderString = ordersString.split(",");

        Arrays.stream(splitedOrderString).forEach((orderString) -> {
            String[] nameAndNumber = orderString.split("-");
            Menu menu = Menu.getMenuByName(nameAndNumber[0]);
            Integer number = Integer.parseInt(nameAndNumber[1]);
            menuNames.add(menu.getName());
            if (number < 1) {
                throw new IllegalArgumentException();
            }
            // 중복 처리
            if (menuNames.stream().distinct().count() != menuNames.size()) {
                throw new IllegalArgumentException();
            }
            orders.add(new Order(menu, number));
        });

        return new Orders(orders);
    }
}
