package me.auto.abilities;

import org.bukkit.entity.Player;

import me.auto.utils.CustomItem;

public class AbilityManager {

	public void parse(CustomItem item, Player p) {
		int i = item.getID();
		switch(i) {
		case 1: PuppetShow.execute(p); break;
		default: break;
		}
	}
	
}
