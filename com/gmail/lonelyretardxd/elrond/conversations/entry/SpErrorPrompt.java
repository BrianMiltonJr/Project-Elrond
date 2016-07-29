package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.MessagePrompt;
import org.bukkit.conversations.Prompt;

public class SpErrorPrompt extends MessagePrompt{

	Prompt prompt;
	public SpErrorPrompt(Prompt p){
		this.prompt = p;
	}
	
	@Override
	public String getPromptText(ConversationContext arg0) {
		return "---------------------------------\n"
		+ "You don't have enough Skill Points";
	}

	@Override
	protected Prompt getNextPrompt(ConversationContext arg0) {
		return this.prompt;
	}

}
