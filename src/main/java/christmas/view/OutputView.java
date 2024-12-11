package christmas.view;

import christmas.domain.*;
import christmas.infrastructure.constants.Message;
import christmas.service.dto.ChristmasEventResponse;

import java.util.EnumMap;
import java.util.Map;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWelcome() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printBenefitTitle() {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printOrder(Order order) {
        printTitle("주문 메뉴");
        Map<Menu, Integer> orderMap = order.getOrder();
        for (Menu menu : orderMap.keySet()) {
            printMessage(String.format("%s %,d개", menu.name, orderMap.get(menu)));
        }
    }

    public void printBenefitResult(ChristmasEventResponse response) {
        printTotalPrice(response.totalOrderPrice());
        printGift(response.giftMenu(), response.giftCount());
        printBenefits(response.eventBenefit());
        printTotalBenefit(response.totalBenefit());
        printCreditPrice(response.creditPrice());
        printBadge(response.badge());
    }

    private void printTotalPrice(final int totalPrice) {
        printTitle("할인 전 총주문 금액");
        printMessage(String.format("%,d원", totalPrice));
    }

    private void printGift(Menu menu, final int count) {
        printTitle("증정 메뉴");
        if (menu == null || count == 0) {
            printMessage("없음");
            return;
        }
        printMessage(String.format("%s %,d개", menu.name, count));
    }

    private void printBenefits(EventBenefit eventBenefit) {
        printTitle("혜택 내역");
        if (eventBenefit.getTotalBenefit() == 0) {
            printMessage("없음");
            return;
        }
        Map<Discount, Integer> discounts = eventBenefit.getDiscounts();
        for (Discount type : discounts.keySet()) {
            if (discounts.get(type) == 0) continue;
            printMessage(String.format("%s: -%,d원", type.name, discounts.get(type)));
        }
    }

    private void printTotalBenefit(final int totalBenefit) {
        printTitle("총혜택 금액");
        if (totalBenefit == 0) {
            printMessage("0원");
            return;
        }
        printMessage(String.format("-%,d원", totalBenefit));
    }

    private void printCreditPrice(final int creditPrice) {
        printTitle("할인 후 예상 결제 금액");
        printMessage(String.format("%,d원", creditPrice));
    }

    private void printBadge(Badge badge) {
        printTitle("12월 이벤트 배지");
        printMessage(badge.name);
    }

    private void printTitle(String title) {
        System.out.printf(Message.NEWLINE.value + "<%s>" + Message.NEWLINE.value, title);
    }
}
