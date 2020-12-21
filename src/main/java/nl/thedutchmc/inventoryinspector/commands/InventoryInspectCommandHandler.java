package nl.thedutchmc.inventoryinspector.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import nl.thedutchmc.inventoryinspector.InventoryInspector;

public class InventoryInspectCommandHandler implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!sender.hasPermission("ii.inventory")) {
			sender.sendMessage(InventoryInspector.getPluginPrefix() + ChatColor.RED + "You do not have permission to use this command!");
			return true;
		}
		
		if(args.length != 1) {
			sender.sendMessage(InventoryInspector.getPluginPrefix() + ChatColor.RED + "Missing argument!");
			return true;
		}
		
		Player pTarget = Bukkit.getPlayer(args[0]);
		Player pSender = (Player) sender;
				
		Inventory openInventory = Bukkit.createInventory(null, 45, args[0] + "'s Inventory");
		
		openInventory.setItem(0, pTarget.getInventory().getItemInOffHand());
		openInventory.setItem(5, pTarget.getInventory().getHelmet());
		openInventory.setItem(6, pTarget.getInventory().getChestplate());
		openInventory.setItem(7, pTarget.getInventory().getLeggings());
		openInventory.setItem(8, pTarget.getInventory().getBoots());
		
		ItemStack noSlotStack = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		ItemMeta noSlotMeta = noSlotStack.getItemMeta();
		noSlotMeta.setDisplayName(ChatColor.BLACK + "NO SLOT");
		noSlotStack.setItemMeta(noSlotMeta);
		
		for(int i = 1; i <= 4; i++) {
			openInventory.setItem(i, noSlotStack);
		}
			
		for(int i = 0; i < 36; i++) {
			openInventory.setItem(i+9, pTarget.getInventory().getItem(i));
		}
		
		pSender.openInventory(openInventory);
		
		sender.sendMessage(InventoryInspector.getPluginPrefix() + ChatColor.GOLD + "Inspecting inventory of " + args[0]);
		
		return true;
	}
	
}
