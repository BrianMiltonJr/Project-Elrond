package com.gmail.lonelyretardxd.elrond.conversations.entry;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;

public class EntryPrompt extends StringPrompt{
	
	@Override
	public Prompt acceptInput(ConversationContext con, String ans) {
		con.setSessionData("name", ans);
		return new WelcomePrompt();
	}

	@Override
	public String getPromptText(ConversationContext arg0) {
		return "What is your name?";
	}

}
