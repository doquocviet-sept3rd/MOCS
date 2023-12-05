package org.mocs.types.strings;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.booleans.MocBoolean;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The MocString class represents
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 */

@SuppressWarnings("unused")
public class MocString extends MocFactory {
    private static final Integer DEFAULT_LENGTH = 255;
    protected static final List<String> CHARS = new ArrayList<>();
    protected static final int CHARS_LENGTH;

    static {
        for (int asciiChar = 32; asciiChar < 126; asciiChar++) {
            CHARS.add(String.valueOf((char) asciiChar));
        }
        CHARS_LENGTH = CHARS.size();
    }

    /**
     * Random string with random length
     *
     * @return the random string
     */
    @NotNull
    public static String any() {
        return any(RANDOM.nextInt(DEFAULT_LENGTH));
    }

    @Nullable
    public static String nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random string with specified length
     *
     * @param length the length to randomize
     * @return the random string
     */
    @NotNull
    public static String any(int length) {
        StringBuilder result = new StringBuilder();
        while (length > 0) {
            result.append(CHARS.get(RANDOM.nextInt(CHARS_LENGTH)));
            length--;
        }
        return result.toString();
    }

    @NotNull
    public static List<String> anyList() {
        final List<String> strings = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> strings.add(any()));
        return strings;
    }

    @NotNull
    public static List<String> nullableAnyList() {
        final List<String> strings = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, DEFAULT_LIST_LENGTH)).forEach(number -> strings.add(nullableAny()));
        return strings;
    }

    @NotNull
    public static List<String> anyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be greater than zero");
        }
        final List<String> strings = new ArrayList<>();
        IntStream.range(0, MocInteger.any(length)).forEach(number -> strings.add(any()));
        return strings;
    }

    @NotNull
    public static List<String> nullableAnyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be greater than zero");
        }
        final List<String> strings = new ArrayList<>();
        IntStream.range(0, MocInteger.any(length)).forEach(number -> strings.add(nullableAny()));
        return strings;
    }


}
