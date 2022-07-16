package itemplugin.itemplugin.EnchantItem;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EnchantItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Player Object
        Player player = (Player) sender;

        // Get Player Inventory
        PlayerInventory playerInventory = player.getInventory();

        // Create New Item
        ItemStack EnchantItem = new ItemStack(Material.NETHERITE_SWORD, 1);

        // Get Item MetaData
        ItemMeta EnchantItemMeta= EnchantItem.getItemMeta();

        // Set Display Name of Item
        EnchantItemMeta.setDisplayName("Enchanted Item");

        // Lore ( Item Description )
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + "Enchanted Item - Simple Item with Enchants and Description");

        // Set Lore
        EnchantItemMeta.setLore(lore);

        // Enchantments
        EnchantItemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1000, true);
        EnchantItemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 1000, true);
        EnchantItemMeta.addEnchant(Enchantment.FIRE_ASPECT, 1000, true);
        EnchantItemMeta.addEnchant(Enchantment.KNOCKBACK, 1000, true);
        EnchantItemMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 1000, true);
        EnchantItemMeta.addEnchant(Enchantment.MENDING, 1000, true);

        // Set Item MetaData
        EnchantItem.setItemMeta(EnchantItemMeta);

        // If There are Arguments give the Item
        if(args.length == 1){

            // Give Item if args is equal to Enchanted Item
            if(args[0].equalsIgnoreCase("enchantitem")){

                // Give The Item
                playerInventory.addItem(EnchantItem);

                // Send Message Saying Item was Given
                player.sendMessage(ChatColor.GREEN + "[ Success ] - The Enchanted Item has been Given to You.");

            } else {
                // Send if the Arguments dont match
                player.sendMessage(ChatColor.RED + "[ Error ] - There were no Arguments equalling UTS given.");
            }

        } else {
            // Send if there is no Arguments
            player.sendMessage(ChatColor.RED + "[ Error ] - Please Provide Arguments in Order to use this Command.");
        }

        return true;

    }
}
