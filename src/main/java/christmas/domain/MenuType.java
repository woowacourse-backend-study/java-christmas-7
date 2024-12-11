package christmas.domain;

public enum MenuType {
    APPETIZER("애피타이저"),
    MAIN("메"),
    DESERT("디저트"),
    DRINK("음료"),
    ;

    public final String name;

    MenuType(String name) {
        this.name = name;
    }
}
