package christmas.domain;

public enum Discount {
    CHRISTMAS("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIFT("증정 이벤트"),
    ;

    public final String name;

    Discount(String name) {
        this.name = name;
    }
}
