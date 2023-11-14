package christmas.constant;

public enum Badge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NO_BADGE("없음");

    final private String name;

    Badge(String name) {
        this.name = name;
    }

    public static String getBadgeNameByDiscountPrice(Integer discountPrice) {
        if (discountPrice >= 20000) {
            return SANTA.name;
        } else if (discountPrice >= 10000) {
            return TREE.name;
        } else if (discountPrice >= 5000) {
            return STAR.name;
        }
        return NO_BADGE.name;
    }
}
