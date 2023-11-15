package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DateTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 32, 100})
    @DisplayName("날짜 범위를 벗어났을 때 에러를 발생시킵니다.")
    void valid_rangeError(int day) {
        assertThatThrownBy(() -> new Date(day)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1000", "2,1100", "15,2400", "25,3400", "26,0", "31,0"})
    @DisplayName("크리스마스 디데이 할인 금액 테스트입니다.")
    void getChristmasDDayDiscount_Test(int day, int discount) {
        Date date = new Date(day);
        assertThat(date.getChristmasDDayDiscount())
                .isEqualTo(discount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,true", "10,true", "17,true", "24,true", "25,true", "31,true", "4,false", "20,false"})
    @DisplayName("특별 할인 테스트입니다.")
    void isSpecialDiscount_Test(int day, boolean expected) {
        Date date = new Date(day);
        assertThat(date.isSpecialDiscount())
                .isEqualTo(expected);
    }
}
