package nl.thedutchmc.inventoryinspector.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class InventoryCloseEventListener implements Listener {

	@EventHandler
	public void onInventoryCloseEvent(InventoryCloseEvent event) {
		if(!event.getInventory().getItem(1).getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE)) return; 
		if(!event.getInventory().getItem(1).hasItemMeta()) return;
		if(!event.getInventory().getItem(1).getItemMeta().getDisplayName().equals(ChatColor.BLACK + "NO SLOT")) return;
		
		String sOwner = event.getView().getTitle().split("'")[0];
		Player pOwner = Bukkit.getPlayer(sOwner);
		
		pOwner.getInventory().setContents(event.getInventory().getContents());
		pOwner.getInventory().setArmorContents(new ItemStack[] {event.getInventory().get, null, null, null});
		
	}
}
