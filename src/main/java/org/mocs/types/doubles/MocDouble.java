package org.mocs.types.doubles;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.booleans.MocBoolean;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The MocDouble class represents
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 */

@SuppressWarnings("unused")
public class MocDouble extends MocFactory {
    /**
     * A constant holding the largest positive finite value of type
     * {@code double},
     * (2-2<sup>-52</sup>)&middot;2<sup>1023</sup>.  It is equal to
     * the hexadecimal floating-point literal
     * {@code 0x1.fffffffffffffP+1023} and also equal to
     * {@code Double.longBitsToDouble(0x7fefffffffffffffL)}.
     */
    private static final double MAX_VALUE = 0x1.fffffffffffffP+1023; // 1.7976931348623157e+308

    /**
     * A constant holding the smallest positive nonzero value of type
     * {@code double}, 2<sup>-1074</sup>. It is equal to the
     * hexadecimal floating-point literal
     * {@code 0x0.0000000000001P-1022} and also equal to
     * {@code Double.longBitsToDouble(0x1L)}.
     */
    private static final double MIN_VALUE = 0x0.0000000000001P-1022; // 4.9e-324

    /**
     * Random double
     *
     * @return random double
     */
    @NotNull
    public static Double any() {
        return RANDOM.nextDouble(MIN_VALUE, MAX_VALUE);
    }

    /**
     * Random nullable double
     *
     * @return random nullable double
     */
    @Nullable
    public static Double nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random doubles
     *
     * @return random doubles
     */
    @NotNull
    public static List<Double> anyList() {
        List<Double> doubles = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> doubles.add(any()));
        return doubles;
    }

    /**
     * Random nullable doubles
     *
     * @return random nullable doubles
     */
    @NotNull
    public static List<Double> nullableAnyList() {
        List<Double> doubles = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> doubles.add(nullableAny()));
        return doubles;
    }

    /**
     * Random doubles
     *
     * @param length the length of the doubles
     * @return random doubles
     */
    @NotNull
    public static List<Double> anyList(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        List<Double> doubles = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, length)).forEach(number -> doubles.add(any()));
        return doubles;
    }

    /**
     * Random nullable doubles
     *
     * @return random nullable doubles
     */
    @NotNull
    public static List<Double> nullableAnyList(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        List<Double> doubles = new ArrayList<>();
        IntStream.range(0, MocInteger.any(length)).forEach(number -> doubles.add(nullableAny()));
        return doubles;
    }

}
