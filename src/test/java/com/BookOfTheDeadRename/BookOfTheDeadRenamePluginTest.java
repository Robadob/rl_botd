package com.BookOfTheDeadRename;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class BookOfTheDeadRenamePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(BookOfTheDeadRenamePlugin.class);
		RuneLite.main(args);
	}
}