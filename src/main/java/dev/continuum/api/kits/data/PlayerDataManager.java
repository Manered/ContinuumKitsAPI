package dev.continuum.api.kits.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlayerDataManager {
    @NotNull
    @Unmodifiable
    Map<UUID, PlayerData> getCache();

    @NotNull
    PlayerData cache(final @NotNull PlayerData data);

    @NotNull
    PlayerData uncache(final @NotNull PlayerData data);

    @NotNull
    default Optional<PlayerData> getFromCache(final @NotNull UUID uuid) {
        return Optional.ofNullable(getCache().get(uuid));
    }

    @NotNull
    CompletableFuture<PlayerData> save(final @NotNull PlayerData data);

    @NotNull
    CompletableFuture<PlayerData> update(final @NotNull PlayerData data);

    @NotNull
    CompletableFuture<PlayerData> retrieve(final @NotNull UUID uuid);
}
