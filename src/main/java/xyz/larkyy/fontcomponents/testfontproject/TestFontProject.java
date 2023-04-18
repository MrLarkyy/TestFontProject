package xyz.larkyy.fontcomponents.testfontproject;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.larkyy.fontcomponents.fontcomponents.ComponentHolder;
import xyz.larkyy.fontcomponents.fontcomponents.ComponentRepository;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.components.impl.BasicComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.impl.OffsetComponent;

public final class TestFontProject extends JavaPlugin {

    @Override
    public void onEnable() {
        FontComponents fontComponents = FontComponents.initialize(this);

        ComponentRepository repository = fontComponents.getComponentRepository();
        repository.addComponent(
                "Rewards1",
                BasicComponent.builder()
                        .setText("\uE001")
                        .setWidth(235)
                        .build()
                );
        repository.addComponent(
                "Rewards2",
                BasicComponent.builder()
                        .setText("\uE002")
                        .setWidth(99)
                        .build()
        );
        repository.addComponent(
                "Button",
                BasicComponent.builder()
                        .setText("\uE003")
                        .setWidth(50)
                        .build()
        );
        OffsetComponent offset1 = new OffsetComponent("\uE004",null,1);
        OffsetComponent offsetN1 = new OffsetComponent("\uE000",null,-1);

        repository.addOffset(1,offset1);
        repository.addOffset(-1,offsetN1);

        repository.addComponent("offset1",offset1);
        repository.addComponent("offsetN1",offsetN1);

        ComponentHolder holder = new ComponentHolder();
        for (int i = 0; i <43;i++) {
            holder.addComponent(repository.getComponent("offsetN1"));
        }
        holder.addComponent(BasicComponent.builder().setText("§f").build());
        holder.addComponent(repository.getComponent("Rewards1"));
        holder.addComponent(repository.getComponent("offsetN1"));
        holder.addComponent(repository.getComponent("Rewards2"));
        /*
        for (int i = 0; i <290;i++) {
            holder.addComponent(repository.getComponent("offsetN1"));
        }
        holder.addComponent(repository.getComponent("Button"));
         */

        String string = holder.generate(null);

        TestInventory inv = new TestInventory(string);
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.openInventory(inv.getInventory());
        });

        getServer().getPluginManager().registerEvents(new Listeners(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
