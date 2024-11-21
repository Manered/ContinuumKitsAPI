package dev.continuum.api.kits.presetkit;

import dev.continuum.api.kits.SavedContents;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.List;

public interface PresetKit {
    @NotNull
    String getIdentifier();

    @NotNull
    default Component displayName() {
        return MiniMessage.miniMessage().deserialize(getDisplayName());
    }

    @NotNull
    String getDisplayName();

    @NotNull
    @Unmodifiable
    default List<Component> description() {
        final List<Component> description = new ArrayList<>();

        for (final String element : getDescription()) {
            description.add(MiniMessage.miniMessage().deserialize(element));
        }

        return description;
    }

    @NotNull
    @Unmodifiable
    List<String> getDescription();

    @NotNull
    SavedContents getContents();

    void setDescription(final @NotNull List<String> description);

    default void setDescription(final @NotNull String @NotNull ... description) {
        setDescription(List.of(description));
    }

    void setDisplayName(final @Nullable String displayName);

    default void clearDescription() {
        setDescription();
    }

    default void addDescription(final @NotNull String element) {
        final List<String> description = new ArrayList<>(getDescription());
        description.add(element);

        setDescription(description);
    }

    void setContents(final @NotNull SavedContents contents);
}
