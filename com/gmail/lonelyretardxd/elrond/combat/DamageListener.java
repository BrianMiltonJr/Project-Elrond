package com.gmail.lonelyretardxd.elrond.combat;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.lonelyretardxd.elrond.Elrond;
import com.gmail.lonelyretardxd.elrond.items.weapons.ElrondWeapon;
import com.gmail.lonelyretardxd.elrond.server.Toon;

public class DamageListener implements Listener{

	//Intercepts Damage
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e)throws IOException{
		//If the Damager is a player
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			//Creates a New Toon Instance
			Toon t = new Toon(p);
			//Get the Item in hand and get it's Display name
			ItemStack w = p.getInventory().getItemInMainHand();
			String weapon = w.getItemMeta().getDisplayName();
			//If the Weapon is equals to the Training Sword
			if (weapon.matches(ElrondWeapon.trainingSword[1])){
				//Grab the Damage off the weapon
				int dmg = ElrondWeapon.getDmg(ElrondWeapon.trainingSword);
				//Create the Melee Damage Formula
				int formula = dmg + ((t.getStr() + ElrondWeapon.getStr(ElrondWeapon.trainingSword)) * 10);
				//TODO Remove after Development
				Elrond.print("Damage Outputed " + String.valueOf(formula));
				//Sets the Damage to the Damagee
				e.setDamage((double) formula);
			}else if(weapon.matches(ElrondWeapon.trainingAxe[1])){
				int dmg = ElrondWeapon.getDmg(ElrondWeapon.trainingSword);
				int formula = dmg + ((t.getStr() + ElrondWeapon.getStr(ElrondWeapon.trainingAxe)) * 10);
				Elrond.print("Damage Outputed " + String.valueOf(formula));
				e.setDamage((double) formula);
			}else{
				Elrond.print(weapon);
				Elrond.print("Damage Outputed 0");
				e.setDamage((double) 0);
			} 
		}
	}
}
