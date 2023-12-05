package org.mocs.types.floats;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.booleans.MocBoolean;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The MocFloat class represents
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 */

@SuppressWarnings("unused")
public class MocFloat extends MocFactory {
    /**
     * A constant holding the largest positive finite value of type
     * {@code float}, (2-2<sup>-23</sup>)&middot;2<sup>127</sup>.
     * It is equal to the hexadecimal floating-point literal
     * {@code 0x1.fffffeP+127f} and also equal to
     * {@code Float.intBitsToFloat(0x7f7fffff)}.
     */
    private static final float MAX_VALUE = 0x1.fffffeP+127f; // 3.4028235e+38f

    /**
     * A constant holding the smallest positive nonzero value of type
     * {@code float}, 2<sup>-149</sup>. It is equal to the
     * hexadecimal floating-point literal {@code 0x0.000002P-126f}
     * and also equal to {@code Float.intBitsToFloat(0x1)}.
     */
    private static final float MIN_VALUE = 0x0.000002P-126f; // 1.4e-45f

    /**
     * Random float
     *
     * @return Random float
     */
    @NotNull
    public static Float any() {
        return RANDOM.nextFloat(MIN_VALUE, MAX_VALUE);
    }

    /**
     * Random nullable float
     *
     * @return Random nullable float
     */
    @Nullable
    public static Float nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random floats
     *
     * @return Random floats
     */
    @NotNull
    public static List<Float> anyList() {
        List<Float> floats = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> floats.add(any()));
        return floats;
    }

    /**
     * Random nullable floats
     *
     * @return Random nullable floats
     */
    @NotNull
    public static List<Float> nullableAnyList() {
        List<Float> floats = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> floats.add(nullableAny()));
        return floats;
    }

    /**
     * Random floats
     * * @param length the length of floats
     *
     * @return Random floats
     */
    @NotNull
    public static List<Float> anyList(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        List<Float> floats = new ArrayList<>();
        IntStream.range(0, MocInteger.any(length)).forEach(number -> floats.add(any()));
        return floats;
    }

    /**
     * Random nullable floats
     *
     * @param length the length of floats
     * @return Random nullable floats
     */
    @NotNull
    public static List<Float> nullableAnyList(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        List<Float> floats = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, length)).forEach(number -> floats.add(nullableAny()));
        return floats;
    }


}
