package com.sucy.skill.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerToggleHandRaiseEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player  player;
    private final boolean raised;

    public PlayerToggleHandRaiseEvent(Player player, boolean raised) {
        this.player = player;
        this.raised = raised;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isRaised() {
        return raised;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }
}
