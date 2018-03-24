package me.auto.utils;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum CustomItem {
	ALICE_GRIMOIRE(1);
	
	private int ID = 0;
	CustomItem(int ID){
		this.ID = ID;
	}
	
	public int getID() { return ID; }
	
	public static boolean exists(ItemStack is) {
		for(CustomItem i : CustomItem.values()) {
			if(i.build().equals(is)) return true;
		}
		return false;
	}
	
	public static boolean exists(int i) {
		for(CustomItem item : CustomItem.values()) {
			if(item.getID() == i) return true;
		}
		return false;
	}
	
	public static CustomItem getCorresponding(ItemStack is) {
		for(CustomItem i : CustomItem.values()) {
			if(i.build().equals(is)) return i;
		}
		return null;
	}
	
	public static CustomItem getItemFromID(int ID) {
		for(CustomItem i : CustomItem.values()) {
			if(i.getID() == ID) return i;
		}
		return null;
	}
	
	public static ItemStack getItemStackFromID(int ID) {
		CustomItem i = getItemFromID(ID);
		return i.build();
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
		if(lore.length > 1) {
			for(int i = 0; i <= lore.length; i++) {
				list.add(lore[i]);
			}
		}else { list.add(s); }
		return list;
	}
}
