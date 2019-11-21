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
        orientation = Orientation.WEST;
    }

}
