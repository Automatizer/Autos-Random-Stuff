package me.auto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.auto.utils.MessageUtils;

public class ARS implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("ars")) {
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("give")) {
					if(sender instanceof Player) {
						Give.give(args, (Player) sender);
					}else { MessageUtils.error(MessageUtils.getMessage("cmd-console-cannot-do-this")); }
				}
			}else { 
				if(sender instanceof Player) MessageUtils.errorPlayer((Player) sender, MessageUtils.getMessage("cmd-not-enough-args"));
				else MessageUtils.error(MessageUtils.getMessage("cmd-not-enough-args"));
			}
		}
		
		return true;
	}
	
}
