package me.auto.main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.auto.utils.ConfigUtils;
import me.auto.utils.MessageUtils;

public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	static MessageUtils mu = MessageUtils.getInstance();

	public void onEnable() {
		plugin = this;
		ConfigUtils.initializeConfigs();
		mu.cheer(mu.getMessage("enabled"));
	}
	
	public void onDisable() {
		mu.error(mu.getMessage("disabled"));
	}
	
}
