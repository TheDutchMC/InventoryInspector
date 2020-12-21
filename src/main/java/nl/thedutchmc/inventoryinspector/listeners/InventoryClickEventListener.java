package nl.thedutchmc.inventoryinspector.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.md_5.bungee.api.ChatColor;

public class InventoryClickEventListener implements Listener {

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent event) {
		if(event.getCurrentItem() == null) return;
		
		if(event.getCurrentItem().getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE)) {
			if(!event.getCurrentItem().hasItemMeta()) return;
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLACK + "NO SLOT")) {
				event.setCancelled(true);
			}
		}
	}
}
