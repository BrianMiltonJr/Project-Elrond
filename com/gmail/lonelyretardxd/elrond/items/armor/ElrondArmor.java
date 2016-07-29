package com.gmail.lonelyretardxd.elrond.items.armor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gmail.lonelyretardxd.elrond.items.ElrondItem;

import net.md_5.bungee.api.ChatColor;

public class ElrondArmor {

	public static String dir = ElrondItem.dir + "armor/";
	
	public static String[] training_shield = {"training_shield", ChatColor.GRAY + "Training Shield"};
	public static String[] civilian_chest = {"civilian_chest", ChatColor.GRAY + "Civilian Chest"};
	public static String[] civilian_legs = {"civilian_legs", ChatColor.GRAY + "Civilian Leggings"};
	public static String[] civilian_boots = {"civilian_bootsS", ChatColor.GRAY + "Civilian Boots"};
	
	/*
	 * The Marble Halls Tier 0 Sets
	 * Blue Quality
	 * */
	public static String[][] novice_set = {{"novice_helmet", ChatColor.BLUE + "Helmet of the Novice"}, {"novice_chest", ChatColor.BLUE + "Chestplate of the Novice"}, 
										   {"novice_pants", ChatColor.BLUE + "Pants of the Novice"}, {"novice_boots", ChatColor.BLUE + "Boots of the Novice"}};
	public static String[][] hunter_set = {{"hunter_helmet", ChatColor.BLUE + "Helmet of the Hunter"}, {"hunter_chest", ChatColor.BLUE + "Chestplate of the Hunter"}, 
										  {"hunter_pants", ChatColor.BLUE + "Pants of the Hunter"}, {"hunter_boots", ChatColor.BLUE + "Boots of the Hunter"}};
	public static String[][] barbarian_set = {{"barbarian_helmet", ChatColor.BLUE + "Helmet of the Barbarian"}, {"barbarian_chest", ChatColor.BLUE + "Chestplate of the Barbarian"}, 
											 {"barbarian_pants", ChatColor.BLUE + "Pants of the Barbarian"}, {"barbarian_boots", ChatColor.BLUE + "Boots of the Barbarian"}};
	
	public static String getName(String[][] name)throws IOException{
		FileReader fr = new FileReader(new File(ElrondItem.dir + name[1] + ".json"));
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		return obj.getString("name");
	}
	
	@SuppressWarnings("rawtypes")
	public static List<String> getLore(String[][] name)throws IOException{
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
	
	public static int getArm(String[][] set)throws IOException{
		File arm = new File(dir + set + ".json");
		FileReader fr = new FileReader(arm);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		int result = obj.getInt("arm");
		return result;
	}
	
	public static int getStr(String[][] set)throws IOException{
		File arm = new File(dir + set + ".json");
		FileReader fr = new FileReader(arm);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		int result = obj.getInt("str");
		return result;
	}
	
	public static int getInt(String[][] set)throws IOException{
		File arm = new File(dir + set + ".json");
		FileReader fr = new FileReader(arm);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		int result = obj.getInt("int");
		return result;
	}
	
	public static int getAgi(String[][] set)throws IOException{
		File arm = new File(dir + set + ".json");
		FileReader fr = new FileReader(arm);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		int result = obj.getInt("agi");
		return result;
	}
	
	public static int[] getResists(String[][] set)throws IOException{
		File arm = new File(dir + set + ".json");
		FileReader fr = new FileReader(arm);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray resists = new JSONArray(obj.getJSONArray("resists"));
		int[] result = {resists.getInt(0), resists.getInt(1), resists.getInt(2), resists.getInt(3)};
		return result;
	}
}