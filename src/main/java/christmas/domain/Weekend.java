package christmas.domain;

import java.util.List;

public class Weekend {
    public static final List<Integer> dates = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);

    public static boolean isWeekend(final int date) {
        return dates.stream().anyMatch(d -> d == date);
    }
}
