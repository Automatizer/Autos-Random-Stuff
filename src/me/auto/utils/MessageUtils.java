package me.auto.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class MessageUtils {
	
	private static MessageUtils instance = new MessageUtils();
	public static MessageUtils getInstance() { return instance;}
	
	static Plugin pl;
	static Configuration cfg = new Configuration(pl.getDataFolder().getAbsolutePath(), "messages.yml");
	
	public String getMessage(String s) {
		String str = getPrefix() + cfg.getValue(s);
		return str;
	}
	
	public void sendMessage(String s) {
		Bukkit.getConsoleSender().sendMessage(s);
	}
	
	public void cheer(String s) {
		if(s.contains(getPrefix())) s.replace(getPrefix(), "");
		s = ChatColor.GREEN + s;
		Bukkit.getConsoleSender().sendMessage(getPrefix() + " " + s);
	}
	
	public void warn(String s) {
		if(s.contains(getPrefix())) s.replace(getPrefix(), "");
		s = ChatColor.YELLOW + s;
		Bukkit.getConsoleSender().sendMessage(getPrefix() + " " + s);
	}
	
	public void error(String s) {
		if(s.contains(getPrefix())) s.replace(getPrefix(), "");
		s = ChatColor.RED + s;
		Bukkit.getConsoleSender().sendMessage(getPrefix() + " " + s);
	}

	private static String getPrefix() {
		String s = cfg.getValue("prefix");
		return s;
	}
	
}