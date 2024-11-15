package dev.continuum.api.kits;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerKits {
    private final Map<Integer, SavedContents> all = new ConcurrentHashMap<>();

    @NotNull
    @Unmodifiable
    public Map<Integer, SavedContents> getAll() {
        return all;
    }

    @NotNull
    public SavedContents get(final int position) {
        return getAll().getOrDefault(position, SavedContents.empty());
    }

    public void set(final int position, final @NotNull SavedContents contents) {
        all.put(position, contents);
    }
}
