package dev.continuum.api.kits.kitroom;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class CategoryItem {
    private final ItemStack item;
    private final boolean cancelClickEvents;

    public CategoryItem(final @NotNull ItemStack item, final boolean cancelClickEvents) {
        this.item = item;
        this.cancelClickEvents = cancelClickEvents;
    }

    public CategoryItem(final @NotNull ItemStack item) {
        if (item.isEmpty()) {
            this.item = item;
            this.cancelClickEvents = true;
            return;
        }

        this.item = item;
        this.cancelClickEvents = false;
    }

    @NotNull
    public static CategoryItem of(final @NotNull ItemStack item, final boolean cancelClickEvents) {
        return new CategoryItem(item, cancelClickEvents);
    }

    @NotNull
    public static CategoryItem of(final @NotNull ItemStack item) {
        return new CategoryItem(item);
    }

    @NotNull
    public static CategoryItem convert(final @NotNull ItemStack item) {
        return of(item);
    }

    @NotNull
    public static ItemStack convert(final @NotNull CategoryItem categoryItem) {
        final ItemStack item = categoryItem.getItem();

        item.editMeta(meta -> meta.getPersistentDataContainer().set(
            new NamespacedKey("continuum_kits", "should_cancel_click_events"),
            PersistentDataType.BOOLEAN,
            categoryItem.shouldCancelClickEvents())
        );

        return item;
    }

    public static boolean shouldCancelClickEvents(final @NotNull ItemStack item) {
        final ItemMeta meta = item.getItemMeta();
        if (meta == null || !item.hasItemMeta()) return false;

        return Boolean.TRUE.equals(meta.getPersistentDataContainer().get(
            new NamespacedKey("continuum_kits", "should_cancel_click_events"),
            PersistentDataType.BOOLEAN
        ));
    }

    public boolean shouldCancelClickEvents() {
        return cancelClickEvents;
    }

    @NotNull
    public ItemStack getItem() {
        return item;
    }
}
