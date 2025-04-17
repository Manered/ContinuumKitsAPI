package dev.continuum.api.kits.kitroom;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

@FunctionalInterface
public interface CategorySavedContents {
    @NotNull
    static CategorySavedContents empty() {
        return ConcurrentHashMap::new;
    }

    @NotNull
    static CategorySavedContents create(final @NotNull Map<Integer, CategoryItem> contents) {
        return () -> contents;
    }

    @NotNull
    static CategorySavedContents create(final @NotNull Supplier<Map<Integer, CategoryItem>> contents) {
        return contents::get;
    }

    @NotNull
    @Unmodifiable
    Map<Integer, CategoryItem> getAsMap();

    @NotNull
    @Unmodifiable
    default List<CategoryItem> getAsList() {
        final List<CategoryItem> list = new ArrayList<>();

        for (final CategoryItem item : getAsMap().values()) {
            list.add(Objects.requireNonNullElse(item, new CategoryItem(ItemStack.empty())));
        }

        return list;
    }

    @NotNull
    @Unmodifiable
    default CategoryItem @NotNull [] getAsArray() {
        return getAsList().toArray(CategoryItem[]::new);
    }
}

