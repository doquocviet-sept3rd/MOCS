package org.mocs.types.dates;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.booleans.MocBoolean;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The MocDate class
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 * @see Date
 */

@SuppressWarnings("unused")
public class MocDate extends MocFactory {

    /**
     * Random date
     *
     * @return Random date
     */
    @NotNull
    public static Date any() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * Random nullable date
     *
     * @return Random nullable date
     */
    @Nullable
    public static Date nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random dates
     *
     * @return Random dates
     */
    @NotNull
    public static List<Date> anyList() {
        final List<Date> dates = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> dates.add(any()));
        return dates;
    }

    /**
     * Random nullable dates
     *
     * @return Random nullable dates
     */
    @NotNull
    public static List<Date> nullableAnyList() {
        final List<Date> dates = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> dates.add(nullableAny()));
        return dates;
    }

    /**
     * Random dates
     *
     * @param length the length of dates
     * @return Random dates
     */
    @NotNull
    public static List<Date> anyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be negative.");
        }
        final List<Date> dates = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> dates.add(any()));
        return dates;
    }

    /**
     * Random nullable dates
     *
     * @param length the length of dates
     * @return Random nullable dates
     */
    @NotNull
    public static List<Date> nullableAnyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be negative.");
        }
        final List<Date> dates = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, DEFAULT_LIST_LENGTH)).forEach(number -> dates.add(nullableAny()));
        return dates;
    }

}
