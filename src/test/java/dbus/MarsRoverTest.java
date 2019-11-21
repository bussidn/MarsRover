package dbus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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
        void test(Orientation initialOrientation, Orientation expectedOrientation) {
            MarsRover marsRover = marsRover(initialOrientation);

            marsRover.turnLeft();

            assertThat(marsRover).isEqualTo(marsRover(expectedOrientation));
        }

    }

    private static MarsRover marsRover(Orientation orientation) {
        return new MarsRover(orientation);
    }

    private static Stream<Arguments> turnLeftArgs() {
        return Stream.of(
                Arguments.of(Orientation.NORTH, Orientation.WEST)
        );
    }

}