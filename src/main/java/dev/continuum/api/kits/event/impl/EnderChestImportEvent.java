package dev.continuum.api.kits.event.impl;

import dev.continuum.api.kits.SavedContents;
import dev.continuum.api.kits.event.CancellableKitEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public class EnderChestImportEvent extends CancellableKitEvent {
    private final int position;
    private final SavedContents contents;

    public EnderChestImportEvent(final @NotNull Player player, final int position, final @NotNull SavedContents contents) {
        super(player);
        this.position = position;
        this.contents = contents;
    }

    public int getPosition() {
        return position;
    }

    public int getEnderChest() {
        return getPosition();
    }

    @NotNull
    @Unmodifiable
    public SavedContents getImported() {
        return contents;
    }
}
