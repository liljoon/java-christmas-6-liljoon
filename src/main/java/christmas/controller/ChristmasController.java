package christmas.controller;

import christmas.constant.Badge;
import christmas.constant.Menu;
import christmas.model.Date;
import christmas.model.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private OutputView outputView;
    private InputView inputView;
    private Date date;
    private Orders orders;

    private final static int priceAtLeastForEvent = 10000;
    private final static int priceOfSpecialDiscount = 1000;


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
        outputView.printDiscountContext(orders, date, sumTotalDiscount());
        outputView.printTotalDiscount(sumTotalDiscount());
        outputView.printTotalPriceAfterDiscount(orders.getTotalPrice() - sumTotalDiscountExceptGift());
        outputView.printEventBadge(Badge.getBadgeNameByDiscountPrice(sumTotalDiscount()));
    }

    private Integer sumTotalDiscount() {
        Integer sum = 0;

        if (orders.getTotalPrice() < priceAtLeastForEvent) {
            return 0;
        }
        sum += sumTotalDiscountExceptGift();
        if (orders.isGiftEvent()) {
            sum += Menu.CHAMPAGNE.getPrice();
        }
        return sum;
    }

    private Integer sumTotalDiscountExceptGift() {
        Integer sum = 0;
        if (orders.getTotalPrice() < priceAtLeastForEvent) {
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
            sum += priceOfSpecialDiscount;
        }
        return sum;
    }
}
