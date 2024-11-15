package dev.continuum.api.kits.data;

import dev.continuum.api.kits.PlayerKits;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

public interface PlayerData {
    @NotNull
    PlayerKits getKits();

    @NotNull
    PlayerKits getEnderChests();

    // If empty it means that it's disabled.
    // If empty it will also load recently used kit on kill.
    @NotNull
    Optional<Integer> getAutoKitSelected();

    // If empty it should mean that either the database was recently reset or the player just joined for the first time.
    @NotNull
    Optional<Integer> getLastUsedKit();

    @NotNull
    UUID getUUID();

    @NotNull
    default Optional<Player> getPlayer() {
        return Optional.ofNullable(Bukkit.getPlayer(getUUID()));
    }

    // This is just a wrapper for YAML really.
    // Note: The object can be a map containing String to Object
    @NotNull
    @Unmodifiable
    Map<String, Object> getStoredData();

    <V> void set(final @NotNull String key, final @Nullable V value);

    default void unset(final @NotNull String key) {
        set(key, null);
    }

    @NotNull
    Optional<Object> get(final @NotNull String key);

    @NotNull
    default List<?> getList(final @NotNull String key) {
        try {
            return (List<?>) get(key).orElseGet(ArrayList::new);
        } catch (final Exception ignored) {
            return new ArrayList<>();
        }
    }

    @NotNull
    default List<String> getStringList(final @NotNull String key) {
        try {
            return (List<String>) getList(key);
        } catch (final Exception ignored) {
            return new ArrayList<>();
        }
    }

    @NotNull
    default <V> Optional<V> get(final @NotNull String key, final @NotNull Class<V> type) {
        final Object object = get(key).orElse(null);
        if (object == null) return Optional.empty();

        try {
            return Optional.of(type.cast(object));
        } catch (final Exception e) {
            return Optional.empty();
        }
    }

    @NotNull
    default Object get(final @NotNull String key, final @NotNull Object fallback) {
        return get(key).orElse(fallback);
    }

    @NotNull
    default <V> V get(final @NotNull String key, final @NotNull Class<V> type, final @NotNull V fallback) {
        return get(key, type).orElse(fallback);
    }
}
