package christmas.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    @Nested
    class PrintOrderTest extends NsTest {
        @Test
        @DisplayName("주문 메뉴 출력 테스트입니다.")
        void printOrderTest() {
            assertSimpleTest(() -> {
                run("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
                assertThat(output()).contains(
                        "<주문 메뉴>",
                        "티본스테이크 1개",
                        "바비큐립 1개",
                        "초코케이크 2개",
                        "제로콜라 1개"
                );
            });
        }

        @Test
        @DisplayName("주문 메뉴 출력 테스트입니다.")
        void printOrderTest2() {
            assertSimpleTest(() -> {
                run("타파스-1,제로콜라-1");
                assertThat(output()).contains(
                        "<주문 메뉴>",
                        "타파스 1개",
                        "제로콜라 1개"
                );
            });
        }

        @Override
        protected void runMain() {
            outputView.printOrder(inputView.readOrders());
        }
    }

    @Nested
    class PrintTotalPriceBeforeDiscountTest extends NsTest {
        @Test
        @DisplayName("할인 전 총주문 금액 출력 테스트입니다.")
        void printTotalPriceBeforeDiscountTest() {
            assertSimpleTest(() -> {
                run("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
                assertThat(output()).contains(
                        "<할인 전 총주문 금액>",
                        "142,000원"
                );
            });
        }

        @Test
        @DisplayName("할인 전 총주문 금액 출력 테스트입니다.")
        void printTotalPriceBeforeDiscountTest2() {
            assertSimpleTest(() -> {
                run("타파스-1,제로콜라-1");
                assertThat(output()).contains(
                        "<할인 전 총주문 금액>",
                        "8,500원"
                );
            });
        }

        @Override
        protected void runMain() {
            outputView.printTotalPriceBeforeDiscount(inputView.readOrders());
        }
    }

    @Nested
    class PrintGiftEvent extends NsTest {
        @Test
        @DisplayName("증정 메뉴 출력 테스트입니다.")
        void printGiftEventTest() {
            assertSimpleTest(() -> {
                run("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
                assertThat(output()).contains(
                        "<증정 메뉴>",
                        "샴페인 1개"
                );
            });
        }

        @Test
        @DisplayName("증정 메뉴 출력 테스트입니다.")
        void printGiftEventTest2() {
            assertSimpleTest(() -> {
                run("타파스-1,제로콜라-1");
                assertThat(output()).contains(
                        "<증정 메뉴>",
                        "없음"
                );
            });
        }

        @Override
        protected void runMain() {
            outputView.printGiftEvent(inputView.readOrders());
        }
    }

    @Nested
    class PrintDiscountContextTest extends NsTest {
        @Test
        @DisplayName("혜택내역 출력 테스트입니다.")
        void printDiscountContextTest() {
            assertSimpleTest(() -> {
                run("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", "3");
                assertThat(output()).contains(
                        "<혜택 내역>",
                        "크리스마스 디데이 할인: -1,200원",
                        "평일 할인: -4,046원",
                        "특별 할인: -1,000원",
                        "증정 이벤트: -25,000원"
                );
            });
        }

        @Test
        @DisplayName("혜택 내역 출력 테스트입니다.")
        void printDiscountContextTest2() {
            assertSimpleTest(() -> {
                run("타파스-1,제로콜라-1", "26");
                assertThat(output()).contains(
                        "<혜택 내역>",
                        "없음"
                );
            });
        }

        @Override
        protected void runMain() {
            outputView.printDiscountContext(inputView.readOrders(), inputView.readDate());
        }
    }
}
