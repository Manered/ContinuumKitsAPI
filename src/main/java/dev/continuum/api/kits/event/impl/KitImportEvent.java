package dev.continuum.api.kits.event.impl;

import dev.continuum.api.kits.SavedContents;
import dev.continuum.api.kits.event.CancellableKitEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public class KitImportEvent extends CancellableKitEvent {
    private final int position;
    private final SavedContents contents;

    public KitImportEvent(final @NotNull Player player, final int position, final @NotNull SavedContents contents) {
        super(player);
        this.position = position;
        this.contents = contents;
    }

    public int getPosition() {
        return position;
    }

    public int getKit() {
        return getPosition();
    }

    @NotNull
    @Unmodifiable
    public SavedContents getImported() {
        return contents;
    }
}
