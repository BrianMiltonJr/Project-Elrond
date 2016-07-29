package com.gmail.lonelyretardxd.elrond.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;

import com.gmail.lonelyretardxd.elrond.Elrond;
//DEPRECATED CLASS PRE ALPHA BUILD
//PLEASE REFER TO TESTPLAYERBASE
public class PlayerBase{

	public static String dirPb = "./plugins/ProjectElrond/PlayerBase/";
	public static String dirL = "./plugins/ProjectElrond/PlayerBase/Levels/";
	
	public static void createLevelDir(){
		File pb = new File(dirL);
		Elrond.print("Checking Whether Level dir Location Exists.");
		if(!pb.exists()){
			Elrond.print("level dir Location Doesn't Exist. Attempting to create Location.");
			boolean status = pb.mkdirs();
			if(status){
				Elrond.print("Level dir Location created.");
			}else{
				Elrond.print("Level dir Location creation failed.");
			}
		}else{
			Elrond.print("Level dir Location Exists.");
		}
	}
	
	public static boolean exists(String name){
		File user = new File(dirPb + name + ".json");
		if(user.exists()){
			return true;
		}else{
			return false;
		}
	}
	
	public static String getPlayerName(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		String name = obj.getString("name");
		return name;
	}
	
	public static int getIp(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int ip = obj.getInt("ip");
		return ip;
	}
	
	public static int getStr(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int str = obj.getInt("str");
		return str;
	}
	
	public static int getInt(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int Int = obj.getInt("int");
		return Int;
	}
	
	public static int getAgi(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int agi = obj.getInt("agi");
		return agi;
	}
	
	public static int getarm(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int arm = obj.getInt("arm");
		return arm;
	}
	
	public static int getSkill(String UUID, String skill){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		JSONArray arr = new JSONArray(obj.getJSONArray("skills"));
		if(skill == "swords"){
			int skills = arr.getInt(0);
			return skills;
		}else if(skill == "shields"){
			int skills = arr.getInt(1);
			return skills;
		}else if(skill == "axes"){
			int skills = arr.getInt(2);
			return skills;
		}else if(skill == "bows"){
			int skills = arr.getInt(3);
			return skills;
		}else if(skill == "larm"){
			int skills = arr.getInt(4);
			return skills;
		}else if(skill == "harm"){
			int skills = arr.getInt(5);
			return skills;
		}else if(skill == "earth"){
			int skills = arr.getInt(6);
			return skills;
		}else if(skill == "water"){
			int skills = arr.getInt(7);
			return skills;
		}else if(skill == "fire"){
			int skills = arr.getInt(8);
			return skills;
		}else if(skill == "air"){
			int skills = arr.getInt(9);
			return skills;
		}else{
			return 0;
		}
	}
	
	public static int getProfession(String UUID, String prof){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		JSONArray arr = new JSONArray(obj.getJSONArray("skills"));
		if(prof == "blacksmith"){
			int skills = arr.getInt(0);
			return skills;
		}else if(prof == "enchanter"){
			int skills = arr.getInt(1);
			return skills;
		}else if(prof == "gem"){
			int skills = arr.getInt(2);
			return skills;
		}else if(prof == "leather"){
			int skills = arr.getInt(3);
			return skills;
		}else{
			return 0;
		}
	}
	public static int getSkillPoints(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int sp = obj.getInt("skillpoints");
		return sp;
	}
	
	public static int getStatPoints(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int stp = obj.getInt("statpoints");
		return stp;
	}
	
