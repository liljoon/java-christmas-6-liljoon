package christmas.view;

import christmas.constant.Menu;
import christmas.model.Date;
import christmas.model.Orders;

public class OutputView {
    private final static int priceAtLeastForEvent = 10000;
    private final static int priceOfSpecialDiscount = 1000;

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
        System.out.printf("%,d원\n\n", price);
    }

    public void printGiftEvent(Orders orders) {
        System.out.println("<증정 메뉴>");

        if (orders.isGiftEvent()) {
            System.out.println("샴페인 1개\n");
            return;
        }
        System.out.println("없음\n");
    }

    public void printDiscountContext(Orders orders, Date date) {
        System.out.println("<혜택 내역>");
        if (orders.getTotalPrice() < priceAtLeastForEvent) {
            System.out.println("없음\n");
            return;
        }
        if (date.getChristmasDDayDiscount() != 0) {
            System.out.printf("크리스마스 디데이 할인: -%,d원\n", date.getChristmasDDayDiscount());
        }
        if (date.isWeekdays() && orders.getWeekdaysDiscount() != 0) {
            System.out.printf("평일 할인: -%,d원\n", orders.getWeekdaysDiscount());
        }
        if (date.isWeekend() && orders.getWeekendDiscount() != 0) {
            System.out.printf("주말 할인: -%,d원\n", orders.getWeekendDiscount());
        }
        if (date.isSpecialDiscount()) {
            System.out.printf("특별 할인: -%,d원\n", priceOfSpecialDiscount);
        }
        if (orders.isGiftEvent()) {
            System.out.printf("증정 이벤트: -%,d원\n", Menu.CHAMPAGNE.getPrice());
        }
        System.out.println();
    }

    public void printTotalDiscount(Integer price) {
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n\n", -price);
    }

    public void printTotalPriceAfterDiscount(Integer price) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n\n", price);
    }

    public void printEventBadge(String badgeName) {
        System.out.println("<12월 이벤트 배지>");
        System.out.printf(badgeName);
    }
}
