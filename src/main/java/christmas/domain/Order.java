package christmas.domain;

import christmas.infrastructure.constants.ExceptionMessage;
import christmas.infrastructure.exception.CustomException;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static christmas.util.Util.*;

public class Order {
    public static final int MAX_COUNT = 20;
    private final Map<Menu, Integer> order = new EnumMap<>(Menu.class);

    public static Order of(String input) {
        Order result = new Order();
        List<String> split = splitByComma(input);
        for (String line : split) {
            List<String> orderMenu = splitByDash(line);
            if (orderMenu.size() != 2) {
                throw new CustomException(ExceptionMessage.INVALID_ORDER.getMessage());
            }
            String menuName = orderMenu.getFirst();
            final int count = parseToInt(orderMenu.get(1));
            result.addOrder(Menu.from(menuName), count);
        }
        return result;
    }

    public void addOrder(Menu menu, final int count) {
        if (order.get(menu) != null) {
            throw new CustomException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
        order.put(menu, count);
        if (getTotalCount() > MAX_COUNT) {
            throw new CustomException(ExceptionMessage.INVALID_ORDER.getMessage());
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
