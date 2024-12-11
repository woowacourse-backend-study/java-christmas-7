package christmas.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BadgeTest {
    @ParameterizedTest
    @DisplayName("5,000원 미만 혜택 수혜시 배지를 받을 수 없다.")
    @ValueSource(ints = {0, 100, 3000, 4999})
    void 배지_불가능_테스트(final int total) {
        // given

        // when
        Badge badge = Badge.getBadge(total);

        // then
        assertThat(badge).isNull();
    }

    @ParameterizedTest
    @DisplayName("5,000원 ~ 10,000원 혜택 수혜시 별 배지를 받을 수 있다.")
    @ValueSource(ints = {5000, 6000, 9999})
    void 별_배지_테스트(final int total) {
        // given

        // when
        Badge badge = Badge.getBadge(total);

        // then
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @ParameterizedTest
    @DisplayName("10,000원 ~ 20,000원 혜택 수혜시 트리 배지를 받을 수 있다.")
    @ValueSource(ints = {10000, 15000, 19999})
    void 트리_배지_테스트(final int total) {
        // given

        // when
        Badge badge = Badge.getBadge(total);

        // then
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @ParameterizedTest
    @DisplayName("20,000원 이상 혜택 수혜시 산타 배지를 받을 수 있다.")
    @ValueSource(ints = {200000, 20001, 50000})
    void 산타_배지_테스트(final int total) {
        // given

        // when
        Badge badge = Badge.getBadge(total);

        // then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }
}