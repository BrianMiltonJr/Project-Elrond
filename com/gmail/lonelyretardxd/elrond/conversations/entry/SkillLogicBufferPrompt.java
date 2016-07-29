package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.MessagePrompt;
import org.bukkit.conversations.Prompt;

public class SkillLogicBufferPrompt extends MessagePrompt{

	Prompt prompt;
	
	public SkillLogicBufferPrompt(Prompt p){
		this.prompt = p;
	}
	
	@Override
	public String getPromptText(ConversationContext arg0) {
		return " ";
	}

	@Override
	protected Prompt getNextPrompt(ConversationContext con) {
		if(Integer.valueOf(con.getSessionData("sp").toString()) == 0){
			return new FinalPrompt();
		}else{
			return prompt;
		}
	}

}
