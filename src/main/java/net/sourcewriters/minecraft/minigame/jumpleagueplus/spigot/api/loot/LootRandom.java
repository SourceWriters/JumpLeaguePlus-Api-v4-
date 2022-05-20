package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random.IRandom;

public final class LootRandom {

    private IRandom random;

    private int minimalEnchantments;
    private int maximalEnchantments;

    public LootRandom(final IRandom random) {
        random(random);
    }

    public LootRandom random(IRandom random) {
        this.random = Objects.requireNonNull(random);
        return this;
    }

    public IRandom random() {
        return random;
    }

    public LootRandom minimalEnchantments(int minimalEnchantments) {
        this.minimalEnchantments = Math.abs(minimalEnchantments);
        this.maximalEnchantments = Math.max(this.maximalEnchantments, this.minimalEnchantments);
        return this;
    }

    public int minimalEnchantments() {
        return minimalEnchantments;
    }

    public LootRandom maximalEnchantments(int maximalEnchantments) {
        this.maximalEnchantments = Math.abs(maximalEnchantments);
        this.minimalEnchantments = Math.min(this.maximalEnchantments, this.minimalEnchantments);
        return this;
    }

    public int maximalEnchantments() {
        return maximalEnchantments;
    }

    public double nextDouble() {
        return random.nextDouble();
    }

    public double nextDouble(double max) {
        return random.nextDouble(max);
    }

    public double nextDouble(double min, double max) {
        return random.nextDouble(min, max);
    }

    public int nextInt(int max) {
        return random.nextInt(max);
    }

    public int nextInt(int min, int max) {
        return random.nextInt(min, max);
    }

    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    @SuppressWarnings("unchecked")
    public <E> E nextItem(E... array) {
        return random.nextItem(array);
    }

    public <E> E nextItem(List<E> list) {
        return random.nextItem(list);
    }

    public <E> E nextItem(Collection<E> collection) {
        return random.nextItem(collection);
    }

    public <E> E nextItem(Iterable<E> iterable) {
        return random.nextItem(iterable);
    }

    public <E> E nextItem(Iterator<E> iterator) {
        return random.nextItem(iterator);
    }

    public void randomizeEnchantments(ItemStack itemStack) {
        randomizeEnchantments(IEnchantmentLimiter.DEFAULT, itemStack);
    }

    public void randomizeEnchantments(ItemStack itemStack, int amount) {
        randomizeEnchantments(IEnchantmentLimiter.DEFAULT, itemStack, amount);
    }

    public void randomizeEnchantments(ItemStack itemStack, int amount, Enchantment... enchantments) {
        randomizeEnchantments(IEnchantmentLimiter.DEFAULT, itemStack, amount, enchantments);
    }

    public void randomizeEnchantments(IEnchantmentLimiter limiter, ItemStack itemStack) {
        if (itemStack == null || (minimalEnchantments == 0 && maximalEnchantments == 0)) {
            return;
        }
        randomizeEnchantments(limiter, itemStack, random.nextInt(minimalEnchantments, maximalEnchantments), Enchantment.values());
    }

    public void randomizeEnchantments(IEnchantmentLimiter limiter, ItemStack itemStack, int amount) {
        if (itemStack == null || amount < 1) {
            return;
        }
        randomizeEnchantments(limiter, itemStack, amount, Enchantment.values());
    }

    public void randomizeEnchantments(IEnchantmentLimiter limiter, ItemStack itemStack, int amount, Enchantment... enchantments) {
        if (itemStack == null || amount < 1) {
            return;
        }
        Material type = itemStack.getType();
        for (int index = 0; index < enchantments.length; index++) {
            Enchantment enchantment = enchantments[index];
            if (enchantment == null || !enchantment.getItemTarget().includes(type) || !enchantment.canEnchantItem(itemStack)
                || !limiter.allowEnchantment(random, enchantment)) {
                continue;
            }
            int min = Math.min(limiter.getMinLevel(enchantment), enchantment.getMaxLevel());
            int max = Math.min(limiter.getMaxLevel(enchantment), enchantment.getMaxLevel());
            int level = nextInt(Math.min(min, max), Math.max(min, max));
            if (level == 0) {
                continue;
            }
            itemStack.addEnchantment(enchantment, level);
        }
    }

    public void randomizeAmount(ItemStack itemStack, int min, int max) {
        if (itemStack == null) {
            return;
        }
        itemStack.setAmount(Math.min(Math.max(random.nextInt(min, max), 1), itemStack.getMaxStackSize()));
    }

    public void randomizeAmount(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        itemStack.setAmount(random.nextInt(1, itemStack.getMaxStackSize()));
    }

}
