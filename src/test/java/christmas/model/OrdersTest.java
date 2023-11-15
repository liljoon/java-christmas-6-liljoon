package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrdersTest {

    @ParameterizedTest
    @MethodSource("generateData_valid")
    @DisplayName("valid 에러 테스트입니다.")
    void valid_ErrorTest(List<String> menuNames, List<Integer> numbers) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < menuNames.size(); i++) {
            orders.add(new Order(menuNames.get(i), numbers.get(i)));
        }
        assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateData_valid() {
        return Stream.of(
                Arguments.of(Arrays.asList("해산물파스타", "해산물파스타", "레드와인"), Arrays.asList(1, 1, 1)),
                Arguments.of(Arrays.asList("해산물파스타", "양송이수프", "레드와인"), Arrays.asList(10, 7, 4)),
                Arguments.of(Arrays.asList("제로콜라", "샴페인", "레드와인"), Arrays.asList(1, 7, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData_TotalPrice")
    @DisplayName("총 금액 계산 테스트입니다.")
    void getTotalPrice_Test(List<String> menuNames, List<Integer> numbers, Integer expected) {
        List<Order> orderArrayList = new ArrayList<>();
        for (int i = 0; i < menuNames.size(); i++) {
            orderArrayList.add(new Order(menuNames.get(i), numbers.get(i)));
        }
        Orders orders = new Orders(orderArrayList);
        assertThat(orders.getTotalPrice())
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateData_TotalPrice() {
        return Stream.of(
                Arguments.of(Arrays.asList("양송이수프", "해산물파스타", "레드와인"), Arrays.asList(1, 2, 1), 136000),
                Arguments.of(Arrays.asList("타파스", "티본스테이크", "아이스크림", "제로콜라"), Arrays.asList(2, 1, 2, 2), 82000)
        );
    }

    @ParameterizedTest
    @MethodSource("generateData_GiftEvent")
    @DisplayName("증정이벤트 테스트입니다.")
    void isGiftEvent_Test(List<String> menuNames, List<Integer> numbers, boolean expected) {
        List<Order> orderArrayList = new ArrayList<>();
        for (int i = 0; i < menuNames.size(); i++) {
            orderArrayList.add(new Order(menuNames.get(i), numbers.get(i)));
        }
        Orders orders = new Orders(orderArrayList);
        assertThat(orders.isGiftEvent())
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateData_GiftEvent() {
        return Stream.of(
                Arguments.of(Arrays.asList("양송이수프", "해산물파스타", "레드와인"), Arrays.asList(1, 2, 1), true),
                Arguments.of(Arrays.asList("타파스", "티본스테이크", "아이스크림", "제로콜라"), Arrays.asList(2, 1, 2, 2), false)
        );
    }

    @ParameterizedTest
    @MethodSource("generateData_DayEvent")
    @DisplayName("평일,주말 이벤트 테스트입니다.")
    void isGiftEvent_Test(List<String> menuNames, List<Integer> numbers, Integer expectedWeekend,
                          Integer expectedWeekdays) {
        List<Order> orderArrayList = new ArrayList<>();
        for (int i = 0; i < menuNames.size(); i++) {
            orderArrayList.add(new Order(menuNames.get(i), numbers.get(i)));
        }
        Orders orders = new Orders(orderArrayList);
        assertThat(orders.getWeekendDiscount())
                .isEqualTo(expectedWeekend);
        assertThat(orders.getWeekdaysDiscount())
                .isEqualTo(expectedWeekdays);
    }

    static Stream<Arguments> generateData_DayEvent() {
        return Stream.of(
                Arguments.of(Arrays.asList("양송이수프", "해산물파스타", "레드와인"), Arrays.asList(1, 2, 1), 2023 * 2, 0),
                Arguments.of(Arrays.asList("타파스", "티본스테이크", "아이스크림", "제로콜라"), Arrays.asList(2, 1, 2, 2), 2023, 2023 * 2)
        );
    }
}
