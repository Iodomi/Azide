package xyz.azide.value.impl;

import xyz.azide.value.Value;

import java.util.function.Supplier;

/**
 * @author plusbox
 * @since 11/14/2023
 * @version 1.0
 */
public final class BooleanValue extends Value<Boolean> {
    public BooleanValue(final String name, final Boolean value, final Supplier<Boolean> supplier) {
        super(name, value, supplier);
    }

    public BooleanValue(final String name, final Boolean value) {
        super(name, value);
    }
}
