package com.gmail.lonelyretardxd.elrond.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.lonelyretardxd.elrond.items.CharacterBook;
import com.gmail.lonelyretardxd.elrond.server.PlayerBase;
import com.gmail.lonelyretardxd.elrond.server.Toon;

public class EntryListener implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		//Checks if player exists. If doesn't then creates one.
		if(!PlayerBase.exists(event.getPlayer().getUniqueId().toString())){
			event.getPlayer().chat("/entry");
		}
		//Check if Player has a book and gives one if needed.
		boolean contains = event.getPlayer().getInventory().contains(Material.WRITTEN_BOOK);
		if(!contains){
			event.getPlayer().getInventory().addItem(CharacterBook.createBook(event.getPlayer()));
		}else{				
		}
		//Creates new Toon Instance
		Toon user = new Toon(event.getPlayer());
		//Assigns User Name every time the player joins to keep any name changing glitches halted on relog.
		user.assignName();
		//Set the Join Message for Player
		event.setJoinMessage(null);
	}
}
