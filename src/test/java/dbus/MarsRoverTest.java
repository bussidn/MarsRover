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
            MarsRover marsRover = new MarsRover(initialOrientation, Coordinates.of(0, 0));

            marsRover.turnLeft();

            assertThat(marsRover).isEqualTo(new MarsRover(expectedOrientation, Coordinates.of(0, 0)));
        }

    }

    @Nested
    @DisplayName("turn right")
    class TurnRight {

        @ParameterizedTest(name = "when initial orientation is {0}")
        @MethodSource("dbus.MarsRoverTest#turnRightArgs")
        void turn_right(Orientation initialOrientation, Orientation expectedOrientation) {
            MarsRover marsRover = new MarsRover(initialOrientation, Coordinates.of(0, 0));

            marsRover.turnRight();

            assertThat(marsRover).isEqualTo(new MarsRover(expectedOrientation, Coordinates.of(0, 0)));
        }

    }

    @Nested
    @DisplayName("forward")
    class Forward {

        @ParameterizedTest(name = "when initial orientation is {0} and coordinates are {1}")
        @MethodSource("dbus.MarsRoverTest#forwardArgs")
        void forward(Orientation initialOrientation, Coordinates initialCoordinates,
                     Orientation expectedOrientation, Coordinates expectedCoordinates) {
            MarsRover marsRover = new MarsRover(initialOrientation, initialCoordinates);

            marsRover.forward();

            assertThat(marsRover).isEqualTo(new MarsRover(expectedOrientation, expectedCoordinates));
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

    private static Stream<Arguments> forwardArgs() {
        return Stream.of(
                Arguments.of(Orientation.NORTH, Coordinates.of(3, 4),
                        Orientation.NORTH, Coordinates.of(3, 5)),
                Arguments.of(Orientation.EAST, Coordinates.of(23, 24),
                        Orientation.EAST, Coordinates.of(24, 24)),
                Arguments.of(Orientation.SOUTH, Coordinates.of(7, 8),
                        Orientation.SOUTH, Coordinates.of(7, 7)),
                Arguments.of(Orientation.WEST, Coordinates.of(67, 9),
                        Orientation.WEST, Coordinates.of(66, 9))
        );
    }

}