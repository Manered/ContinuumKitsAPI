package dev.continuum.api.kits;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dev.continuum.api.kits.data.PlayerDataManager;
import dev.continuum.api.kits.event.EventManager;
import dev.continuum.api.kits.kitroom.KitRoomManager;
import dev.continuum.api.kits.presetkit.PresetKitManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ContinuumKitsAPI {
    @NotNull
    static Optional<ContinuumKitsAPI> get() {
        final RegisteredServiceProvider<ContinuumKitsAPI> rsp = Bukkit.getServicesManager().getRegistration(ContinuumKitsAPI.class);
        return rsp == null ? Optional.empty() : Optional.of(rsp.getProvider());
    }

    @NotNull
    static Optional<? extends Plugin> getPlugin() {
        final RegisteredServiceProvider<ContinuumKitsAPI> rsp = Bukkit.getServicesManager().getRegistration(ContinuumKitsAPI.class);
        return rsp == null ? Optional.empty() : Optional.of(rsp.getPlugin());
    }

    @NotNull
    EventManager getEventManager();

    @NotNull
    PlayerDataManager getPlayerDataManager();

    @NotNull
    PresetKitManager getPresetKitManager();

    @NotNull
    KitRoomManager getKitRoomManager();

    @NotNull
    @CanIgnoreReturnValue
    CompletableFuture<Void> loadKit(final @NotNull Player player, final int position);

    @NotNull
    @CanIgnoreReturnValue
    CompletableFuture<Void> loadEnderChest(final @NotNull Player player, final int position);

    @NotNull
    @CanIgnoreReturnValue
    CompletableFuture<Void> loadAutoKit(final @NotNull Player player);

    @NotNull
    @CanIgnoreReturnValue
    CompletableFuture<Void> loadPresetKit(final @NotNull Player player, final @NotNull String identifier);
}