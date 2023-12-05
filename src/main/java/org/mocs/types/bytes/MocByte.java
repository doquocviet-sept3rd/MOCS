package org.mocs.types.bytes;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.types.booleans.MocBoolean;
import org.mocs.factory.MocFactory;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The MocByte class represents
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 */

@SuppressWarnings("unused")
public class MocByte extends MocFactory {

    /**
     * Random byte
     *
     * @return Random byte
     */
    @NotNull
    public static Byte any() {
        return (byte) (int) MocInteger.any(-128, 128);
    }

    /**
     * Random nullable byte
     *
     * @return Random nullable byte
     */
    @Nullable
    public static Byte nullableAny() {
        return MocBoolean.any() ? null : any();
    }

    /**
     * Random bytes
     *
     * @return Random bytes
     */
    @NotNull
    public static List<Byte> anyList() {
        final List<Byte> bytes = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, DEFAULT_LIST_LENGTH)).forEach(number -> bytes.add(any()));
        return bytes;
    }

    /**
     * Random nullable bytes
     *
     * @return Random nullable bytes
     */
    @NotNull
    public static List<Byte> nullableAnyList() {
        final List<Byte> bytes = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> bytes.add(nullableAny()));
        return bytes;
    }

    /**
     * Random bytes
     *
     * @param length length of random bytes
     * @return Random bytes
     */
    @NotNull
    public static List<Byte> anyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        final List<Byte> bytes = new ArrayList<>();
        IntStream.range(0, MocInteger.any(1, DEFAULT_LIST_LENGTH)).forEach(number -> bytes.add(any()));
        return bytes;
    }

    /**
     * Random nullable bytes
     *
     * @param length length of random bytes
     * @return Random nullable bytes
     */
    @NotNull
    public static List<Byte> nullableAnyList(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must not be less or equal to 0");
        }
        final List<Byte> bytes = new ArrayList<>();
        IntStream.range(0, MocInteger.any(DEFAULT_LIST_LENGTH)).forEach(number -> bytes.add(nullableAny()));
        return bytes;
    }

}
