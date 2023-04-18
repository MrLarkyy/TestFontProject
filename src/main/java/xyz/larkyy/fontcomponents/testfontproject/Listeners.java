package xyz.larkyy.fontcomponents.testfontproject;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.larkyy.fontcomponents.fontcomponents.ComponentHolder;
import xyz.larkyy.fontcomponents.fontcomponents.ComponentRepository;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.components.impl.BasicComponent;

public class Listeners implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() == null) {
            return;
        }
        if (!(e.getInventory().getHolder() instanceof TestInventory inv)) {
            return;
        }
        e.setCancelled(true);
        if (e.getSlot() == 0) {
            ComponentRepository repository = FontComponents.getInstance().getComponentRepository();
            ComponentHolder holder = new ComponentHolder();
            for (int i = 0; i <43;i++) {
                holder.addComponent(repository.getComponent("offsetN1"));
            }
            holder.addComponent(BasicComponent.builder().setText("§f").build());
            holder.addComponent(repository.getComponent("Rewards1"));
            holder.addComponent(repository.getComponent("offsetN1"));
            holder.addComponent(repository.getComponent("Rewards2"));
            for (int i = 0; i <291;i++) {
                holder.addComponent(repository.getComponent("offsetN1"));
            }
            holder.addComponent(repository.getComponent("Button"));
            Player p = (Player) e.getWhoClicked();

            p.openInventory(new TestInventory(holder.generate(null)).getInventory());
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.playSound(p, Sound.UI_BUTTON_CLICK,1,1);
                }
            }.runTaskLater(TestFontProject.getPlugin(TestFontProject.class),1);
            new BukkitRunnable() {
                @Override
                public void run() {
                    ComponentHolder holder = new ComponentHolder();
                    for (int i = 0; i <43;i++) {
                        holder.addComponent(repository.getComponent("offsetN1"));
                    }
                    holder.addComponent(BasicComponent.builder().setText("§f").build());
                    holder.addComponent(repository.getComponent("Rewards1"));
                    holder.addComponent(repository.getComponent("offsetN1"));
                    holder.addComponent(repository.getComponent("Rewards2"));
                    p.openInventory(new TestInventory(holder.generate(null)).getInventory());
                }
            }.runTaskLater(TestFontProject.getPlugin(TestFontProject.class),4);
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.closeInventory();
                }
            }.runTaskLater(TestFontProject.getPlugin(TestFontProject.class),6);
        }
    }

}
