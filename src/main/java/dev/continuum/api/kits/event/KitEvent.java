package dev.continuum.api.kits.event;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class KitEvent {
    private final Player player;

    public KitEvent(final @NotNull Player player) {
        this.player = player;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public UUID getUUID() {
        return getPlayer().getUniqueId();
    }
}
