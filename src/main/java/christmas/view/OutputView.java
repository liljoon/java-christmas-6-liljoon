package christmas.view;

import christmas.model.Date;
import christmas.model.Orders;
import java.text.NumberFormat;

public class OutputView {
    public void printWelcome() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printAfterInput(Date date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n", date.getDate());
    }

    public void printOrder(Orders orders) {
        System.out.println("<주문 메뉴>");
        System.out.println(orders.toString());
    }

    public void printTotalPriceBeforeDiscount(Orders orders) {
        System.out.println("<할인 전 총주문 금액>");
        Integer price = orders.getTotalPrice();
        String formattedPrice = NumberFormat.getInstance().format(price);
        System.out.printf("%s원\n", formattedPrice);
    }

    public void printGiftEvent(Orders orders) {
        System.out.println("<증정 메뉴>");

        if (orders.isGiftEvent()) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }
}
