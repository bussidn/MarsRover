package dbus;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
class MarsRover {

    private Orientation orientation;
    private Coordinates coordinates;

    MarsRover(Orientation orientation, Coordinates coordinates) {
        this.orientation = orientation;
        this.coordinates = coordinates;
    }

    void turnLeft() {
        orientation = orientation.left();
    }

    void turnRight() {
        orientation = orientation.right();
    }

    void forward() {
        coordinates = orientation.move(coordinates);
    }
}
