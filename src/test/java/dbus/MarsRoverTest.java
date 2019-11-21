package dbus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Mars Rover should")
class MarsRoverTest {

    @Nested
    @DisplayName("turn left")
    class TurnLeft {

        @ParameterizedTest(name = "when initial orientation is {0}")
        @MethodSource("dbus.MarsRoverTest#turnLeftArgs")
        void turn_left(Orientation initialOrientation, Orientation expectedOrientation) {
            MarsRover marsRover = new MarsRover(initialOrientation);

            marsRover.turnLeft();

            assertThat(marsRover).isEqualTo(new MarsRover(expectedOrientation));
        }

    }

    @Nested
    @DisplayName("turn right")
    class TurnRight {

        @ParameterizedTest(name = "when initial orientation is {0}")
        @MethodSource("dbus.MarsRoverTest#turnRightArgs")
        void turn_right(Orientation initialOrientation, Orientation expectedOrientation) {
            MarsRover marsRover = new MarsRover(initialOrientation);

            marsRover.turnRight();

            assertThat(marsRover).isEqualTo(new MarsRover(expectedOrientation));
        }

    }

    private static Stream<Arguments> turnLeftArgs() {
        return Stream.of(
                Arguments.of(Orientation.NORTH, Orientation.WEST),
                Arguments.of(Orientation.WEST, Orientation.SOUTH),
                Arguments.of(Orientation.SOUTH, Orientation.EAST),
                Arguments.of(Orientation.EAST, Orientation.NORTH)
        );
    }

    private static Stream<Arguments> turnRightArgs() {
        return Stream.of(
                Arguments.of(Orientation.NORTH, Orientation.EAST),
                Arguments.of(Orientation.EAST, Orientation.SOUTH),
                Arguments.of(Orientation.SOUTH, Orientation.WEST),
                Arguments.of(Orientation.WEST, Orientation.NORTH)
        );
    }

}