package net.voltecite.wonderfulwolves.entity.variant;
import java.util.Arrays;
import java.util.Comparator;

public enum WWVariant {
    HUSKY(0),
    GERMAN(1),
    POMSKY(2),
    SAMOYED(3);

    private static final WWVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(WWVariant::getId)).toArray(WWVariant[]::new);
    private final int id;

    WWVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static WWVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}