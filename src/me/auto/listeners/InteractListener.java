package me.auto.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.auto.abilities.AbilityManager;
import me.auto.utils.CustomItem;

public class InteractListener implements Listener{

	Plugin pl;
	
	public InteractListener(Plugin plugin){
		this.pl = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack is = p.getItemOnCursor();
		if(is != null) {
			if(CustomItem.doesItExist(is)) {
				CustomItem i = CustomItem.getCorresponding(is);
				AbilityManager.parse(i, p);
			}
		}
	}
	
	
}
