package dev.continuum.api.kits.kitroom;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KitRoomCategory {
    @NotNull
    Material getIcon();

    @NotNull
    String getIdentifier();

    @NotNull
    CategorySavedContents getContents();

    void setIcon(final @Nullable Material icon);

    void setContents(final @NotNull CategorySavedContents contents);
}
