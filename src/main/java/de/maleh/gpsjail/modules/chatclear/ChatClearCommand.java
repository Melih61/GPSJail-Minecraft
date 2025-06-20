package de.maleh.gpsjail.modules.chatclear;

import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;

public class ChatClearCommand extends AbstractCommand{

	public ChatClearCommand() {
		super("chatclear","cc");
	}
	
	@Override
	public String getHelpMessage() {
		return "chatclear";
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
