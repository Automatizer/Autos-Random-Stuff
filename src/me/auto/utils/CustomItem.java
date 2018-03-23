package me.auto.utils;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum CustomItem {
	ALICE_GRIMOIRE(1),
	
	private final int ID;
	CustomItem(int ID){
		this.ID = ID;
	}
	
	public int getID() { return ID; }
	
	public static boolean doesItExist(ItemStack is) {
		for(CustomItem i : CustomItem.values()) {
			if(i.build().equals(is)) return true;
			else return false;
		}
	}
	
	public static CustomItem getCorresponding(ItemStack is) {
		for(CustomItem i : CustomItem.values()) {
			if(i.build().equals(is)) return i;
		}
	}
	
	private ItemStack build() {
		switch(getID()) {
		case 1: return buildItem(Material.ENCHANTED_BOOK, "Alice's Grimoire", ChatColor.BLACK, lore("This tome seems to be emanating a lot of magical energy."));
		default: return null;
		}
	}
	
	private static ItemStack buildItem(Material m, String name, ChatColor cc, ArrayList<String> lore) {
		ItemStack is = new ItemStack(m);
		ItemMeta im = is.getItemMeta();
		if(cc == null) cc = ChatColor.WHITE;
		im.setDisplayName(cc + name);
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}
	
	private static ArrayList<String> lore(String s) {
		String[] lore = s.split(";");
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			list.add(lore[i]);
		}
	}
}
