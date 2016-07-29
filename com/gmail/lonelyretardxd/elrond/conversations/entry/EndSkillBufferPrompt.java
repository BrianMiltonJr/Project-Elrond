package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.MessagePrompt;
import org.bukkit.conversations.Prompt;

public class EndSkillBufferPrompt extends MessagePrompt{

	@Override
	public String getPromptText(ConversationContext arg0) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	protected Prompt getNextPrompt(ConversationContext arg0) {
		// TODO Auto-generated method stub
		return new FinalPrompt();
	}

}
