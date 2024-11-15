package dev.continuum.api.kits.event;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CancellableKitEvent extends KitEvent {
    private boolean cancelled = false;

    public CancellableKitEvent(final @NotNull Player player) {
        super(player);
    }

    public void cancel() {
        setCancelled(true);
    }

    public void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }
}
