package dev.continuum.api.kits.data;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dev.continuum.api.kits.PlayerKits;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public interface PlayerData {
    @NotNull
    PlayerKits getKits();

    @NotNull
    PlayerKits getEnderChests();

    @NotNull
    Optional<Integer> getAutoKitSelected();

    @NotNull
    @CanIgnoreReturnValue
    PlayerData setAutoKitSelected(final int autoKitSelected);

    @NotNull
    UUID getUUID();

    @NotNull
    default Optional<Player> getPlayer() {
        return Optional.ofNullable(Bukkit.getPlayer(getUUID()));
    }
}
