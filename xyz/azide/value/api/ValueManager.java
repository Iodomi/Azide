package xyz.azide.value.api;

import xyz.azide.Azide;
import xyz.azide.module.Module;
import xyz.azide.trait.Manager;
import xyz.azide.value.Value;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author plusbox
 * @version 1.0
 * @since 11/14/2023
 */
public final class ValueManager implements Manager {
    private final HashMap<Class<? extends Module>, ValueContainer> moduleValueContainerMap;

    public ValueManager() {
        moduleValueContainerMap = new HashMap<>();
    }

    @Override
    public void initialize() {
        for (final Module module : Azide.getSingleton().getModuleManager().getModules()) {
            final ValueContainer valueContainer = new ValueContainer();

            for (final Field field : module.getClass().getDeclaredFields()) {
                if (Value.class.isAssignableFrom(field.getType())) {
                    try {
                        final Value<?> value = (Value<?>) field.get(module);
                        valueContainer.getStringValueMap().put(value.getName(), value);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    public HashMap<Class<? extends Module>, ValueContainer> getModuleValueContainerMap() {
        return moduleValueContainerMap;
    }
}