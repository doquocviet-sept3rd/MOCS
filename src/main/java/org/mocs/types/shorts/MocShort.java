package org.mocs.types.shorts;

import org.mocs.factory.MocFactory;

/**
 * The MocShort class
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 * @see Short
 */

@Deprecated
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

}
