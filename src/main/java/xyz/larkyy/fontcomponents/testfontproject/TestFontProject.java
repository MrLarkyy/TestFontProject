package xyz.larkyy.fontcomponents.testfontproject;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.larkyy.fontcomponents.fontcomponents.ComponentHolder;
import xyz.larkyy.fontcomponents.fontcomponents.ComponentRepository;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.components.impl.BasicComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.impl.CenterComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.impl.OffsetComponent;

public final class TestFontProject extends JavaPlugin {

    @Override
    public void onEnable() {
        FontComponents fontComponents = FontComponents.initialize(this);

        ComponentRepository repository = fontComponents.getComponentRepository();
        repository.addComponent(
                "UIComponent",
                BasicComponent.builder()
                        .setText("TEXTURE1")
                        .setWidth(100)
                        .build()
                );
        repository.addComponent(
                "NUM1",
                BasicComponent.builder()
                        .setText("NUM1_TEXTURE")
                        .setWidth(10)
                        .setCentered(true)
                        .build()
                );
        OffsetComponent offset1 = new OffsetComponent("A",null,1);
        OffsetComponent offset5 = new OffsetComponent("B",null,5);
        OffsetComponent offset10 = new OffsetComponent("C",null,10);
        OffsetComponent offsetN1 = new OffsetComponent("N",null,-1);

        repository.addOffset(1,offset1);
        repository.addOffset(5,offset5);
        repository.addOffset(10,offset10);
        repository.addOffset(-1,offsetN1);

        repository.addComponent("offset1",offset1);
        repository.addComponent("offset5",offset5);
        repository.addComponent("offset10",offset10);
        repository.addComponent("offset-1",offsetN1);

        ComponentHolder holder = new ComponentHolder();
        holder.addComponent(repository.getComponent("UIComponent"));
        holder.addComponent(repository.getComponent("NUM1"));

        String string = holder.generate(null);

        Bukkit.broadcastMessage(string);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
