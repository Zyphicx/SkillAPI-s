package com.sucy.skill.task;

import com.rit.sucy.version.VersionManager;
import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.armorstand.ArmorStandManager;
import com.sucy.skill.api.event.PlayerToggleHandRaiseEvent;
import com.sucy.skill.thread.RepeatThreadTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.UUID;

public class ToggleHandRaiseTask extends RepeatThreadTask {
    private final HashSet<UUID> raisedPlayers = new HashSet();

    public ToggleHandRaiseTask() {
        super(1,1);
    }

    @Override
    public void run() {
        Player[] players = VersionManager.getOnlinePlayers();
        for(Player player : players) {
            boolean prevRaised = raisedPlayers.contains(player.getUniqueId());
            boolean nowRaised = player.isHandRaised();
            if(prevRaised != nowRaised) {
                if(nowRaised) {
                    raisedPlayers.add(player.getUniqueId());
                } else {
                    raisedPlayers.remove(player.getUniqueId());
                }

                SkillAPI.schedule(() -> Bukkit.getPluginManager().callEvent(new PlayerToggleHandRaiseEvent(player, nowRaised)), 0);
            }
        }
    }
}
