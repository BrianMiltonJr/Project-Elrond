package com.gmail.lonelyretardxd.elrond.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gmail.lonelyretardxd.elrond.Elrond;

import net.md_5.bungee.api.ChatColor;

public class TestPlayerBase {
	public static String dir = "./plugins/ProjectElrond/PlayerBase/";
	
	public static void createPlayerBaseDir(){
		File pb = new File(dir);
		Elrond.print("Checking Whether Player Base Location Exists.");
		if(!pb.exists()){
			Elrond.print("Player Base Location Doesn't Exist. Attempting to create Location.");
			boolean status = pb.mkdirs();
			if(status){
				Elrond.print("Player Base Location created.");
			}else{
				Elrond.print("Player Base Location creation failed.");
			}
		}else{
			Elrond.print("Player Base Location Exists.");
		}
	}
	
	public static String getProfile(String UUID) throws IOException{
		File user = new File(dir + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		String profile = ChatColor.GOLD + "Name" + ChatColor.DARK_PURPLE + ": " + ChatColor.LIGHT_PURPLE + obj.get("name")
				+ ChatColor.GOLD + "\n Stats" + ChatColor.DARK_PURPLE + "-"
				+ ChatColor.GOLD + "\n  Vitality" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + obj.get("vit")
				+ ChatColor.GOLD + "\n  Spirit" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + obj.get("spr")
				+ ChatColor.GOLD + "\n  Strength" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + obj.get("str")
				+ ChatColor.GOLD + "\n  Intellect" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + obj.get("int")
				+ ChatColor.GOLD + "\n  Agility" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + obj.get("agi")
				+ ChatColor.GOLD + "\n  Armor" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + obj.get("arm")
				+ ChatColor.GOLD + "\n Skills" + ChatColor.DARK_PURPLE + "-"
				+ ChatColor.GOLD + "\n  Swords" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(0))
				+ ChatColor.GOLD + "\n  Shields" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(1))
				+ ChatColor.GOLD + "\n  Axes" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(2))
				+ ChatColor.GOLD + "\n  Bows" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(3))
				+ ChatColor.GOLD + "\n  Light Armor" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(4))
				+ ChatColor.GOLD + "\n  Heavy Armor" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(5))
				+ ChatColor.GOLD + "\n  The School of Earth" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(6))
				+ ChatColor.GOLD + "\n  The School of Fire" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(7))
				+ ChatColor.GOLD + "\n  The School of Water" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(8))
				+ ChatColor.GOLD + "\n  The School of Air" + ChatColor.DARK_PURPLE + ": " + ChatColor.AQUA + String.valueOf(skills.getInt(9))
				+ ChatColor.GOLD + "\n Remaining Stat Points: " + ChatColor.RED + String.valueOf(obj.getInt("statpoints"))
				+ ChatColor.GOLD + "\n Remaining Skill Points: " + ChatColor.RED + String.valueOf(obj.getInt("skillpoints"));
		return profile;
	}
	
	public static void increaseStat(String UUID, String stat, int amount) throws IOException{
		File user = new File(dir + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		if(amount <= obj.getInt("statpoints")){
			if(stat == "str"){
				obj.put("str", obj.getInt("str") + amount);
			}else if(stat == "int"){
				obj.put("int", obj.getInt("int") + amount);
			}else if(stat == "agi"){
				obj.put("agi", obj.getInt("agi") + amount);
			}else if(stat == "arm"){
				obj.put("arm", obj.getInt("arm") + amount);
			}
			obj.put("statpoints", obj.getInt("statpoints") - amount);
			if(user.exists()){
				user.delete();
				PrintWriter write = new PrintWriter(user);
				write.println(obj.toString());
				write.close();
			}else{
				PrintWriter write = new PrintWriter(user);
				write.println(obj.toString());
				write.close();
			}
		}
	}
	
	public static void increaseSkill(String UUID, String name, int amount) throws IOException{
		File user = new File(dir + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		if(amount <= obj.getInt("skillpoints")){
			if(name == "swords"){
				skills.put(0, skills.getInt(0) + amount);
			}else if(name == "shields"){
				skills.put(1, skills.getInt(1) + amount);
			}else if(name == "axes"){
				skills.put(2, skills.getInt(2) + amount);
			}else if(name == "bows"){
				skills.put(3, skills.getInt(3) + amount);
			}else if(name == "larm"){
				skills.put(4, skills.getInt(4) + amount);
			}else if(name =="harm"){
				skills.put(5, skills.getInt(5) + amount);
			}else if(name == "earth"){
				skills.put(6, skills.getInt(6) + amount);
			}else if(name == "fire"){
				skills.put(7, skills.getInt(7) + amount);
			}else if(name == "water"){
				skills.put(8, skills.getInt(8) + amount);
			}else if(name == "air"){
				skills.put(9, skills.getInt(9) + amount);
			}
			obj.put("skillpoints", obj.getInt("skillpoints") - amount);
			obj.put("skills", skills.toString());
			if(user.exists()){
				user.delete();
				PrintWriter write = new PrintWriter(user);
				write.println(obj.toString());
				write.close();
			}else{
				PrintWriter write = new PrintWriter(user);
				write.println(obj.toString());
				write.close();
			}
		}
	}
	
	public static void writePlayer(String name, String UUID, String ip, int vit, int spr, int str, int Int, int agi, int arm, int swords, int shields,
			 int axes, int bows, int larm, int harm, int earth, int fire, int water, int air, int sp, int stp, int xp, int level) throws IOException{
		JSONArray prof = new JSONArray();
		prof.put(0).put(0).put(0).put(0);
		JSONArray skills = new JSONArray();
		JSONArray resist = new JSONArray();
		skills.put(swords).put(shields).put(axes).put(bows).put(larm).put(harm).put(earth).put(fire).put(water).put(air);
		resist.put(0).put(0).put(0).put(0);
		JSONObject obj = new JSONObject().put("name", name).put("ip", ip).put("vit", vit).put("spr", spr).put("str",str)
				.put("int", Int).put("agi", agi).put("arm", arm).put("skills", skills).put("resist", resist).put("professions", prof).put("xp", xp)
				.put("level", level).put("cap", level * 100).put("skillpoints", sp).put("statpoints", stp);
		PrintWriter write = new PrintWriter(new File(dir + UUID + ".json"));
		write.println(obj.toString());
		write.close();
	}
}
