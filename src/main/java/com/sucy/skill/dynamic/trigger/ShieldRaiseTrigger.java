package com.sucy.skill.dynamic.trigger;

import com.sucy.skill.api.Settings;
import com.sucy.skill.api.event.PlayerToggleHandRaiseEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.Map;

public class ShieldRaiseTrigger implements Trigger<PlayerToggleHandRaiseEvent> {

    /** {@inheritDoc} */
    @Override
    public String getKey() {
        return "SHIELD_RAISE";
    }

    /** {@inheritDoc} */
    @Override
    public Class<PlayerToggleHandRaiseEvent> getEvent() {
        return PlayerToggleHandRaiseEvent.class;
    }

    /** {@inheritDoc} */
    @Override
    public boolean shouldTrigger(final PlayerToggleHandRaiseEvent event, final int level, final Settings settings) {
        final String type = settings.getString("type", "start blocking");
        return type.equalsIgnoreCase("both") || event.isRaised() != type.equalsIgnoreCase("stop blocking");
    }

    /** {@inheritDoc} */
    @Override
    public void setValues(final PlayerToggleHandRaiseEvent event, final Map<String, Object> data) { }

    /** {@inheritDoc} */
    @Override
    public LivingEntity getCaster(final PlayerToggleHandRaiseEvent event) {
        return event.getPlayer();
    }

    /** {@inheritDoc} */
    @Override
    public LivingEntity getTarget(final PlayerToggleHandRaiseEvent event, final Settings settings) {
        return event.getPlayer();
    }
}
