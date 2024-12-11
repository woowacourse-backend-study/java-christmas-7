package christmas.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class EventBenefit {
    private final Map<Discount, Integer> discounts = new EnumMap<>(Discount.class);

    public EventBenefit() {
        init();
    }

    public Map<Discount, Integer> getDiscounts() {
        return Collections.unmodifiableMap(discounts);
    }

    private void init() {
        for (Discount discount : discounts.keySet()) {
            discounts.put(discount, 0);
        }
    }

    public void setBenefit(Discount type, int price) {
        if (type == Discount.GIFT) {
            throw new RuntimeException("증정 이벤트는 혜택 할인 내역에 포함하지 않습니다.");
        }
        discounts.put(type, price);
    }

    public int getTotalBenefit() {
        return discounts.values().stream().mapToInt(Integer::intValue).sum();
    }
}
