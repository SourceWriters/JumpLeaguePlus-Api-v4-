package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot;

import org.bukkit.enchantments.Enchantment;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random.IRandom;

public interface IEnchantmentLimiter {

    public static final IEnchantmentLimiter DEFAULT = new IEnchantmentLimiter() {
        @Override
        public boolean allowEnchantment(IRandom random, Enchantment enchantment) {
            return random.nextBoolean();
        }

        @Override
        public int getMinLevel(Enchantment enchantment) {
            return enchantment.getStartLevel();
        }

        @Override
        public int getMaxLevel(Enchantment enchantment) {
            return enchantment.getMaxLevel();
        }
    };

    int getMinLevel(Enchantment enchantment);

    int getMaxLevel(Enchantment enchantment);

    boolean allowEnchantment(IRandom random, Enchantment enchantment);

}
