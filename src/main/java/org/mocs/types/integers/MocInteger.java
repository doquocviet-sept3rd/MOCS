package org.mocs.types.integers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.booleans.MocBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * The MocInteger class
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 * @see Integer
 */

@SuppressWarnings("unused")
public class MocInteger extends MocFactory {
    /**
     * A constant holding the minimum value an {@code int} can
     * have, -2<sup>31</sup>.
     */
    private static final int MIN_VALUE = 0x80000000;

    /**
     * A constant holding the maximum value an {@code int} can
     * have, 2<sup>31</sup>-1.
     */
    private static final int MAX_VALUE = 0x7fffffff;

    /**
     * Random integer
     *
     * @return Random integer
     */
    @NotNull
    public static Integer any() {
        return RANDOM.nextInt(MIN_VALUE, MAX_VALUE);
    }

    /**
     * Random nullable integer
     *
     * @return Random nullable integer
     */
    @Nullable
    public static Integer nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random integer with min is zero
     *
     * @param max the maximum value
     * @return Random integer with min is zero
     */
    @NotNull
    public static Integer any(@NotNull Integer max) {
        return RANDOM.nextInt(max);
    }

    /**
     * Random integers
     *
     * @return Random integers
     */
    @NotNull
    public static List<Integer> anyList() {
        final List<Integer> integers = new ArrayList<>();
        IntStream.range(0, any(1, DEFAULT_LIST_LENGTH)).forEach(number -> integers.add(any()));
        return integers;
    }

    /**
     * Random nullable integers
     *
     * @return Random nullable integers
     */
    @NotNull
    public static List<Integer> nullableAnyList() {
        final List<Integer> integers = new ArrayList<>();
        IntStream.range(0, any(1, DEFAULT_LIST_LENGTH)).forEach(number -> integers.add(nullableAny()));
        return integers;
    }

    /**
     * Random integers
     *
     * @param length the length of the integers
     * @return Random integers
     */
    @NotNull
    public static List<Integer> anyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be greater than zero");
        }
        final List<Integer> integers = new ArrayList<>();
        IntStream.range(0, any(1, length)).forEach(number -> integers.add(any()));
        return integers;
    }

    /**
     * Random nullable integers
     *
     * @param length the length of the integers
     * @return Random nullable integers
     */
    @NotNull
    public static List<Integer> nullableAnyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be greater than zero");
        }
        final List<Integer> integers = new ArrayList<>();
        IntStream.range(0, any(1, length)).forEach(number -> integers.add(nullableAny()));
        return integers;
    }

    /**
     * Random integer
     *
     * @param min the minimum value
     * @param max the maximum value
     * @return Random integer
     */
    @NotNull
    public static Integer any(@Nullable Integer min, @Nullable Integer max) {
        min = Optional.ofNullable(min).orElse(MIN_VALUE);
        max = Optional.ofNullable(max).orElse(MAX_VALUE);
        return RANDOM.nextInt(min, max);
    }

}
