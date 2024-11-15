package dev.continuum.api.kits;

import org.bukkit.Material;
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
public interface SavedContents {
    @NotNull
    static SavedContents empty() {
        return ConcurrentHashMap::new;
    }

    @NotNull
    static SavedContents create(final @NotNull Map<Integer, ItemStack> contents) {
        return () -> contents;
    }

    @NotNull
    static SavedContents create(final @NotNull Supplier<Map<Integer, ItemStack>> contents) {
        return contents::get;
    }

    @NotNull
    @Unmodifiable
    Map<Integer, ItemStack> getAsMap();

    @NotNull
    @Unmodifiable
    default List<ItemStack> getAsList() {
        final List<ItemStack> list = new ArrayList<>();

        for (final ItemStack item : getAsMap().values()) {
            list.add(Objects.requireNonNullElse(item, new ItemStack(Material.AIR)));
        }

        return list;
    }

    @NotNull
    @Unmodifiable
    default ItemStack @NotNull [] getAsArray() {
        return getAsList().toArray(ItemStack[]::new);
    }

    default boolean isEmpty() {
        final boolean isEmpty = getAsMap().isEmpty();
        if (isEmpty) return true;

        final int size = getAsMap().size();
        int foundAir = 0;

        for (final ItemStack item : getAsMap().values()) {
            if (item.isEmpty() || item.getType() == Material.AIR || item.getAmount() <= 0) foundAir++;
        }

        return foundAir == size;
    }
}

