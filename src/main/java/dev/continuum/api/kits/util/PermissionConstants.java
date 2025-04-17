package dev.continuum.api.kits.util;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;

public interface PermissionConstants {
    @NotNull
    Permission MORE_KITS = new Permission("continuum.kits.more-kits", PermissionDefault.OP);

    @NotNull
    Permission EQUIP_KITS = new Permission("continuum.kits.equip-kits", PermissionDefault.TRUE);

    @NotNull
    Permission ADMIN = new Permission("continuum.kits.admin", PermissionDefault.OP);
}
