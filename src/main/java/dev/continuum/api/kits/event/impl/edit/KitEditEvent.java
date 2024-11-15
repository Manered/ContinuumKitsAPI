package dev.continuum.api.kits.event.impl.edit;

import dev.continuum.api.kits.event.CancellableKitEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KitEditEvent extends CancellableKitEvent {
    private final int position;

    public KitEditEvent(final @NotNull Player player, final int position) {
        super(player);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int getKit() {
        return getPosition();
    }
}
