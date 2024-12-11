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

class SpecialDayDiscountServiceTest {
    private SpecialDayDiscountService specialDayDiscountService = new SpecialDayDiscountService();

    @ParameterizedTest
    @DisplayName("별표 표시가 되어있는 날짜는 특별 할인을 적용받는다.")
    @ValueSource(ints = {3, 10, 17, 24, 31})
    void 별표_표시_날짜_할인_적용(final int input) {
        // given
        DecemberDate date = new DecemberDate(input);
        Order order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        // when
        DiscountResponse response = specialDayDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(1000);
    }

    @ParameterizedTest
    @DisplayName("별표 표시가 없는 날짜는 특별 할인을 적용받지 않는다.")
    @ValueSource(ints = {1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 25, 26, 27, 28, 29, 30})
    void 별표_표시_날짜_할인_미적용(final int input) {
        // given
        DecemberDate date = new DecemberDate(input);
        Order order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        // when
        DiscountResponse response = specialDayDiscountService.getDiscountInfo(date, order);

        // then
        assertThat(response.discountPrice()).isEqualTo(0);
    }
}