	public static void levelUp(String UUID){
		File user = new File(dirPb + UUID + ".json");
		JSONObject obj = new JSONObject(user);
		int sp = obj.getInt("skillpoints");
		int newSp = sp + 5;
		int stp = obj.getInt("statpoints");
		int newStp = stp + 5;
		try{
			user.delete();
			PrintWriter write = new PrintWriter(user);
			JSONWriter writer = new JSONWriter(write);
			writer.object();
			writer.key("name");
			writer.value(obj.get("name"));
			writer.key("ip");
			writer.value(obj.get("ip"));
			writer.key("str");
			writer.value(obj.get("str"));
			writer.key("int");
			writer.value(obj.getInt("int"));
			writer.key("agi");
			writer.value(obj.getInt("agi"));
			writer.key("arm");
			writer.value(obj.getInt("arm"));
			writer.key("skills");
			writer.array();
			writer.key("swords");
			writer.value(obj.getInt("swords"));
			writer.key("shields");
			writer.value(obj.getInt("shields"));
			writer.key("axes");
			writer.value(obj.getInt("axes"));
			writer.key("bows");
			writer.value(obj.getInt("bows"));
			writer.key("larm");
			writer.value(obj.getInt("larm"));
			writer.key("harm");
			writer.value(obj.getInt("harm"));
			writer.key("earth");
			writer.value(obj.getInt("earth"));
			writer.key("water");
			writer.value(obj.getInt("water"));
			writer.key("fire");
			writer.value(obj.getInt("fire"));
			writer.key("air");
			writer.value(obj.getInt("air"));
			writer.endArray();
			writer.key("professions");
			writer.array();
			writer.key("blacksmith");
			writer.value(obj.getInt("blacksmith"));
			writer.key("enchanter");
			writer.value(obj.getInt("enchanter"));
			writer.key("gem");
			writer.value(obj.getInt("gem"));
			writer.key("leather");
			writer.value(obj.getInt("leather"));
			writer.endArray();
			writer.key("statpoints");
			writer.value(newStp);
			writer.key("skillpoints");
			writer.value(newSp);
			writer.endObject();
			write.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void increaseStr(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int str = obj.getInt("str");
		int stp = obj.getInt("statpoints");
		if (amount <= obj.getInt("statpoints")){
		int newStr = str + amount;
		int newSp = stp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(newStr);
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(newSp);
				writer.key("skillpoints");
				writer.value(obj.getInt("skillpoints"));
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Stat points. You only have " + obj.getInt("statpoints") + " skill points.");
		}
	}
	
	public static void increaseInt(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int Int = obj.getInt("int");
		int stp = obj.getInt("statpoints");
		if (amount <= obj.getInt("statpoints")){
		int newInt = Int + amount;
		int newSp = stp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(newInt);
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(newSp);
				writer.key("skillpoints");
				writer.value(obj.getInt("skillpoints"));
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Stat points. You only have " + obj.getInt("statpoints") + " skill points.");
		}
	}
	
	public static void increaseAgi(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int agi = obj.getInt("agi");
		int stp = obj.getInt("statpoints");
		if (amount <= obj.getInt("statpoints")){
		int newAgi = agi + amount;
		int newSp = stp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(newAgi);
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(newSp);
				writer.key("skillpoints");
				writer.value(obj.getInt("skillpoints"));
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Stat points. You only have " + obj.getInt("statpoints") + " skill points.");
		}
	}
	
	public static void increaseArm(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int arm = obj.getInt("arm");
		int stp = obj.getInt("statpoints");
		if (amount <= obj.getInt("statpoints")){
		int newArm = arm + amount;
		int newSp = stp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(newArm);
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(newSp);
				writer.key("skillpoints");
				writer.value(obj.getInt("skillpoints"));
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Stat points. You only have " + obj.getInt("statpoints") + " skill points.");
		}
	}
	
	public static void increaseSwords(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int swords = (int) skills.get(0);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newSwords = swords + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(newSwords);
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseShields(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int shields = (int) skills.get(1);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newShields = shields + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(newShields);
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseAxes(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int axes = (int) skills.get(2);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newAxes = axes + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(newAxes);
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseBows(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int bows = (int) skills.get(3);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newBows = bows + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(newBows);
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseLarm(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int larm = (int) skills.get(4);
		int sp = obj.getInt("skillpoints");
		
		if (amount <= obj.getInt("skillpoints")){
		int newLarm = larm + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(newLarm);
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseHarm(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int harm = (int) skills.get(5);
		int sp = obj.getInt("skillpoints");
		
		if (amount <= obj.getInt("skillpoints")){
		int newHarm = harm + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(newHarm);
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseEarth(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int earth = (int) skills.get(6);
		int sp = obj.getInt("skillpoints");
		
		if (amount <= obj.getInt("skillpoints")){
		int newEarth = earth + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(newEarth);
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseFire(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int fire = (int) skills.get(7);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newFire = fire + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(newFire);
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseWater(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int water = (int) skills.get(8);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newWater = water + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(newWater);
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseAir(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int air = (int) skills.get(9);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newAir = air + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(newAir);
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseBlackSmith(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int bs = (int) prof.get(0);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newBs = bs + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(newBs);
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseEnchanter(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int en = (int) prof.get(1);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newEn = en + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(newEn);
				writer.value(prof.get(2));
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseGem(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int gem = (int) prof.get(2);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newGem = gem + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(newGem);
				writer.value(prof.get(3));
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void increaseLeather(String UUID, int amount, UUID id) throws IOException{
		File user = new File(dirPb + UUID + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		br.close();
		fr.close();
		JSONObject obj = new JSONObject(json);
		JSONArray skills = new JSONArray(obj.get("skills").toString());
		JSONArray prof = new JSONArray(obj.get("professions").toString());
		int leather = (int) prof.get(3);
		int sp = obj.getInt("skillpoints");
		if (amount <= obj.getInt("skillpoints")){
		int newLeather = leather + amount;
		int newSp = sp - amount;
			try{
				user.delete();
				PrintWriter write = new PrintWriter(user);
				JSONWriter writer = new JSONWriter(write);
				writer.object();
				writer.key("name");
				writer.value(obj.get("name"));
				writer.key("ip");
				writer.value(obj.get("ip"));
				writer.key("str");
				writer.value(obj.getInt("str"));
				writer.key("int");
				writer.value(obj.getInt("int"));
				writer.key("agi");
				writer.value(obj.getInt("agi"));
				writer.key("arm");
				writer.value(obj.getInt("arm"));
				writer.key("skills");
				writer.array();
				writer.value(skills.get(0));
				writer.value(skills.get(1));
				writer.value(skills.get(2));
				writer.value(skills.get(3));
				writer.value(skills.get(4));
				writer.value(skills.get(5));
				writer.value(skills.get(6));
				writer.value(skills.get(7));
				writer.value(skills.get(8));
				writer.value(skills.get(9));
				writer.endArray();
				writer.key("professions");
				writer.array();
				writer.value(prof.get(0));
				writer.value(prof.get(1));
				writer.value(prof.get(2));
				writer.value(newLeather);
				writer.endArray();
				writer.key("statpoints");
				writer.value(obj.getInt("statpoints"));
				writer.key("skillpoints");
				writer.value(newSp);
				writer.endObject();
				write.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			Bukkit.getPlayer(id).sendMessage("You do not have " + String.valueOf(amount) + " Skill points. You only have " + obj.getInt("skillpoints") + " skill points.");
		}
	}
	
	public static void writePlayerFile(String name, String UUID, String ip, int str, int Int, int agi, int arm, int swords, int shields, int axes, int bows, int larm, int harm, int earth, int fire, int water, int air, int stp, int sp) throws FileNotFoundException {
		PrintWriter write = new PrintWriter(dirPb + UUID + ".json");
		JSONWriter writer = new JSONWriter(write);
		if(new File(dirPb + UUID + ".json").exists()){
			new File(dirPb + UUID + ".json").delete();
			writer.object();
			writer.key("name");
			writer.value(name);
			writer.key("ip");
			writer.value(ip);
			writer.key("str");
			writer.value(str);
			writer.key("int");
			writer.value(Int);
			writer.key("agi");
			writer.value(agi);
			writer.key("arm");
			writer.value(arm);
			writer.key("skills");
			writer.array();
			writer.value(swords);
			writer.value(shields);
			writer.value(axes);
			writer.value(bows);
			writer.value(larm);
			writer.value(harm);
			writer.value(earth);
			writer.value(water);
			writer.value(fire);
			writer.value(air);
			writer.endArray();
			writer.key("professions");
			writer.array();
			writer.value(0);
			writer.value(0);
			writer.value(0);
			writer.value(0);
			writer.endArray();
			writer.key("statpoints");
			writer.value(stp);
			writer.key("skillpoints");
			writer.value(sp);
			writer.endObject();
			write.close();
		}else{
			writer.object();
			writer.key("name");
			writer.value(name);
			writer.key("ip");
			writer.value(ip);
			writer.key("str");
			writer.value(str);
			writer.key("int");
			writer.value(Int);
			writer.key("agi");
			writer.value(agi);
			writer.key("arm");
			writer.value(arm);
			writer.key("skills");
			writer.array();
			writer.value(swords);
			writer.value(shields);
			writer.value(axes);
			writer.value(bows);
			writer.value(larm);
			writer.value(harm);
			writer.value(earth);
			writer.value(water);
			writer.value(fire);
			writer.value(air);
			writer.endArray();
			writer.key("professions");
			writer.array();
			writer.value(0);
			writer.value(0);
			writer.value(0);
			writer.value(0);
			writer.endArray();
			writer.key("statpoints");
			writer.value(stp);
			writer.key("skillpoints");
			writer.value(sp);
			writer.endObject();
			write.close();
		}
	}
	
	public static void createEntry(String Name, String UUID, String ip, int str, int Int, int agi, int arm, int swords, int shields, int axes, int bows, int larm, int harm, int earth, int fire, int water, int air, int stp, int sp){
		File entry = new File(dirPb + UUID + ".json");
		if(entry.exists()){
			
		}else{
			try {
				writePlayerFile(Name, UUID, ip, str, Int, agi, arm, swords, shields, axes, bows, larm, harm, earth, fire, water, air, stp, sp);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}