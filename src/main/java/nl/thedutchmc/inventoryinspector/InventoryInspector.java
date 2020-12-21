package nl.thedutchmc.inventoryinspector;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import nl.thedutchmc.inventoryinspector.commands.InventoryInspectCommandHandler;
import nl.thedutchmc.inventoryinspector.listeners.InventoryClickEventListener;

public class InventoryInspector extends JavaPlugin {

	public static InventoryInspector INSTANCE;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
	
		this.getCommand("inventorysee").setExecutor(new InventoryInspectCommandHandler());
	
		Bukkit.getPluginManager().registerEvents(new InventoryClickEventListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static void logInfo(String log) {
		INSTANCE.getLogger().info(log);
	}
	
	public static void logWarn(String log) {
		INSTANCE.getLogger().warning(log);
	}
	
	public static String getPluginPrefix() {
		return ChatColor.GRAY + "[" + ChatColor.AQUA + "ii" + ChatColor.GRAY + "] " + ChatColor.RESET; 
	}
}
