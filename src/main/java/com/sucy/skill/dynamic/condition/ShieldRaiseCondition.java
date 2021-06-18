package com.sucy.skill.dynamic.condition;

import com.rit.sucy.config.parse.DataSection;
import com.sucy.skill.dynamic.DynamicSkill;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ShieldRaiseCondition extends ConditionComponent {
    private static final String SHIELD_RAISE = "shield-raise";

    private boolean shieldRaise;

    @Override
    public String getKey() {
        return "shield raise";
    }

    @Override
    public void load(DynamicSkill skill, DataSection config) {
        super.load(skill, config);
        shieldRaise = !settings.getString(SHIELD_RAISE, "true").toLowerCase().equals("false");
    }

    @Override
    boolean test(final LivingEntity caster, final int level, final LivingEntity target) {
        return target instanceof Player && ((Player) target).isHandRaised() == shieldRaise;
    }
}
