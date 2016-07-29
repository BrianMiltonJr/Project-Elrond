package com.gmail.lonelyretardxd.elrond.items;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElrondItem{
	
	public static String dir = "./plugins/ProjectElrond/items/";
	//createItem takes a Material and Quantity with the Name of the Item and the Location for the Lore
	public static ItemStack createItem(Material material, int quantity, String name, String iName){
		ItemStack item = new ItemStack(material, quantity);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		try {	
			meta.setLore(getLore(iName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		item.setItemMeta(meta);
		return item;
	}
	
	//Returns a List with the Lore inside it
	@SuppressWarnings("rawtypes")
	public static List<String> getLore(String name) throws IOException{
		File meta = new File(dir + name + ".json");
		FileReader fr = new FileReader(meta);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray lore = new JSONArray(obj.get("lore").toString());
		List<Object> Lore = lore.toList();
		Iterator iterator = Lore.iterator();
		List<String> Lores = new ArrayList<String>();
		while(iterator.hasNext()){
			Lores.add(iterator.next().toString());
		}
		return Lores;
	}
	
}
