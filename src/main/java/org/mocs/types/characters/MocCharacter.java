package org.mocs.types.characters;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.booleans.MocBoolean;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The MocCharacter class
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 * @see Character
 */

@SuppressWarnings("unused")
public class MocCharacter extends MocFactory {
    protected static final List<Character> CHARS = new ArrayList<>();
    protected static final int CHARS_LENGTH;

    static {
        for (int asciiChar = 32; asciiChar < 126; asciiChar++) {
            CHARS.add((char) asciiChar);
        }
        CHARS_LENGTH = CHARS.size();
    }

    /**
     * Random character
     *
     * @return random character
     */
    @NotNull
    public static Character any() {
        final int index = RANDOM.nextInt(CHARS_LENGTH);
        return CHARS.get(index);
    }

    /**
     * Random nullable character
     *
     * @return random nullable character
     */
    @Nullable
    public static Character nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random characters
     *
     * @param excludes the characters to exclude
     * @return random characters
     */
    @NotNull
    public static Character any(@NotNull final List<Character> excludes) {
        if (excludes.contains(null)) {
            throw new IllegalArgumentException("Excludes element must not be null");
        }
        Character character;
        do {
            character = CHARS.get(MocInteger.any(CHARS_LENGTH));
        }
        while (excludes.contains(character));
        return character;
    }

    /**
     * Random nullable characters
     *
     * @param excludes the characters to exclude
     * @return random nullable characters
     */
    @Nullable
    public static Character nullableAny(@NotNull final List<Character> excludes) {
        if (excludes.contains(null)) {
            throw new IllegalArgumentException("Excludes element must not be null");
        }
        if (MocBoolean.any()) {
            return null;
        }
        Character character;
        do {
            character = CHARS.get(MocInteger.any(CHARS_LENGTH));
        }
        while (excludes.contains(character));
        return character;
    }

    /**
     * Random characters
     *
     * @return random characters
     */
    @NotNull
    public static List<Character> anyList() {
        final List<Character> characters = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> characters.add(any()));
        return characters;
    }

    /**
     * Random nullable characters
     *
     * @return random nullable characters
     */
    @NotNull
    public static List<Character> nullableAnyList() {
        final List<Character> characters = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> characters.add(nullableAny()));
        return characters;
    }

    /**
     * Random characters
     *
     * @param length length of characters
     * @return random characters
     */
    @NotNull
    public static List<Character> anyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        final List<Character> characters = new ArrayList<>();
        IntStream.range(0, length).forEach(number -> characters.add(any()));
        return characters;
    }

    /**
     * Random nullable characters
     *
     * @param length length of characters
     * @return random nullable characters
     */
    @NotNull
    public static List<Character> nullableAnyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        final List<Character> characters = new ArrayList<>();
        IntStream.range(0, length).forEach(number -> characters.add(nullableAny()));
        return characters;
    }

}
