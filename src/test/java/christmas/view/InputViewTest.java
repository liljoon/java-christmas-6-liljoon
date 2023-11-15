package christmas.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    InputView inputView = new InputView();

    @Nested
    class ReadDateTest extends NsTest {
        @Test
        @DisplayName("날짜 입력 테스트입니다.")
        void readDate_Test() {
            assertSimpleTest(() -> {
                run("-1", "0", "31", "32", "3");
                assertThat(output()).contains(
                        "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",
                        "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
                );
            });
        }

        @Override
        protected void runMain() {
            inputView.readDate();
        }
    }

    @Nested
    class ReadOrdersTest extends NsTest {
        @Test
        @DisplayName("주문 입력 테스트입니다.")
        void readDate_Test() {
            assertSimpleTest(() -> {
                run("asdf-sad", "해산물파스타-a", "해산물파스타-1,김치-1", "제로콜라-1", "제로콜라", "타파스-1,제로콜라-1");
                assertThat(output()).contains(
                        "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)",
                        "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
                );
            });
        }

        @Override
        protected void runMain() {
            inputView.readOrders();
        }
    }
}
