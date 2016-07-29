package com.gmail.lonelyretardxd.elrond.server;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.gmail.lonelyretardxd.elrond.items.ElrondItem;
import com.gmail.lonelyretardxd.elrond.items.armor.ElrondArmor;
import com.gmail.lonelyretardxd.elrond.items.weapons.ElrondWeapon;

public class ChooseStarterWeapon {

	public static Toon toon;
	public static Player player;
	
	public ChooseStarterWeapon(Player p){
		toon = new Toon(p);
		player = p;
	}
	
	//Checks which starter weapon to give based on selected Skills
	public static void returnWeapon(){
		int swords = toon.getSwords();
		int axes = toon.getAxes();
		int bows = toon.getBows();
		int shields = toon.getShields();
		if(swords >= 1){
			player.getInventory().addItem(ElrondItem.createItem(Material.WOOD_SWORD, 1, ElrondWeapon.trainingSword[1], ElrondWeapon.trainingSword[0]));
		}
		if(axes >= 1){
			player.getInventory().addItem(ElrondItem.createItem(Material.WOOD_AXE, 1, ElrondWeapon.trainingSword[1], ElrondWeapon.trainingSword[0]));
		}
		if(bows >= 1){
			player.getInventory().addItem(ElrondItem.createItem(Material.BOW, 1, ElrondWeapon.trainingBow[1], ElrondWeapon.trainingBow[0]));
		}
		if(shields >= 1){
			player.getInventory().addItem(ElrondItem.createItem(Material.SHIELD, 1, ElrondArmor.training_shield[1], ElrondArmor.training_shield[0]));
		}
	}
}
