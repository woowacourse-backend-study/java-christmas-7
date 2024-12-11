package christmas.domain;

public enum Menu {
    양송이수프("양송이수프", MenuType.APPETIZER, 6000),
    타파스("타파스", MenuType.APPETIZER, 5500),
    시저샐러드("시저샐러드", MenuType.APPETIZER, 8000),

    티본스테이크("티본스테이크", MenuType.MAIN, 55000),
    바비큐립("바비큐립", MenuType.MAIN, 54000),
    해산물파스타("해산물파스타", MenuType.MAIN, 35000),
    크리스마스파스타("크리스마스파스타", MenuType.MAIN, 25000),

    초코케이크("초코케이크", MenuType.DESERT, 15000),
    아이스크림("아이스크림", MenuType.DESERT, 5000),

    제로콜라("제로콜라", MenuType.DRINK, 3000),
    레드와인("레드와인", MenuType.DRINK, 60000),
    샴페인("샴페인", MenuType.DRINK, 25000),
    ;

    public final String name;
    public final MenuType type;
    public final int price;

    Menu(String name, MenuType type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
