package me.auto.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.auto.main.Main;

public class MessageUtils {
	
	static Plugin pl = Main.plugin;
	
	public static String getMessage(String s) {
		String str = getConfig().getValue(s);
		return str;
	}
	
	public static void message(String s) {
		Bukkit.getConsoleSender().sendMessage(s);
	}
	
	public static void cheer(String s) {
		s = ChatColor.GREEN + s;
		message(getPrefix() + s);
	}
	
	public static void warn(String s) {
		s = ChatColor.YELLOW + s;
		message(getPrefix() + s);
	}
	
	public static void error(String s) {
		s = ChatColor.RED + s;
		message(getPrefix() + s);
	}
	
	public static void messagePlayer(Player p, String s) {
		p.sendMessage(s);
	}
	
	public static void cheerPlayer(Player p, String s) {
		s = ChatColor.GREEN + s;
		messagePlayer(p, getPrefix() + s);
	}
	
	public static void warnPlayer(Player p, String s) {
		s = ChatColor.YELLOW + s;
		messagePlayer(p, getPrefix() + s);
	}
	
	public static void errorPlayer(Player p, String s) {
		s = ChatColor.RED + s;
		messagePlayer(p, getPrefix() + s);
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
