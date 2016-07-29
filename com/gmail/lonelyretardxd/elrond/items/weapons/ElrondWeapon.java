package com.gmail.lonelyretardxd.elrond.items.weapons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.json.JSONArray;
import org.json.JSONObject;

import com.gmail.lonelyretardxd.elrond.items.ElrondItem;

public class ElrondWeapon{

	public static String dir = ElrondItem.dir + "weapons/";
	public static String[] trainingSword = {ChatColor.GRAY + "Training Sword", "training_sword"};
	public static String[] trainingAxe = {ChatColor.GRAY + "Training Axe", "training_axe"};
	public static String[] trainingBow = {ChatColor.GRAY + "Training Bow", "training_bow"};
	
	public static String getName(String name)throws IOException{
		FileReader fr = new FileReader(new File(ElrondItem.dir + name + ".json"));
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		return obj.getString("name");
	}
	
	@SuppressWarnings("rawtypes")
	public static List<String> getLore(String name)throws IOException{
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
	
	public static int getDmg(String[] name)throws IOException{
		FileReader fr = new FileReader(new File(dir + name[1] + ".json"));
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		return obj.getInt("dmg");
	}
	
	public static int getStr(String[] name)throws IOException{
		FileReader fr = new FileReader(new File(dir + name[1] + ".json"));
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		return obj.getInt("str");
	}
	
	public static int getInt(String[] name)throws IOException{
		FileReader fr = new FileReader(new File(dir + name[1] + ".json"));
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		return obj.getInt("int");
	}
	
	public static int getAgi(String[] name)throws IOException{
		FileReader fr = new FileReader(new File(dir + name[1] + ".json"));
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		return obj.getInt("agi");
	}
	
	public static int getArm(String[] name)throws IOException{
		FileReader fr = new FileReader(new File(dir + name[1] + ".json"));
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		return obj.getInt("arm");
	}
}
