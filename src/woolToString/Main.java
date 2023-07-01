package woolToString;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener{
	
    @Override
    public void onEnable() {
		getServer().getConsoleSender().sendMessage("woolToString Enable!");
        getServer().getPluginManager().registerEvents(this, this);
        addWoolToStringRecipe();
    }

    private void addWoolToStringRecipe() {
        for (DyeColor color : DyeColor.values()) {
        	Material woolMaterial;
        	//"LEGACY_WHITE_WOOL" 에러 처리
        	if (color == DyeColor.WHITE) {
                woolMaterial = Material.WHITE_WOOL;
            } else {
                woolMaterial = Material.valueOf(color.toString() + "_WOOL");
            }
            ShapelessRecipe woolToStringRecipe = new ShapelessRecipe(new NamespacedKey(this, color.toString() + "_WOOL_To_String"), new ItemStack(Material.STRING, 4));
            woolToStringRecipe.addIngredient(new RecipeChoice.MaterialChoice(woolMaterial));
            Bukkit.addRecipe(woolToStringRecipe);
        }
    }
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("woolToString Disable.");
	}

} 	