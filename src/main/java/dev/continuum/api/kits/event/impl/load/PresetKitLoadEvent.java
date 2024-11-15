package dev.continuum.api.kits.event.impl.load;

import dev.continuum.api.kits.event.CancellableKitEvent;
import dev.continuum.api.kits.presetkit.PresetKit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PresetKitLoadEvent extends CancellableKitEvent {
    private final PresetKit presetKit;

    public PresetKitLoadEvent(final @NotNull Player player, final @NotNull PresetKit presetKit) {
        super(player);
        this.presetKit = presetKit;
    }

    @NotNull
    public PresetKit getPresetKit() {
        return presetKit;
    }

    @NotNull
    public String getIdentifier() {
        return getPresetKit().getIdentifier();
    }
}
