package dbus;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
class Coordinates {
    private final int x;
    private final int y;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }

    Coordinates add(Coordinates coordinates) {
        return Coordinates.of(this.x + coordinates.x, this.y + coordinates.y);
    }
}
