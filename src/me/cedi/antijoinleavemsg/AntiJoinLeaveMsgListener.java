package me.cedi.antijoinleavemsg;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AntiJoinLeaveMsgListener implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(player.hasPermission("AJLM.hidejoin") || player.isOp()){
			event.setJoinMessage("");
		}
	}
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){
		Player player = event.getPlayer();
		if(player.hasPermission("AJLM.hidequit") || player.isOp()){
			event.setQuitMessage("");
		}
	}
}
