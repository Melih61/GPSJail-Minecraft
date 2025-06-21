package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class SeedCommand extends AbstractCommand {

    public SeedCommand() {
        super("seed");
    }

    @Override
    public String getHelpMessage() {
        return "seed";
    }

    public String getDescription() {
        return "See the current world seed";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            long seed = p.getWorld().getSeed();
            TextComponent component = new TextComponent("§8[§6GPS§eJail§b5§8]" + " §7The seed of your current world is: §6" + String.valueOf(seed));
            ClickEvent clickEvent = new ClickEvent(Action.COPY_TO_CLIPBOARD, String.valueOf(seed));
            HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Coyp seed to clipboard"));
            component.setClickEvent(clickEvent);
            component.setHoverEvent(hoverEvent);
            p.spigot().sendMessage(component);
        });
    }

}

