package com.gmail.lonelyretardxd.elrond.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;

import com.gmail.lonelyretardxd.elrond.items.ElrondItem;

public class Toon{
	
	private Player player;
	private String name;
	private int stp;
	private int sp;
	private int vit;
	private int spr;
	private int str;
	private int Int;
	private int agi;
	private int arm;
	private int swords;
	private int shields;
	private int axes;
	private int bows;
	private int larm;
	private int harm;
	private int earth;
	private int fire;
	private int water;
	private int air;
	private int level;
	private int xp;
	private int earthR;
	private int fireR;
	private int waterR;
	private int airR;
	
	public Toon(Player Player){
		this.player = Player;
		try {
			loadStats();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void giveQuest(int id, int xpAmount, JSONArray loot) throws IOException{
		File questLog = new File(PlayerBase.dirPb + "/quests/" + player.getUniqueId() + ".json");
		if(!questLog.exists()){
			JSONArray quests = new JSONArray();
			JSONArray quest = new JSONArray();
			quest.put(0, id);
			quest.put(1, xpAmount);
			quest.put(2, loot);
			quests.put(0, quest);
			PrintWriter write = new PrintWriter(questLog);
			JSONWriter writer = new JSONWriter(write);
			writer.object();
			writer.key("quests");
			writer.value(quests);			
			writer.endObject();
			write.close();
		}else{
			FileReader fr = new FileReader(questLog);
			BufferedReader br = new BufferedReader(fr);
			String json = br.readLine();
			br.close();
			fr.close();
			JSONObject obj = new JSONObject(json);
			JSONArray quests = new JSONArray(obj.getJSONArray("quests"));
			JSONArray quest = new JSONArray();
			quest.put(0, id);
			quest.put(1, xpAmount);
			quest.put(2, loot);
			int latestIndex = quests.length();
			quests.put(latestIndex ++, quest);
			obj.append("quests", quests);
			PrintWriter writer = new PrintWriter(questLog);
			writer.println(obj.toString());
			writer.close();
		}
	}
	
	public void completeQuest(int id) throws IOException{
		File questLog = new File(PlayerBase.dirPb + "/quests/" + player.getUniqueId() + ".json");
		FileReader fr = new FileReader(questLog);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		fr.close();
		br.close();
		//Create new QuestLog
		JSONObject obj = new JSONObject(json);
		//Create new Quests Array
		JSONArray quests = new JSONArray(obj.getJSONArray("quests"));
		//Create Quest
		JSONArray quest = new JSONArray(quests.get(loopQuests(quests, id)));
		//Create Loot List
		JSONArray loot = new JSONArray(quest.get(2));
		//Complete the Quest
		Bukkit.getServer().getPlayer(player.getUniqueId()).getInventory().addItem(arg0);
		int start = 0;
		int indexSize = loot.length();
		String[] derp = loot.w
		//Cycle loot grabbing the different loot items and giving them to the player
		while(start <= indexSize){
			JSONArray item = loot.getJSONArray(start);
			ItemStack Item = ElrondItem.createItem(Material.IRON_SWORD, item.getInt(1), item.getString(2), iName)
			Bukkit.getServer().getPlayer(player.getUniqueId()).getInventory().addItem(new ItemStack())
		}
	}
	
	public int loopQuests(JSONArray quests, int id){
		int size = quests.length();
		int start = 0;
		while(start <= size){
			JSONArray quest = new JSONArray(quests.get(start));
			if(quest.getInt(0) == id){
				return start;
			}else{
				continue;
			}
		}
		return 0;
	}
	
	public void increaseXp(int amount) throws IOException{
		File user = new File(PlayerBase.dirPb + this.player.getUniqueId().toString() + ".json");
		FileReader fr = new FileReader(user);
		BufferedReader br = new BufferedReader(fr);
		String json = br.readLine();
		fr.close();
		br.close();
		JSONObject obj = new JSONObject(json);
		obj.append("xp", obj.getInt("xp") + amount);
		if(obj.getInt("xp") >= obj.getInt("cap")){
			levelUp();
		}
	}
	
	public void levelUp() throws IOException{
		int level = this.level ++;
		File user = new File(PlayerBase.dirPb + this.player.getUniqueId().toString() + ".json");
		if(user.exists()){
			FileReader fr = new FileReader(user);
			BufferedReader br = new BufferedReader(fr);
			fr.close();
			br.close();
			String json = br.readLine();
			JSONObject obj = new JSONObject(json);
			obj.append("level", level);
			obj.append("cap", level * 100);
			obj.append("skillpoints", obj.getInt("skillpoints") + 3);
			obj.append("statpoints", obj.getInt("statpoints") + 3);
			PrintWriter writer = new PrintWriter(user);
			writer.println(obj.toString());
			writer.close();
			Bukkit.getServer().getPlayer(player.getUniqueId()).sendMessage("Congrats your Level is now " + String.valueOf(level) + "!");
			Bukkit.getServer().getPlayer(player.getUniqueId()).sendMessage("You have been given 3 Stat Points and 3 Skill Points.");
		}
		
	}
	public void loadStats() throws IOException{
		File user = new File(PlayerBase.dirPb + this.player.getUniqueId().toString() + ".json");
		if(user.exists()){
			FileReader fr = new FileReader(user);
			BufferedReader br = new BufferedReader(fr);
			String json = br.readLine();
			br.close();
			fr.close();
			JSONObject obj = new JSONObject(json);
			JSONArray skills = new JSONArray(obj.get("skills").toString());
			JSONArray resist = new JSONArray(obj.get("resist").toString());
			this.name = obj.getString("name");
			this.vit = obj.getInt("vit");
			this.spr = obj.getInt("spr");
			this.str = obj.getInt("str");
			this.Int = obj.getInt("int");
			this.agi = obj.getInt("agi");
			this.arm = obj.getInt("arm");
			this.swords = skills.getInt(0);
			this.shields = skills.getInt(1);
			this.axes = skills.getInt(2);
			this.bows = skills.getInt(3);
			this.larm = skills.getInt(4);
			this.harm = skills.getInt(5);
			this.earth = skills.getInt(6);
			this.fire = skills.getInt(7);
			this.water = skills.getInt(8);
			this.air = skills.getInt(9);
			this.stp = obj.getInt("statpoints");
			this.sp = obj.getInt("skillpoints");
			this.earthR = resist.getInt(0);
			this.fireR = resist.getInt(1);
			this.waterR = resist.getInt(2);
			this.airR = resist.getInt(3);
		}
	}
	
	public void assignName(){
		if(this.name == this.player.getDisplayName()){
			this.player.setDisplayName(this.name);
			this.player.setPlayerListName(this.name);
		}else{
			
		}
	}
	
	public int getStp(){
		return this.stp;
	}
	
	public int getSp(){
		return this.sp;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getVit(){
		return this.vit;
	}
	
	public int getSpr(){
		return this.spr;
	}
	
	public int getStr(){
		return this.str;
	}
	
	public int getInt(){
		return this.Int;
	}
	
	public int getAgi(){
		return this.agi;
	}
	public int getArm(){
		return this.arm;
	}
	
	public int getSwords(){
		return this.swords;
	}
	
	public int getShields(){
		return this.shields;
	}
	
	public int getAxes(){
		return this.axes;
	}
	
	public int getBows(){
		return this.bows;
	}
	
	public int getLarm(){
		return this.larm;
	}
	
	public int getHarm(){
		return this.harm;
	}
	
	public int getEarth(){
		return this.earth;
	}
	
	public int getFire(){
		return this.fire;
	}
	
	public int getWater(){
		return this.water;
	}
	
	public int getAir(){
		return this.air;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public int getCap(){
		return this.level * 100;
	}
	
	public int getXp(){
		return this.xp;
	}
	
	public int getEarthR(){
		return this.earthR;
	}
	
	public int getFireR(){
		return this.fireR;
	}
	
	public int getWaterR(){
		return this.waterR;
	}
	
	public int getAirR(){
		return this.airR;
	}
	
	public int getMana(){
		return this.Int * 10;
	}
	
	public int getHealth(){
		return this.level * 10;
	}
}