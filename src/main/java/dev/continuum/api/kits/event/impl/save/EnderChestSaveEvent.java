package dev.continuum.api.kits.event.impl.save;

import dev.continuum.api.kits.SavedContents;
import dev.continuum.api.kits.event.CancellableKitEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public class EnderChestSaveEvent extends CancellableKitEvent {
    private final int position;
    private SavedContents contents;

    public EnderChestSaveEvent(final @NotNull Player player, final int position, final @NotNull SavedContents contents) {
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
    public SavedContents getContents() {
        return contents;
    }

    public void setContents(final @NotNull SavedContents contents) {
        this.contents = contents;
    }
}
