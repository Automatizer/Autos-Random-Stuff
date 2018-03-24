package me.auto.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.auto.listeners.InteractListener;
import me.auto.utils.ConfigUtils;
import me.auto.utils.MessageUtils;

public class Main extends JavaPlugin{
	
	public static Plugin plugin;

	public void onEnable() {
		plugin = this;
		ConfigUtils.initializeConfigs();
		if(ConfigUtils.getConfig().getBoolean("regen-configs") == true) {
			ConfigUtils.regenConfigs();
		}
		new InteractListener(this);
		MessageUtils.cheer(MessageUtils.getMessage("enabled"));
	}
	
	public void onDisable() {
		MessageUtils.error(MessageUtils.getMessage("disabled"));
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		return false;
	}
	
}
