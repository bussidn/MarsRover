package dbus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Mars Rover should")
class MarsRoverTest {

    @Nested
    @DisplayName("turn left")
    class TurnLeft {

        @Test
        @DisplayName("when initial orientation is NORTH")
        void test() {
            MarsRover marsRover = marsRover(Orientation.NORTH);

            marsRover.turnLeft();

            assertThat(marsRover).isEqualTo(marsRover(Orientation.WEST));
        }

    }

    private MarsRover marsRover(Orientation orientation) {
        return new MarsRover(orientation);
    }

}