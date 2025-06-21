package de.maleh.gpsjail.modules.cmds;

import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;

public class ChatClearCommand extends AbstractCommand{

	public ChatClearCommand() {
		super("chatclear","cc","clearchat");
	}
	
	@Override
	public String getHelpMessage() {
		return "chatclear";
	}

	public String getDescription() {
		return "Clear the chat for you";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(0, (p,args)->{
			for(int i = 0; i < 1000; i++) {
				p.sendMessage("§3");
			}
		});
	}

}
