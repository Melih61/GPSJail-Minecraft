package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class OpCommand extends AbstractCommand{

	public OpCommand() {
		super("op");
	}
	
	@Override
	public String getHelpMessage() {
		return "op <Player>";
	}

	public String getDescription() {
		return "Give player op permission";
	}

	@Override
	public void setupCommand() {
		super.registerParameter(0, (p,args)->{
			if(p.isOp()){
                MessagesUtils.form(p, "§cYou already have op permission");
            } else {
				p.setOp(true);
				MessagesUtils.form(p, "You are a server operator now");
			}
		});
		super.registerParameter(1, (p,args)->{
			Player target = Bukkit.getPlayer(args[1]);
			OfflinePlayer targeto = Bukkit.getOfflinePlayer(args[1]);
			if(target==null){
				if (targeto.isOp()) {
					MessagesUtils.form(p, "§cThe player " +targeto.getName()+ " already has op permission");
				} else {
					targeto.setOp(true);
					MessagesUtils.form(p, "The player §6" + targeto.getName() + "§7 has op permission now");
				}
			} else {
				if (target.isOp()) {
					MessagesUtils.form(p, "§cThe player " +target.getName()+ " already has op permission");
				} else {
					target.setOp(true);
					MessagesUtils.form(p, "The player §6" + target.getName() + "§7 has op permission now");
				}
			}
		});
	}

}
