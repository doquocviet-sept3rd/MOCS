package org.mocs.types.shorts;

import org.jetbrains.annotations.NotNull;
import org.mocs.factory.MocFactory;

/**
 * The MocShort class represents
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 */

@SuppressWarnings("unused")
public class MocShort extends MocFactory {
    /**
     * A constant holding the minimum value a {@code short} can
     * have, -2<sup>15</sup>.
     */
    private static final short MIN_VALUE = -32768;

    /**
     * A constant holding the maximum value a {@code short} can
     * have, 2<sup>15</sup>-1.
     */
    private static final short MAX_VALUE = 32767;

    @NotNull
    public static Short any() {
        return null;
    }
}
