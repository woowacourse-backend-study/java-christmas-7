package christmas.domain;

import christmas.infrastructure.constants.ExceptionMessage;
import christmas.infrastructure.exception.CustomException;

import java.util.EnumMap;
import java.util.Map;

public class Order {
    public static final int MAX_COUNT = 20;
    private final Map<Menu, Integer> order = new EnumMap<>(Menu.class);

    public void addOrder(Menu menu, final int count) {
        if (order.get(menu) != null) {
            throw new CustomException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
        order.put(menu, count);
        if (getTotalCount() > MAX_COUNT) {
            throw new CustomException(ExceptionMessage.EXCEED_ORDER.getMessage());
        }
    }

    private int getTotalCount() {
        return order.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getMenuCount(MenuType target) {
        int total = 0;
        for (Menu menu : order.keySet()) {
            if (menu.type == target) {
                total += order.get(menu);
            }
        }
        return total;
    }
}
