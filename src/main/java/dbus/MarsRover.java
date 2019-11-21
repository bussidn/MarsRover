package dbus;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
class MarsRover {

    private Orientation orientation;

    MarsRover(Orientation orientation) {
        this.orientation = orientation;
    }

    void turnLeft() {
        orientation = orientation.left();
    }

    void turnRight() {
        orientation = orientation.right();
    }
}
