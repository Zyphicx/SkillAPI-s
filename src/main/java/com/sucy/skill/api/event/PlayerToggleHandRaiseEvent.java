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

    /**
     * @return the player who raised / lowered their hand
     */
    public Player getPlayer() {
        return player;
    }
    /**
     * @return if the hand was raised (true) or lowered (false)
     */
    public boolean isRaised() {
        return raised;
    }

    /**
     * @return gets the handlers for the event
     */
    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * @return gets the handlers for the event
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
