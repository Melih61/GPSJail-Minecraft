package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Trust;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class TrustCommand extends AbstractCommand {

    public TrustCommand() {
        super("trust");
    }

    @Override
    public String getHelpMessage() {
        return "trust <add:remove> <Player>";
    }

    public String getDescription() {
        return "Add or remove a player to trustlist";
    }

    @Override
    public void setupCommand() {
        registerParameter(2, (p, args) -> {
            if (args[1].equalsIgnoreCase("add")) {
                Player target = Bukkit.getPlayer(args[2]);
                OfflinePlayer targeto = Bukkit.getOfflinePlayer(args[2]);
                if (target == null) {
                    if (Trust.contains(targeto.getName().toLowerCase())) {
                        MessagesUtils.form(p, "§cThe player is already added to the trustlist");
                    } else {
                        Trust.add(targeto.getName().toLowerCase());
                        MessagesUtils.form(p, "The player §6" + targeto.getName() + "§7 is now trusted");
                    }
                } else {
                    if(Trust.contains(target.getName().toLowerCase())){
                        MessagesUtils.form(p, "§cThe player is already added to the trustlist");
                    } else {
                        Trust.add(target.getName().toLowerCase());
                        MessagesUtils.form(p, "The player §6" + targeto.getName() + "§7 is now trusted");
                    }
                }
            } else if (args[1].equalsIgnoreCase("remove")) {
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[2]);
                if(!target.getName().equalsIgnoreCase(Main.mainuser)) {
                    if (!target.isOnline()) {
                        if (!Trust.contains(target.getName().toLowerCase())) {
                            MessagesUtils.form(p, "§cThe player is not on the trustlist");
                        } else {
                            Trust.remove(target.getName().toLowerCase());
                            MessagesUtils.form(p, "The player §6" + target.getName() + "§7 was removed from the trustlist");
                        }
                    } else {
                        if (!Trust.contains(target.getName().toLowerCase())) {
                            MessagesUtils.form(p, "§cThe player is not on the trustlist");
                        } else {
                            Trust.remove(target.getName().toLowerCase());
                            MessagesUtils.form(p, "The player §6" + target.getName() + "§7 was removed from the trustlist");
                        }
                    }
                } else {
                    MessagesUtils.form(p, "§cYou are not allowed to remove this player from the trustlist");
                }
            } else {
                MessagesUtils.form(p, getHelpMessage());
            }
        });
    }
}
