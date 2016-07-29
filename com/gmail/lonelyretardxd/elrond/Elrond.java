package com.gmail.lonelyretardxd.elrond;

import org.bukkit.conversations.ConversationFactory;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lonelyretardxd.elrond.combat.DamageListener;
import com.gmail.lonelyretardxd.elrond.commands.CommandEntry;
import com.gmail.lonelyretardxd.elrond.listeners.EntryListener;
import com.gmail.lonelyretardxd.elrond.server.PlayerBase;
import com.gmail.lonelyretardxd.elrond.server.TestPlayerBase;

public class Elrond extends JavaPlugin{

	public static String name = "Project Elrond";
	public static Elrond plugin;
	public ConversationFactory factory = new ConversationFactory(this);
	
	public static void print(String print){
		System.out.println("[" + name + "] " + print);
	}
	
	@Override
	public void onEnable(){
		TestPlayerBase.createPlayerBaseDir();
		PlayerBase.createLevelDir();
		this.getCommand("entry").setExecutor(new CommandEntry(this));
		this.getCommand("levelup").setExecutor(new CommandEntry(this));
		getServer().getPluginManager().registerEvents(new DamageListener(), this);
		getServer().getPluginManager().registerEvents(new EntryListener(), this);
	}
	
	@Override
	public void onDisable(){
		
	}
	
}