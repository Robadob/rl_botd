package com.BookOfTheDeadRename;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.Map;

@Slf4j
@PluginDescriptor(
	name = "Book of The Dead Renamer",
	description = "Renames Book of the Dead teleport options to real locations",
	tags = {"book", "teleport", "memoirs", "rename"}
)
public class BookOfTheDeadRenamePlugin extends Plugin
{
	@Inject
	private Client client;

	private static final Map<String, String> TELEPORT_NAME_MAP = Map.of(
			"Lunch by the Lancalliums", "Hosidius",
			"The Fisher's Flute", "Port Piscarilius",
			"History and Hearsay", "Shayzien",
			"Jewellery of Jubilation", "Lovakengj",
			"A Dark Disposition", "Arceuus"
	);

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		String option = event.getOption();
		// Only rename submenu teleport options
		if (TELEPORT_NAME_MAP.containsKey(option))
		{
			event.getMenuEntry().setOption(TELEPORT_NAME_MAP.get(option));
		}
	}
}
