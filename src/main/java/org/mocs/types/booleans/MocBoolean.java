/*
 * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.mocs.types.booleans;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mocs.factory.MocFactory;
import org.mocs.types.integers.MocInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The {@link MocBoolean} class
 *
 * @author <a href="mailto:doquocviet.sept3rd@gmail.com">Do Quoc Viet</a>
 * @see Boolean for this mock type
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
