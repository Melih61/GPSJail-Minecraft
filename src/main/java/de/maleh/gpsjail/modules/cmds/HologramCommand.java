package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import de.maleh.gpsjail.commands.Executor;
import de.maleh.gpsjail.commands.Holograms;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HologramCommand extends AbstractCommand {
    public HologramCommand() {
        super("hologram");
    }

    public String getHelpMessage() {
        return "hologram <create:remove> <Text>";
    }

    public String getDescription() {
        return "Create or remove holograms";
    }

    public void setupCommand() {
        Executor exe = (p, args) -> {
            if (args[1].equalsIgnoreCase("create")) {
                String text = "";
                for (int i = 2; i < args.length; i++)
                    text = String.valueOf(text) + " " + args[i];
                Holograms holo = new Holograms(p.getLocation(), text);
                holo.create();
                MessagesUtils.form(p, "Hologram created");
            }
        };
        for (int i = 2; i < 15; i++)
            registerParameter(i, exe);
        registerParameter(1, (p, args) -> {
            if (args[1].equalsIgnoreCase("remove")) {
                Holograms holo = Holograms.getByLocation(p.getLocation());
                if (holo != null) {
                    holo.remove();
                    MessagesUtils.form(p, "Hologram got removed");
                } else {
                    MessagesUtils.form(p, "§cNo hologram was found");
                }
            }
        });
    }
}

