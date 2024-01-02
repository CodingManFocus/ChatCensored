package app.focusprojectteam.chatcensored;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private FileHandler fileHandler;

    @Override
    public void onEnable() {
        System.out.println("---------------------------------------------------");
        System.out.println("     ______    ______                              ");
        System.out.println("    /  ___/   /  ___/                              ");
        System.out.println("   /  /__    /  /__   ChatCensored                 ");
        System.out.println("  /_____/   /_____/   V1.0.0 by Focus Project Team ");
        System.out.println("---------------------------------------------------");

        fileHandler = new FileHandler(this);
        fileHandler.setupConfig();

        getServer().getPluginManager().registerEvents(new Filter(this), this);
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    @Override
    public void onDisable() {
        System.out.println("Chatcensored is Disabled");
        System.out.println("Goodbye!~~");
    }
}
