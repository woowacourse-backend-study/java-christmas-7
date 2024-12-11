package christmas.domain;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    EMPTY("없음", 0)
    ;

    public final String name;
    private final int standardPrice;

    Badge(String name, int standardPrice) {
        this.name = name;
        this.standardPrice = standardPrice;
    }

    public static Badge getBadge(final int totalBenefit) {
        Badge resultBadge = Badge.EMPTY;
        for (Badge badge : values()) {
            if (totalBenefit >= badge.standardPrice && badge.standardPrice > resultBadge.standardPrice) {
                resultBadge = badge;
            }
        }
        return resultBadge;
    }
}
