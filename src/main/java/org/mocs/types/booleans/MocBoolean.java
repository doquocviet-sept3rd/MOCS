package org.mocs.types.booleans;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The MocBoolean class
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 * @see Boolean
 */

@SuppressWarnings("unused")
public class MocBoolean extends MocFactory {

    /**
     * Random boolean
     *
     * @return random boolean
     */
    @NotNull
    public static Boolean any() {
        return RANDOM.nextInt(2) == 1;
    }

    /**
     * Random nullable boolean
     *
     * @return random nullable boolean
     */
    @Nullable
    public static Boolean nullableAny() {
        return any() ? null : any();
    }

    /**
     * Random booleans
     *
     * @return random booleans
     */
    @NotNull
    public static List<Boolean> anyList() {
        final List<Boolean> booleans = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> booleans.add(any()));
        return booleans;
    }

    /**
     * Random nullable booleans
     *
     * @return random nullable booleans
     */
    @NotNull
    public static List<Boolean> nullableAnyList() {
        final List<Boolean> booleans = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, DEFAULT_LIST_LENGTH)).forEach(number -> booleans.add(nullableAny()));
        return booleans;
    }

    /**
     * Random booleans
     *
     * @param length the length of the list
     * @return random booleans
     */
    @NotNull
    public static List<Boolean> anyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        final List<Boolean> booleans = new ArrayList<>();
        IntStream.range(0, length).forEach(number -> booleans.add(any()));
        return booleans;
    }

    /**
     * Random nullable booleans
     *
     * @param length the length of the list
     * @return random nullable booleans
     */
    @NotNull
    public static List<Boolean> nullableAnyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        final List<Boolean> booleans = new ArrayList<>();
        IntStream.range(0, length).forEach(number -> booleans.add(nullableAny()));
        return booleans;
    }

}
