package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.MessagePrompt;
import org.bukkit.conversations.Prompt;

import net.md_5.bungee.api.ChatColor;

public class WelcomePrompt extends MessagePrompt{

	@Override
	public String getPromptText(ConversationContext con) {
		con.setSessionData("str", 0);
		con.setSessionData("int", 0);
		con.setSessionData("agi", 0);
		con.setSessionData("arm", 0);
		con.setSessionData("swords", 0);
		con.setSessionData("shields", 0);
		con.setSessionData("axes", 0);
		con.setSessionData("bows", 0);
		con.setSessionData("larm", 0);
		con.setSessionData("harm", 0);
		con.setSessionData("earth", 0);
		con.setSessionData("fire", 0);
		con.setSessionData("water", 0);
		con.setSessionData("air", 0);
		con.setSessionData("stp", 5);
		con.setSessionData("sp", 5);
		return "---------------------------------\n"
				+ ChatColor.GREEN + "Welcome " + ChatColor.AQUA + con.getSessionData("name") + ChatColor.GREEN + ", to" + ChatColor.LIGHT_PURPLE + " Project Elrond" + ChatColor.GREEN + ". This is the First true MMORPG expierence in Minecraft"
				+ " with plenty more to come. In " + ChatColor.LIGHT_PURPLE + "Project Elrond " + ChatColor.GREEN + "we use a Free Class Model meaning you aren't restricted to a certain"
				+ " class that is predetermined by us. You have" + ChatColor.RED + " Skills" + ChatColor.GREEN +" and " + ChatColor.BLUE + "Stats " + ChatColor.GREEN + ". A " + ChatColor.RED + "Skill" + ChatColor.GREEN + " is a skill that allows you to weapons/"
				+ "abilities/armor. A " + ChatColor.BLUE+ "Stat" + ChatColor.GREEN + " is a value used to buff certain aspect of your character." + ChatColor.DARK_PURPLE + " Player Stats Include: Vitality, Spirit, Strength, Intellect,"
				+ " Agility, and Armor. " +ChatColor.BLUE + "Vitality" + ChatColor.GREEN + " increase your health." + ChatColor.BLUE
				 + "Spirit" + ChatColor.GREEN + " increases mana."+ ChatColor.BLUE + "Strength " + ChatColor.GREEN + "Increases Melee Damage. " + ChatColor.BLUE + "Intellect" + ChatColor.GREEN + " increases the Effect of spells. " + ChatColor.BLUE + "Agility" + ChatColor.GREEN + " Increases"
				+ " Ranged Damage. " + ChatColor.BLUE + "Armor" + ChatColor.GREEN + " is a Damage Reduction Stat. " + ChatColor.DARK_PURPLE + "Player Skills Include: Swords, Shields, Axes, Bows, Light Armor"
				+ ", Heavy Armor, and The Schools of Earth, Fire, Water, and Air." + ChatColor.GREEN + " " + ChatColor.RED + "The School of Earth" + ChatColor.GREEN + " is Healing Magic. " + ChatColor.RED + "The School"
				+ " of Fire" + ChatColor.GREEN + " is Damage Magic. " + ChatColor.RED + "The School of Water " + ChatColor.GREEN + "is a Damage over Time Magic. " + ChatColor.RED + "The School of Air " + ChatColor.GREEN + "is a Buff Magic.";
	}

	@Override
	protected Prompt getNextPrompt(ConversationContext con) {
		return new VitalityPrompt();
	}

}
