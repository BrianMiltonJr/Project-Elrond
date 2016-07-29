package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.MessagePrompt;
import org.bukkit.conversations.Prompt;

public class EndPrompt extends MessagePrompt{

	@Override
	public String getPromptText(ConversationContext con) {
		return "Welcome to Project Elrond " + con.getSessionData("name");
	}

	@Override
	protected Prompt getNextPrompt(ConversationContext arg0) {
		return Prompt.END_OF_CONVERSATION;
	}

}
