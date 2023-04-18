package xyz.larkyy.fontcomponents.testfontproject;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class TestInventory implements InventoryHolder {

    private final Inventory inventory;

    public TestInventory(String title) {
        this.inventory = Bukkit.createInventory(this,45,title);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
