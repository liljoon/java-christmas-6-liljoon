package christmas.controller;

import christmas.constant.Badge;
import christmas.model.Date;
import christmas.model.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private OutputView outputView;
    private InputView inputView;
    private Date date;
    private Orders orders;

    public ChristmasController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.printWelcome();
        date = inputView.readDate();
        orders = inputView.readOrders();
        outputView.printAfterInput(date);
        outputView.printOrder(orders);
        outputView.printTotalPriceBeforeDiscount(orders);
        outputView.printGiftEvent(orders);
        outputView.printDiscountContext(orders, date);
        outputView.printTotalDiscount(sumTotalDiscount());
        outputView.printTotalPriceAfterDiscount(orders.getTotalPrice() - sumTotalDiscountExceptGift());
        outputView.printEventBadge(Badge.getBadgeNameByDiscountPrice(sumTotalDiscount()));
    }

    private Integer sumTotalDiscount() {
        Integer sum = 0;

        if (orders.getTotalPrice() < 10000) {
            return 0;
        }
        sum += sumTotalDiscountExceptGift();
        if (orders.isGiftEvent()) {
            sum += 25000;
        }
        return sum;
    }

    private Integer sumTotalDiscountExceptGift() {
        Integer sum = 0;

        if (orders.getTotalPrice() < 10000) {
            return 0;
        }
        sum += date.getChristmasDDayDiscount();
        if (date.isWeekdays()) {
            sum += orders.getWeekdaysDiscount();
        }
        if (date.isWeekend()) {
            sum += orders.getWeekendDiscount();
        }
        if (date.isSpecialDiscount()) {
            sum += 1000;
        }
        return sum;
    }
}
