package com.gmail.lonelyretardxd.elrond.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import com.gmail.lonelyretardxd.elrond.server.Toon;

public class CharacterBook {

	public static ItemStack createBook(Player p){
		Toon toon = new Toon(p);
		//Create a blank Book
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		//Create a blank BookMeta Container
		BookMeta bm = (BookMeta) book.getItemMeta();
		//Create 3 Pages
		bm.addPage("Character", "Stats", "Skills");
		//Set Character Page
		bm.setPage(1, "Welcome " + toon.getName() + "!\n"
				+ "Within this book you will find your stats"
				+ " and your skills. Enjoy!\n"
				+ "Your Remaining Skill Points: " + toon.getSp()
				+ "\nYour Remaining Stat Points: " + toon.getStp());
		//Set Stats Page
		bm.setPage(2, "Stats-\n"
				+ " Strength: " + toon.getStr() +
				"\n Intellect: " + toon.getInt() +
				"\n Agility: " + toon.getAgi() +
				"\n Vitality: " + toon.getVit() +
				"\n Spirit: " + toon.getSpr() +
				"\n Armor: " + toon.getArm());
		//Set Skills Page
		bm.setPage(3, "Skills-\n"
				+ " Swords: " + toon.getSwords()
				+ "\n Shields: " + toon.getShields()
				+ "\n Axes: " + toon.getAxes()
				+ "\n Bows: " + toon.getBows()
				+ "\n Light Armor: " + toon.getLarm()
				+ "\n Heavy Armor: " + toon.getHarm()
				+ "\n School of Earth: " + toon.getEarth()
				+ "\n School of Fire: " + toon.getFire()
				+ "\n School of Water: " + toon.getWater()
				+ "\n School of Air: " + toon.getAir());
		//Set Authors Name
		bm.setAuthor(toon.getName());
		//Set Display Name
		bm.setDisplayName(toon.getName());
		//Set the Books Meta with Meta Container
		book.setItemMeta(bm);
		//Return the Book
		return book;
	}
}
