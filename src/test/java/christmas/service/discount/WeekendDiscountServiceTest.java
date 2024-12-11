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

class WeekendDiscountServiceTest {
    private WeekendDiscountService weekendDiscountService = new WeekendDiscountService();

    @ParameterizedTest
    @DisplayName("주말에는 메인 메뉴 할인을 적용받을 수 있다.")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void 주말_할인_적용(final int input) {
        // given
        DecemberDate date = new DecemberDate(input);
        Order order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        // when
        DiscountResponse response = weekendDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(2023 * 2);
    }

    @ParameterizedTest
    @DisplayName("주말이 아닌 날짜에는 할인을 적용받을 수 없다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void 주말_할인_미적용(final int input) {
        // given
        DecemberDate date = new DecemberDate(input);
        Order order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        // when
        DiscountResponse response = weekendDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(0);
    }
}