package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.MessagePrompt;
import org.bukkit.conversations.Prompt;

public class SkillBufferPrompt extends MessagePrompt{

	@Override
	public String getPromptText(ConversationContext arg0) {
		return null;
	}

	@Override
	protected Prompt getNextPrompt(ConversationContext arg0) {
		return new SwordsPrompt();
	}

}
