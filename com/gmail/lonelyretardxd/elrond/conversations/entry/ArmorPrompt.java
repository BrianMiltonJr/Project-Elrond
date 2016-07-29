package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.NumericPrompt;
import org.bukkit.conversations.Prompt;

public class ArmorPrompt extends NumericPrompt{

	@Override
	public String getPromptText(ConversationContext con) {
		return "---------------------------------\n"
				+ "Well " + con.getSessionData("name") + " how many points would you like to add to Armor? You have " + con.getSessionData("stp") + " Stat Points left.";
	}

	@Override
	protected Prompt acceptValidatedInput(ConversationContext con, Number num) {
		if(Integer.valueOf(num.toString()) > Integer.valueOf(con.getSessionData("stp").toString())){
			return new StpErrorPrompt(this);
		}else if(Integer.valueOf(con.getSessionData("stp").toString()) == 0){
			con.setSessionData("arm", 0);
			return new SkillBufferPrompt();
		}else{
			int previousStp = Integer.valueOf(con.getSessionData("stp").toString());
			int spendingStp = Integer.valueOf(num.toString());
			int newStp = previousStp - spendingStp;
			con.setSessionData("arm", spendingStp);
			con.setSessionData("stp", newStp);
			return new StatLogicBufferPrompt(new SkillBufferPrompt());
		}
	}

}
