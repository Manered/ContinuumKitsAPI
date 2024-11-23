package dev.continuum.api.kits.kitroom;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface KitRoomManager {
    @NotNull
    @Unmodifiable
    Map<String, KitRoomCategory> getCache();

    @NotNull
    KitRoomCategory cache(final @NotNull KitRoomCategory category);

    @NotNull
    KitRoomCategory uncache(final @NotNull KitRoomCategory category);

    @NotNull
    default Optional<KitRoomCategory> getFromCache(final @NotNull String identifier) {
        return Optional.ofNullable(getCache().get(identifier));
    }

    @NotNull
    CompletableFuture<KitRoomCategory> save(final @NotNull KitRoomCategory category);

    @NotNull
    CompletableFuture<KitRoomCategory> update(final @NotNull KitRoomCategory category);

    @NotNull
    CompletableFuture<KitRoomCategory> retrieve(final @NotNull String identifier);

    @NotNull
    CompletableFuture<Void> delete(final @NotNull String identifier);
}
