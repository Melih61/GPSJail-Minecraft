package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.entity.Player;

public class OpCommand extends AbstractCommand{

	public OpCommand() {
		super("op");
	}
	
	@Override
	public String getHelpMessage() {
		return "op (Spieler)";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(0, (p,args)->{
			if(p.isOp()){
                MessagesUtils.form(p, "Du hast bereits OP Rechte");
            } else {
				p.setOp(true);
				MessagesUtils.form(p, "Du hast nun OP Rechte");
			}
		});
		super.registerParameter(1, (p,args)->{
			Player target = Bukkit.getPlayer(args[1]);
			if(target==null){
				MessagesUtils.form(p, "§cDer Spieler " + args[1] + " ist nicht online");
			} else {
				if (target.isOp()) {
					MessagesUtils.form(p, "Der Spieler " +target.getName()+ " hat bereits OP Rechte");
				} else {
					target.setOp(true);
					MessagesUtils.form(p, "Der Spieler " + target.getName()+ " hat nun OP Rechte");
				}
			}
		});
	}

}
