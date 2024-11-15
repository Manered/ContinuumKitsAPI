package dev.continuum.api.kits.event.impl;

import dev.continuum.api.kits.event.CancellableKitEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandEvent extends CancellableKitEvent {
    private final String buffer;

    public CommandEvent(final @NotNull Player player, @NotNull String buffer) {
        super(player);
        if (buffer.startsWith("/")) buffer = buffer.replaceFirst("/", "");
        this.buffer = buffer;
    }

    @NotNull
    public String getBuffer() {
        return buffer;
    }

    @NotNull
    public String getCommand() {
        return buffer.split(" ")[0];
    }

    @NotNull
    public String getArgumentBuffer() {
        final String[] array = getBuffer().split(" ");
        if (array.length == 1) return "";

        final StringBuilder argumentBuffer = new StringBuilder();

        for (int i = 1; i < array.length; i++) {
            argumentBuffer.append(array[i]);
        }

        return argumentBuffer.toString();
    }

    @NotNull
    public String[] getArguments() {
        return getArgumentBuffer().split(" ");
    }
}
