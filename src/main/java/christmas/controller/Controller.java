package christmas.controller;

import christmas.domain.DecemberDate;
import christmas.domain.Order;
import christmas.service.ChristmasEventService;
import christmas.service.dto.ChristmasEventResponse;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final ChristmasEventService christmasEventService;

    public Controller(
            InputView inputView,
            OutputView outputView,
            ChristmasEventService christmasEventService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.christmasEventService = christmasEventService;
    }

    public void run() {
        outputView.printWelcome();
        DecemberDate visitDate = getVisitDate();
        Order order = getOrder();
        outputView.printBenefitTitle();
        outputView.printOrder(order);
        ChristmasEventResponse response = christmasEventService.apply(visitDate, order);
        outputView.printBenefitResult(response);
    }

    private DecemberDate getVisitDate() {
        return doLoop(inputView::getVisitDate);
    }

    private Order getOrder() {
        return doLoop(inputView::getOrder);
    }

    public <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}

