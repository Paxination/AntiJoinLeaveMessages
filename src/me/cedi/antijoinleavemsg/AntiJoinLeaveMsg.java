package me.cedi.antijoinleavemsg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiJoinLeaveMsg extends JavaPlugin implements Listener {
	public void onDisable() {
		System.out.println(getDescription().getName() + " version " + getDescription().getVersion() + " disabled.");
	}
	public void onEnable() {
		System.out.println(getDescription().getName() + " version " + getDescription().getVersion() + " enabled.");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	
//----{{OnPlayerJoin}}----
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		
		Player player = event.getPlayer();
		
//----(FullSilence join)----
		if(player.hasPermission("AJLM.fullsilence.join")){
			
			event.setJoinMessage("");
			
			//--- Show Op's a message the "player" has joined ----
			for(Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()){
				if(onlinePlayer.isOp()){
					onlinePlayer.sendMessage(ChatColor.GREEN + player.getName() + " joined the game.");
				}
			}
			return;
		}
//----(SelfHide join)----
		if(player.hasPermission("AJLM.hide.join")){
			//---- Show everyone online that someone has joined except for player himself ----
			for(org.bukkit.entity.Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()){
				if(onlinePlayer.equals(player) == false){
					event.setJoinMessage("");
					onlinePlayer.sendMessage(ChatColor.YELLOW + player.getName() + " joined the game.");
				}
			}
			return;
		}
	}
	
//----{{OnPlayerLeave}}----
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){
		
		Player player = event.getPlayer();
		
//----(FullSilence quit)----
		if(player.hasPermission("AJLM.fullsilence.quit")){
			
			event.setQuitMessage("");
			
			//--- Show Op's a message the "player" has quit ----	
			for(Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()){
				if(onlinePlayer.isOp()){
					onlinePlayer.sendMessage(ChatColor.GREEN + player.getName() + " left the game.");
				}
			}
			return;
		}
//----(SelfHide quit)----
		if(player.hasPermission("AJLM.hide.quit")){
			//---- Show everyone online that someone has quit except for player himself ----
			for(Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()){
				if(onlinePlayer.equals(player) == false){
					event.setQuitMessage("");
					onlinePlayer.sendMessage(ChatColor.YELLOW + player.getName() + " left the game.");
				}
			}
			return;
		}
	}
}