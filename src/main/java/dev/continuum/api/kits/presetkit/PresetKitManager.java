package dev.continuum.api.kits.presetkit;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface PresetKitManager {
    @NotNull
    @Unmodifiable
    Map<String, PresetKit> getCache();

    @NotNull
    PresetKit cache(final @NotNull PresetKit presetKit);

    @NotNull
    PresetKit uncache(final @NotNull PresetKit presetKit);

    @NotNull
    default Optional<PresetKit> getFromCache(final @NotNull String identifier) {
        return Optional.ofNullable(getCache().get(identifier));
    }

    @NotNull
    CompletableFuture<PresetKit> save(final @NotNull PresetKit presetKit);

    @NotNull
    CompletableFuture<PresetKit> update(final @NotNull PresetKit presetKit);

    @NotNull
    CompletableFuture<PresetKit> retrieve(final @NotNull String identifier);
}