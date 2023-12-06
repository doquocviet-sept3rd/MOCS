package org.mocs.factory;

import java.util.Random;

/**
 * The {@link MocFactory} class
 * <p>This class contains the generic variables which can be used to generate random values</p>
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 */
public class MocFactory {

    /**
     * Construct a new instance of Random value
     */
    protected static final Random RANDOM;

    /**
     * Default length of list when generating random list
     */
    protected static final Integer DEFAULT_LIST_LENGTH;

    static {
        RANDOM = new Random();
        DEFAULT_LIST_LENGTH = 100;
    }

}
