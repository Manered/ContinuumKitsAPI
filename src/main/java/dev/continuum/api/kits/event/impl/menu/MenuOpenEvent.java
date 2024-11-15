package dev.continuum.api.kits.event.impl.menu;

import dev.continuum.api.kits.event.CancellableKitEvent;
import dev.manere.imenus.menu.InitializedMenu;
import dev.manere.imenus.menu.Menu;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class MenuOpenEvent<M extends Menu> extends CancellableKitEvent {
    private final Menu menu;
    private InitializedMenu<M> redirect = null;
    private final String identifier;

    public MenuOpenEvent(final @NotNull Player player, final @NotNull M menu, final @NotNull String identifier) {
        super(player);
        this.menu = menu;
        this.identifier = identifier;
    }

    public void redirect(final @NotNull InitializedMenu<M> menu) {
        this.redirect = menu;
    }

    @NotNull
    public Menu getMenu() {
        return menu;
    }

    @NotNull
    public Optional<InitializedMenu<M>> getRedirect() {
        return Optional.ofNullable(redirect);
    }

    @NotNull
    public String getIdentifier() {
        return identifier;
    }
}
