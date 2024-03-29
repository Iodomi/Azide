package xyz.azide.value.impl;

import xyz.azide.value.Value;

import java.awt.*;
import java.util.function.Supplier;

/**
 * @author plusbox
 * @since 11/14/2023
 * @version 1.0
 */
public final class ColorValue extends Value<Color> {
    public ColorValue(final String name, final Color value, final Supplier<Boolean> supplier) {
        super(name, value, supplier);
    }

    public ColorValue(final String name, final Color value) {
        super(name, value);
    }
}
