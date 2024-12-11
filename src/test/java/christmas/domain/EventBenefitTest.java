package christmas.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class EventBenefitTest {
    @Test
    @DisplayName("증정 이벤트는 할인 혜택 내역에 포함할 수 없다.")
    void 증정_이벤트_미포함() {
        // given
        EventBenefit eventBenefit = new EventBenefit();
        Discount type = Discount.GIFT;

        // when & then
        assertThatThrownBy(() -> {
            eventBenefit.setBenefit(type, Menu.샴페인.price);
        }).isInstanceOf(RuntimeException.class);
    }
}