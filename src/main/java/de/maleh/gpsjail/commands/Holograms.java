package de.maleh.gpsjail.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class Holograms {
    public static List<Holograms> holos = new ArrayList<>();

    private ArmorStand hologram;

    private String text;

    private Location loc;

    public ArmorStand getHologram() {
        return this.hologram;
    }

    public String getText() {
        return this.text;
    }

    public Location getLocation() {
        return this.loc;
    }

    public Holograms(Location loc, String text) {
        this.loc = loc;
        this.text = text;
    }

    public void create() {
        this.hologram = (ArmorStand)this.loc.subtract(0.0D, 1.0D, 0.0D).getWorld().spawn(this.loc, ArmorStand.class);
        this.hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', this.text));
        this.hologram.setCustomNameVisible(true);
        this.hologram.setGravity(false);
        this.hologram.setVisible(false);
        holos.add(this);
    }

    public void remove() {
        this.hologram.remove();
        holos.remove(this);
    }

    public void teleport(Location loc) {
        this.hologram.teleport(loc);
    }

    public void changeText(String text) {
        this.hologram.setCustomName(text);
    }

    public static Holograms getByLocation(Location loc) {
        for (Holograms holo : holos) {
            if (holo.getLocation().distance(loc) <= 3.0D)
                return holo;
        }
        return null;
    }
}