package de.maleh.gpsjail.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArmorStand {
    private ItemStack hologramf = null;

    public ArmorStand() {
        this.hologramf = new ItemStack(Material.ARMOR_STAND);
        ItemMeta hologramfm = this.hologramf.getItemMeta();
        hologramfm.setDisplayName("spawnen");
        List<String> hologramlore = new ArrayList();
        hologramlore.add("Hologram");
        hologramfm.setLore(hologramlore);
        this.hologramf.setItemMeta(hologramfm);
    }

    public ItemStack getArmorStand() {
        return this.hologramf;
    }
}