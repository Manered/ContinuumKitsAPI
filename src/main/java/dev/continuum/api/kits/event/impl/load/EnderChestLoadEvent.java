package dev.continuum.api.kits.event.impl.load;

import dev.continuum.api.kits.SavedContents;
import dev.continuum.api.kits.event.CancellableKitEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnderChestLoadEvent extends CancellableKitEvent {
    private final SavedContents contents;
    private final int position;

    public EnderChestLoadEvent(final @NotNull Player player, final @NotNull SavedContents contents, final int position) {
        super(player);
        this.contents = contents;
        this.position = position;
    }

    @NotNull
    public SavedContents getContents() {
        return contents;
    }

    public int getPosition() {
        return position;
    }

    public int getEnderChest() {
        return getPosition();
    }
}
