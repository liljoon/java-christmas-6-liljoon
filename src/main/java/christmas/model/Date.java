package christmas.model;

public class Date {
    private Integer date;

    public Date(Integer date) {
        this.date = date;
    }

    public Integer getDate() {
        return date;
    }

    // 크리스마스 디데이 할인
    public Integer getChristmasDDayDiscount() {
        if (date >= 25) {
            return 3400;
        }
        return 1000 + (date - 1) * 100;
    }

    // 평일 할인
    // 주말 할인
    // 특별 할인
    // 계산
}
