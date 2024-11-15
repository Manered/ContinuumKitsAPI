package dev.continuum.api.kits.event;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dev.continuum.api.kits.ContinuumKitsAPI;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class EventManager {
    private final Map<Class<? extends KitEvent>, Set<Consumer<? extends KitEvent>>> registered = new ConcurrentHashMap<>();

    @SuppressWarnings("UnstableApiUsage")
    public <E extends KitEvent> void listen(final @Nullable Plugin registrar, final @NotNull Class<E> eventType, final @NotNull Consumer<E> handler) {
        registered.putIfAbsent(eventType, new HashSet<>());
        registered.getOrDefault(eventType, new HashSet<>()).add(e -> handler.accept((E) e));

        ContinuumKitsAPI.getPlugin()
            .flatMap(plugin -> Optional.of(plugin.getLogger()))
            .ifPresent(logger -> logger.info("Registered a event listener for "
                + eventType.getSimpleName()
                + " by "
                + (registrar != null ? registrar.getPluginMeta().getDisplayName() : "Unknown Plugin")
            ));
    }

    public <E extends KitEvent> void listen(final @NotNull Class<E> eventType, final @NotNull Consumer<E> handler) {
        listen(null, eventType, handler);
    }

    @ApiStatus.Internal
    @CanIgnoreReturnValue
    public <E extends KitEvent> E fire(final @NotNull E event) {
        for (final Map.Entry<Class<? extends KitEvent>, Set<Consumer<? extends KitEvent>>> entry : registered.entrySet()) {
            final Class<? extends KitEvent> type = entry.getKey();
            final Set<Consumer<? extends KitEvent>> handlers = entry.getValue();
            if (handlers == null || type == null) continue;

            for (final Consumer<? extends KitEvent> handler : handlers) {
                if (handler == null) continue;

                if (event instanceof CancellableKitEvent cancellable) {
                    ((Consumer<E>) handler).accept((E) cancellable);
                    if (cancellable.isCancelled()) return event;
                } else {
                    ((Consumer<E>) handler).accept(event);
                }
            }
        }

        return event;
    }
}
