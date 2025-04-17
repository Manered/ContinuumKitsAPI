package dev.continuum.api.kits.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlayerDataManager {
    @NotNull
    @Unmodifiable
    Map<UUID, PlayerData> getCache();

    @NotNull
    PlayerData addToCache(final @NotNull PlayerData data);

    @NotNull
    PlayerData removeFromCache(final @NotNull PlayerData data);

    @NotNull
    CompletableFuture<PlayerData> upsert(final @NotNull PlayerData data);

    @NotNull
    CompletableFuture<PlayerData> retrieve(final @NotNull UUID uuid);
}
