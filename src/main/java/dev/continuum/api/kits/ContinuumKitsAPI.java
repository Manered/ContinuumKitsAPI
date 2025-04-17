package dev.continuum.api.kits;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dev.continuum.api.kits.data.PlayerDataManager;
import dev.continuum.api.kits.event.EventManager;
import dev.continuum.api.kits.kitroom.KitRoomManager;
import dev.continuum.api.kits.presetkit.PresetKitManager;
import dev.continuum.api.kits.util.PermissionConstants;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
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
    CompletableFuture<Void> loadKit(final @NotNull Player player, final int position, final boolean silent);

    @NotNull
    @CanIgnoreReturnValue
    CompletableFuture<Void> loadEnderChest(final @NotNull Player player, final int position, final boolean silent);

    @NotNull
    @CanIgnoreReturnValue
    CompletableFuture<Void> loadAutoKit(final @NotNull Player player, final boolean silent);

    @NotNull
    @CanIgnoreReturnValue
    CompletableFuture<Void> loadPresetKit(final @NotNull Player player, final @NotNull String identifier, final boolean silent);

    @NotNull
    @CanIgnoreReturnValue
    default CompletableFuture<Void> loadKit(final @NotNull Player player, final int position) {
        return loadKit(player, position, false);
    }

    @NotNull
    @CanIgnoreReturnValue
    default CompletableFuture<Void> loadEnderChest(final @NotNull Player player, final int position) {
        return loadEnderChest(player, position, false);
    }

    @NotNull
    @CanIgnoreReturnValue
    default CompletableFuture<Void> loadAutoKit(final @NotNull Player player) {
        return loadAutoKit(player, false);
    }

    @NotNull
    @CanIgnoreReturnValue
    default CompletableFuture<Void> loadPresetKit(final @NotNull Player player, final @NotNull String identifier) {
        return loadPresetKit(player, identifier, false);
    }

    default boolean hasMoreKitSlots(final @NotNull Permissible permissible) {
        return permissible.hasPermission(PermissionConstants.MORE_KITS) || permissible.hasPermission(PermissionConstants.ADMIN) ;
    }

    default boolean canEquipKits(final @NotNull Permissible permissible) {
        return permissible.hasPermission(PermissionConstants.EQUIP_KITS);
    }

    default boolean isAdmin(final @NotNull Permissible permissible) {
        return permissible.hasPermission(PermissionConstants.ADMIN);
    }
}