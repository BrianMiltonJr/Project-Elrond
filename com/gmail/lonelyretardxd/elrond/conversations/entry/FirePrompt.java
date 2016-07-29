package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.NumericPrompt;
import org.bukkit.conversations.Prompt;

public class FirePrompt extends NumericPrompt{

	@Override
	public String getPromptText(ConversationContext con) {
		return "---------------------------------\n"
				+ "Well " + con.getSessionData("name") + " how many points would you like to add to The School of Fire? You have " + con.getSessionData("sp") + " Skill Points left.";
	}

	@Override
	protected Prompt acceptValidatedInput(ConversationContext con, Number num) {
		if(Integer.valueOf(num.toString()) > Integer.valueOf(con.getSessionData("sp").toString())){
			return new SpErrorPrompt(this);
		}else{
			int previousSp = Integer.valueOf(con.getSessionData("sp").toString());
			int spendingSp = Integer.valueOf(num.toString());
			int newSp = previousSp - spendingSp;
			con.setSessionData("fire", spendingSp);
			con.setSessionData("sp", newSp);
			return new SkillLogicBufferPrompt(new WaterPrompt());
		}
	}

}
