package christmas.service.discount;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.DecemberDate;
import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayDiscountServiceTest {
    private WeekdayDiscountService weekdayDiscountService = new WeekdayDiscountService();

    @ParameterizedTest
    @DisplayName("평일에는 디저트 주문 수만큼 할인받을 수 있다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void 평일_디저트_할인(final int input) {
        // given
        DecemberDate date = new DecemberDate(input);
        Order order = Order.of("초코케이크-3, 양송이수프-1, 아이스크림-1");

        // when
        DiscountResponse response = weekdayDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(2023 * 4);
    }

    @ParameterizedTest
    @DisplayName("평일이 아닌 날에는 할인을 받을 수 없다.")
    @ValueSource(ints = {1, 2, 15, 16, 29, 30})
    void 평일_디저트_할인_미적용(final int input) {
        // given
        DecemberDate date = new DecemberDate(input);
        Order order = Order.of("초코케이크-3, 양송이수프-1, 아이스크림-1");

        // when
        DiscountResponse response = weekdayDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(0);
    }
}