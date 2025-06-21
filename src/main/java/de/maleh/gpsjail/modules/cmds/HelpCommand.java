package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import net.md_5.bungee.api.chat.BaseComponent;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends AbstractCommand {

    public HelpCommand() {
        super("help");
    }

    @Override
    public String getHelpMessage() {
        return "help <Site>";
    }

    public String getDescription() {
        return "Help menu";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            int site = 0;
            int sites = (AbstractCommand.getAbstractCommands().size() / 5) + 1;
            MessagesUtils.form(p, "Help: Site (§61§7/§6" + sites + "§7)");
            for (int i = 5 * site; i <= (5 * site) + 4; i++) {
                MessagesUtils.form(p, "§6"+ Main.slash + String.valueOf(AbstractCommand.getAbstractCommands().get(i).getHelpMessage()));
            }
        });
        super.registerParameter(1, (p,args) ->{
            try {
                int site = Integer.parseInt(String.valueOf(args[1])) - 1;
                int sites = (AbstractCommand.getAbstractCommands().size() / 5) + 1;
                if(Integer.parseInt(args[1]) <= sites && Integer.parseInt(args[1]) > 0) {
                    MessagesUtils.form(p, "Help: Site (§6" + args[1] + "§7/§6" + sites + "§7)");
                    for (int i = 5 * site; i <= (5 * site) + 4; i++) {
                        MessagesUtils.form(p, "§6"+Main.slash+String.valueOf(AbstractCommand.getAbstractCommands().get(i).getHelpMessage()));
                    }
                } else {
                    MessagesUtils.form(p, "§cEnter a valid page");
                }
            } catch (IndexOutOfBoundsException e){
            } catch (NumberFormatException e){
                if(args[1].equalsIgnoreCase("all")){
                    for(AbstractCommand command : AbstractCommand.getAbstractCommands()){
                        p.sendMessage("§6" + Main.slash + command.getHelpMessage());
                    }
                    return;
                }
                if(args[1].startsWith(Main.slash)){
                    args[1] = args[1].replace(Main.slash, "");
                }
                AbstractCommand abstractCommand = AbstractCommand.getAbstractCommand(args[1]);
                if(abstractCommand == null){
                    MessagesUtils.form(p, "§cEnter a valid page");
                } else {
                    MessagesUtils.form(p, "Help for §6" + Main.slash + args[1]);
                    MessagesUtils.form(p, "Usage: §6" + Main.slash + abstractCommand.getHelpMessage());
                    MessagesUtils.form(p, "Description: §6" + abstractCommand.getDescription());
                }
            }
        });
    }

}
