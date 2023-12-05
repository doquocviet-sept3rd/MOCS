package org.mocs.types.longs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.booleans.MocBoolean;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * The MocLong class represents
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 */

@SuppressWarnings("unused")
public class MocLong extends MocFactory {
    /**
     * A constant holding the minimum value a {@code long} can
     * have, -2<sup>63</sup>.
     */
    private static final long MIN_VALUE = 0x8000000000000000L;

    /**
     * A constant holding the maximum value a {@code long} can
     * have, 2<sup>63</sup>-1.
     */
    private static final long MAX_VALUE = 0x7fffffffffffffffL;

    /**
     * Random long
     *
     * @return Random long
     */
    @NotNull
    public static Long any() {
        return RANDOM.nextLong(MIN_VALUE, MAX_VALUE);
    }

    /**
     * Random nullable long
     *
     * @return Random nullable long
     */
    @Nullable
    public static Long nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random longs
     *
     * @return Random longs
     */
    @NotNull
    public static List<Long> anyList() {
        final List<Long> longs = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, DEFAULT_LIST_LENGTH)).forEach(number -> longs.add(any()));
        return longs;
    }

    /**
     * Random nullable longs
     *
     * @return Random nullable longs
     */
    @NotNull
    public static List<Long> nullableAnyList() {
        final List<Long> longs = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> longs.add(nullableAny()));
        return longs;
    }

    /**
     * Random longs
     *
     * @param length the length of the longs
     * @return Random longs
     */
    @NotNull
    public static List<Long> anyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be greater than zero");
        }
        final List<Long> longs = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, DEFAULT_LIST_LENGTH)).forEach(number -> longs.add(any()));
        return longs;
    }

    /**
     * Random nullable longs
     *
     * @param length the length of the longs
     * @return Random nullable longs
     */
    @NotNull
    public static List<Long> nullableAnyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be greater than zero");
        }
        final List<Long> longs = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> longs.add(nullableAny()));
        return longs;
    }

    /**
     * Random long
     *
     * @param min the minimum value
     * @param max the maximum value
     * @return Random long
     */
    @NotNull
    public static Long any(@Nullable Long min, @Nullable Long max) {
        min = Optional.ofNullable(min).orElse(MIN_VALUE);
        max = Optional.ofNullable(max).orElse(MAX_VALUE);
        return RANDOM.nextLong(min, max);
    }
}
