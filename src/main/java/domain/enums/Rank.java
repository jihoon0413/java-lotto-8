package domain.enums;

public enum Rank {

    NO_MATCH(0, false, 0),
    FIFTH(3, false, 5000),
    FORTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private int matchCount;
    private boolean matchBonus;
    private int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public double getPrize() {
        return prize;
    }

    public static Rank getRank(int matchCount, boolean isMatchBonus) {
        for (Rank rank : values()) {
            if (rank.getMatchCount() == matchCount && rank.isMatchBonus() == isMatchBonus) {
                return rank;
            }
        }
        return NO_MATCH;
    }

    public static final Rank[] ranks = {
            FIFTH, FORTH, THIRD, SECOND, FIRST
    };
}
