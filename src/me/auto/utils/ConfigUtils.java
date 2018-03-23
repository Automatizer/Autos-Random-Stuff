package me.auto.utils;

import java.io.File;

import org.bukkit.plugin.Plugin;

import me.auto.main.Main;

public class ConfigUtils {
	
	static Plugin pl = Main.plugin;

	public static void initializeConfigs() {
		
		try {
			if(!pl.getDataFolder().exists()) {
				pl.getDataFolder().mkdirs();
			}
			File file = new File(pl.getDataFolder(), "config.yml");
			if(!file.exists()) {
				MessageUtils.error("Config.yml not found, creating...");
				generateDefaultConfig();
				File messages = new File(pl.getDataFolder(), "messages.yml");
				if(!messages.exists()) {
					MessageUtils.error("Messages.yml not found, creating...");
					generateDefaultMessages();
				}
			}else {
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void regenConfigs() {
		generateDefaultConfig();
		generateDefaultMessages();
	}
	
	public static Configuration getConfig() {
		Configuration cfg = new Configuration(pl.getDataFolder().getAbsolutePath(), "config.yml");
		return cfg;
	}
	
	private static void generateDefaultConfig() {
		Configuration cfg = getConfig();
		cfg.convertAndWriteValue("regen-configs", false);
	}
	
	private static void generateDefaultMessages() {
		Configuration cfg = new Configuration(pl.getDataFolder().getAbsolutePath(), "messages.yml");
		cfg.convertAndWriteValue("prefix", "[Auto's Random Stuff] : ");
		cfg.convertAndWriteValue("enabled", "Plugin successfully enabled.");
		cfg.convertAndWriteValue("disabled", "Plugin successfully disabled.");
	}
	
}
