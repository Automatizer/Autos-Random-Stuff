package me.auto.utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class ConfigUtils {
	
	static Plugin pl;

	public static void initializeConfigs() {
		
		try {
			if(!pl.getDataFolder().exists()) {
				pl.getDataFolder().mkdirs();
			}
			File file = new File(pl.getDataFolder(), "config.yml");
			if(!file.exists()) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "config.yml not found, creating.");
				generateDefaultConfig();
				File messages = new File(pl.getDataFolder(), "messages.yml");
				if(!messages.exists()) {
					generateDefaultMessages();
				}
			}else {
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void generateDefaultConfig() {
		Configuration cfg = new Configuration(pl.getDataFolder().getAbsolutePath(), "config.yml");
		
	}
	
	private static void generateDefaultMessages() {
		Configuration cfg = new Configuration(pl.getDataFolder().getAbsolutePath(), "messages.yml");
		cfg.convertAndWriteValue("prefix", "[Auto's Random Stuff]");
		cfg.convertAndWriteValue("enabled", "Plugin successfully enabled.");
		cfg.convertAndWriteValue("disabled", "Plugin successfully disabled.");
	}
	
}
