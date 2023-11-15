package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {
    private Integer date;

    private final static Integer year = 2023;
    private final static Integer month = 12;

    public Date(Integer date) {
        this.date = date;
        validate();
    }

    private void validate() {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }
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
    public boolean isWeekdays() {
        LocalDate localDate = LocalDate.of(year, month, date);

        if (localDate.getDayOfWeek() != DayOfWeek.FRIDAY && localDate.getDayOfWeek() != DayOfWeek.SATURDAY) {
            return true;
        }
        return false;
    }

    // 주말 할인
    public boolean isWeekend() {
        return !isWeekdays();
    }

    // 특별 할인
    public boolean isSpecialDiscount() {
        if (date == 25) {
            return true;
        }
        LocalDate localDate = LocalDate.of(year, month, date);
        if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        }

        return false;
    }
    // 계산
}
