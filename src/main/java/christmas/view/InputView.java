package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        int date;

        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        date = Integer.parseInt(input);

        if (date < 1 || date > 31)
            throw new IllegalArgumentException();

        return date;
    }
}
