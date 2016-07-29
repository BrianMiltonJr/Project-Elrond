package com.gmail.lonelyretardxd.elrond.conversations.entry;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.conversations.Conversable;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;

import com.gmail.lonelyretardxd.elrond.server.ChooseStarterWeapon;
import com.gmail.lonelyretardxd.elrond.server.TestPlayerBase;

public class FinalPrompt extends StringPrompt{

	@Override
	public Prompt acceptInput(ConversationContext con, String s) {
		if(s.equalsIgnoreCase("yes")){
			Conversable c = con.getForWhom();
			Player player = (Player) c;
			try {
				TestPlayerBase.writePlayer(con.getSessionData("name").toString(), player.getUniqueId().toString(), player.getAddress().toString().substring(1, player.getAddress().toString().length() - 6), Integer.valueOf(con.getSessionData("vit").toString()), Integer.valueOf(con.getSessionData("spr").toString()) , Integer.valueOf(con.getSessionData("str").toString()), Integer.valueOf(con.getSessionData("int").toString()), Integer.valueOf(con.getSessionData("agi").toString()), Integer.valueOf(con.getSessionData("arm").toString()), Integer.valueOf(con.getSessionData("swords").toString()), Integer.valueOf(con.getSessionData("shields").toString()), Integer.valueOf(con.getSessionData("axes").toString()), Integer.valueOf(con.getSessionData("bows").toString()), Integer.valueOf(con.getSessionData("larm").toString()), Integer.valueOf(con.getSessionData("harm").toString()), Integer.valueOf(con.getSessionData("earth").toString()), Integer.valueOf(con.getSessionData("fire").toString()), Integer.valueOf(con.getSessionData("water").toString()), Integer.valueOf(con.getSessionData("air").toString()), Integer.valueOf(con.getSessionData("stp").toString()), Integer.valueOf(con.getSessionData("sp").toString()), 0, 1);
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			new ChooseStarterWeapon(player);
			ChooseStarterWeapon.returnWeapon();
			Bukkit.getPlayer(player.getUniqueId()).sendMessage("\n\n\n\n\n\n\n\n\n");
			return Prompt.END_OF_CONVERSATION;
		}else{
			return new EntryPrompt();
		}
	}

	@Override
	public String getPromptText(ConversationContext con) {
		return "---------------------------------\n"
				+ "Your Character Sheet-\n"
				+ "Name: " + con.getSessionData("name") + "\n"
				+ "Strength: " + con.getSessionData("str") + "\n"
				+ "Intellect: " + con.getSessionData("int") + "\n"
				+ "Agility: " + con.getSessionData("agi") + "\n"
				+ "Armor: " + con.getSessionData("arm") + "\n"
				+ "Swords: " + con.getSessionData("swords") + "\n"
				+ "Shields: " + con.getSessionData("shields") + "\n"
				+ "Axes: " + con.getSessionData("axes") + "\n"
				+ "Bows: " + con.getSessionData("bows") + "\n"
				+ "Light Armor: " + con.getSessionData("larm") + "\n"
				+ "Heavy Armor: " + con.getSessionData("harm") + "\n"
				+ "The School of Earth: " + con.getSessionData("earth") + "\n"
				+ "The School of Fire: " + con.getSessionData("fire") + "\n"
				+ "The School of Water: " + con.getSessionData("water") + "\n"
				+ "The School of Air: " + con.getSessionData("air") + "\n"
				+ "Remaining Stat Points: " + con.getSessionData("stp") + "\n"
				+ "Remaining Skill Points: " + con.getSessionData("sp") + "\n"
				+ "Do you want this to be your character sheet? You can only"
				+ " do this once so think carefully. Answer with yes or no.\n";
	}

}
