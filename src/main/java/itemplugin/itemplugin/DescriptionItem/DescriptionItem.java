package itemplugin.itemplugin.DescriptionItem;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DescriptionItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Player Object
        Player player = (Player) sender;

        // Get Player Inventory
        PlayerInventory playerInventory = player.getInventory();

        // Create New Item
        ItemStack DescItem = new ItemStack(Material.NETHERITE_SWORD, 1);

        // Get Item MetaData
        ItemMeta DescItemMeta = DescItem.getItemMeta();

        // Set Display Name of Item
        DescItemMeta.setDisplayName("Description Item");

        // Lore ( Item Description )
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + "Description Item - Simple Item with Description");

        // Set Lore
        DescItemMeta.setLore(lore);

        // Set Item MetaData
        DescItem.setItemMeta(DescItemMeta);

        // If There are Arguments give the Item
        if(args.length == 1){

            // Give Item if args is equal to DescItem
            if(args[0].equalsIgnoreCase("descitem")){

                // Give The Item
                playerInventory.addItem(DescItem);

                // Send Message Saying Item was Given
                player.sendMessage(ChatColor.GREEN + "[ Success ] - The Description Item has been Given to You.");

            } else {
                // Send if the Arguments dont match
                player.sendMessage(ChatColor.RED + "[ Error ] - There were no Correct Arguments Given");
            }

        } else {
            // Send if there is no Arguments
            player.sendMessage(ChatColor.RED + "[ Error ] - Please Provide Arguments in Order to use this Command.");
        }

        return true;

    }
}
