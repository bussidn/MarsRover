package dbus.detector;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Random;

@EqualsAndHashCode
@ToString
public class ServomotorDetector implements Detector {

    public ServomotorDetector() {
        throw new NullPointerException("There is no RX34 Detector linked to the default CAN bus");
    }

    @Override
    public boolean probe() {
        return randomFrom(true, false);
    }

    @SafeVarargs
    private static <T> T randomFrom(T... values) {
        return values[getRandomNumberInRangeFor(values)];
    }

    private static int getRandomNumberInRangeFor(Object[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return new Random().nextInt(values.length);
    }
}
