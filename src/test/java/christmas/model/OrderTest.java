package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OrderTest {

    @ParameterizedTest
    @CsvSource(value = {"abc,1", "해산물파스타,0", "레드와인,-1"})
    @DisplayName("Order 에러 테스트입니다.")
    void Order_ErrorTest(String menuName, Integer number) {
        assertThatThrownBy(() -> new Order(menuName, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"초코케이크,2,2", "아이스크림,4,4", "제로콜라,4,0", "양송이수프,3,0"})
    @DisplayName("디저트 개수 반환 테스트입니다.")
    void getDessertNumber_Test(String menuName, Integer number, Integer expected) {
        Order order = new Order(menuName, number);
        assertThat(order.getDessertNumber())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"초코케이크,2,0", "제로콜라,4,0", "양송이수프,3,0", "티본스테이크,5,5", "해산물파스타,3,3"})
    @DisplayName("메인메뉴 개수 반환 테스트입니다.")
    void getMainDishNumber_Test(String menuName, Integer number, Integer expected) {
        Order order = new Order(menuName, number);
        assertThat(order.getMainDishNumber())
                .isEqualTo(expected);
    }
}
