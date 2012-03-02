package me.cedi.antijoinleavemsg;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiJoinLeaveMsgCore extends JavaPlugin {
	public void onDisable() {
		System.out.println(getDescription().getName() + " version " + getDescription().getVersion() + " disabled.");
	}
	public void onEnable() {
		System.out.println(getDescription().getName() + " version " + getDescription().getVersion() + " enabled.");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new AntiJoinLeaveMsgListener(), this);
	}
}
