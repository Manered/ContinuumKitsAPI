package dev.continuum.api.kits.kitroom;

import dev.continuum.api.kits.SavedContents;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface KitRoomCategory {
    @NotNull
    ItemStack getIcon();

    @NotNull
    String getIdentifier();

    @NotNull
    CategorySavedContents getContents();

    void setIcon(final @NotNull ItemStack icon);

    void setContents(final @NotNull CategorySavedContents contents);
}
