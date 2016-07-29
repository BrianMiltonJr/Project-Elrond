package com.gmail.lonelyretardxd.elrond.commands;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.Conversable;
import org.bukkit.conversations.Conversation;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;

import com.gmail.lonelyretardxd.elrond.Elrond;
import com.gmail.lonelyretardxd.elrond.conversations.entry.EntryPrompt;
import com.gmail.lonelyretardxd.elrond.items.CharacterBook;
import com.gmail.lonelyretardxd.elrond.server.TestPlayerBase;

public class CommandEntry implements CommandExecutor{

	Elrond plugin;
	public static MapView map;
	
	public static void setMap(MapView m){
		map = m;
	}
	
	public CommandEntry(Elrond instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//Cast sender as a Player for player manipulation
		Player player = (Player) sender;
		//If command = entry
		if(cmd.getName().equalsIgnoreCase("entry")){
			//Creates a Conversations
			Conversation conv = plugin.factory.withFirstPrompt(new EntryPrompt()).thatExcludesNonPlayersWithMessage("Get away, or be BURNED MORTAL.").buildConversation(((Conversable) sender));
			//Starts Conversation
			conv.begin();
		//Level up command
		}else if(cmd.getName().equalsIgnoreCase("levelup")){
			try{
				if(args[0].equalsIgnoreCase("vitality") || args[0].equalsIgnoreCase("vit")){
					TestPlayerBase.increaseStat(player.getUniqueId().toString(), "vit", Integer.valueOf(args[1].toString()));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("strength") || args[0].equalsIgnoreCase("str")){
					TestPlayerBase.increaseStat(player.getUniqueId().toString(), "str", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("intellect") || args[0].equalsIgnoreCase("int")){
					TestPlayerBase.increaseStat(player.getUniqueId().toString(), "int", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("agility") || args[0].equalsIgnoreCase("agi")){
					TestPlayerBase.increaseStat(player.getUniqueId().toString(), "agi", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("armor") || args[0].equalsIgnoreCase("arm")){
					TestPlayerBase.increaseStat(player.getUniqueId().toString(), "arm", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("swords") || args[0].equalsIgnoreCase("sword")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "swords", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("shields") || args[0].equalsIgnoreCase("shield")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "shields", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("axes") || args[0].equalsIgnoreCase("axe")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "axes", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("bows") || args[0].equalsIgnoreCase("bow")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "bows", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("light") || args[0].equalsIgnoreCase("larm")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "larm", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("heavy") || args[0].equalsIgnoreCase("harm")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "harm", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("earth") || args[0].equalsIgnoreCase("e")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "earth", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("fire") || args[0].equalsIgnoreCase("f")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "fire", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("water") || args[0].equalsIgnoreCase("w")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "water", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else if(args[0].equalsIgnoreCase("air") || args[0].equalsIgnoreCase("a")){
					TestPlayerBase.increaseSkill(player.getUniqueId().toString(), "air", Integer.valueOf(args[1]));
					player.getInventory().remove(Material.WRITTEN_BOOK);
					player.getInventory().addItem(CharacterBook.createBook(player));
				}else{
					return false;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return true;
	}
}
