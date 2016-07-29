package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.MessagePrompt;
import org.bukkit.conversations.Prompt;

public class StatLogicBufferPrompt extends MessagePrompt{

	Prompt prompt;
	
	public StatLogicBufferPrompt(Prompt p){
		this.prompt = p;
	}
	
	@Override
	public String getPromptText(ConversationContext arg0) {
		return " ";
	}

	@Override
	protected Prompt getNextPrompt(ConversationContext con) {
		if(Integer.valueOf(con.getSessionData("stp").toString()) == 0){
			return new SkillBufferPrompt();
		}else{
			return prompt;
		}
	}

}
