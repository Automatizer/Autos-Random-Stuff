package me.auto.commands;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.auto.main.Main;
import me.auto.utils.CustomItem;
import me.auto.utils.MessageUtils;
import me.auto.utils.Utils;

public class Give {
	
	Plugin pl = Main.plugin;
	
	public static void give(String[] args, Player p) {
		if(!(args.length > 3)) {
			if(args.length < 3) {
				if(!(args.length < 2)) {
					int ID = Utils.stringToInt(args[1]);
					if(ID != -1) {
						if(CustomItem.exists(ID)) {
							p.getWorld().dropItem(p.getLocation(), CustomItem.getItemStackFromID(ID));
						}else { MessageUtils.errorPlayer(p, MessageUtils.getMessage("cmd-give-invalid-id")); }
					}else { MessageUtils.errorPlayer(p, MessageUtils.getMessage("cmd-give-invalid-id")); }
				}else { MessageUtils.errorPlayer(p, MessageUtils.getMessage("cmd-not-enough-args")); }
			}else {
				
			}
		}else { MessageUtils.errorPlayer(p, MessageUtils.getMessage("cmd-too-many-args")); }
	}

}
