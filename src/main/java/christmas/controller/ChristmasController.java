package christmas.controller;

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
    }
}
