package me.auto.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import me.auto.main.Main;

public class MessageUtils {
	
	static Plugin pl = Main.plugin;
	
	public static String getMessage(String s) {
		String str = getConfig().getValue(s);
		return str;
	}
	
	public static void sendMessage(String s) {
		Bukkit.getConsoleSender().sendMessage(s);
	}
	
	public static void cheer(String s) {
		s = ChatColor.GREEN + s;
		sendMessage(getPrefix() + s);
	}
	
	public static void warn(String s) {
		s = ChatColor.YELLOW + s;
		sendMessage(getPrefix() + s);
	}
	
	public static void error(String s) {
		s = ChatColor.RED + s;
		sendMessage(getPrefix() + s);
	}
	
	private static Configuration getConfig() {
		Configuration cfg = new Configuration(pl.getDataFolder().getAbsolutePath(), "messages.yml");
		return cfg;
	}
	
	private static String getPrefix() {
		String s = getConfig().getValue("prefix");
		s = ChatColor.AQUA + s;
		return s;
	}
	
}
