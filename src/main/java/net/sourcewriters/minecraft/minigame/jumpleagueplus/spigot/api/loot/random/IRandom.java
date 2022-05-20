package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface IRandom {

    double nextDouble();

    default double nextDouble(double max) {
        return nextDouble(0, max);
    }

    default double nextDouble(double min, double max) {
        return (nextDouble() * (max - min)) + min;
    }

    default int nextInt(int max) {
        return nextInt(0, max);
    }

    default int nextInt(int min, int max) {
        return (int) Math.round(nextDouble() * (max - min)) + min;
    }

    default boolean nextBoolean() {
        return Math.round(nextDouble()) == 1;
    }

    default <E> E nextItem(E[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[nextInt(array.length)];
    }

    default <E> E nextItem(List<E> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(nextInt(list.size()));
    }

    default <E> E nextItem(Collection<E> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        int index = nextInt(collection.size()) + 1;
        Iterator<E> iterator = collection.iterator();
        E item = null;
        while (iterator.hasNext() && index-- != 0) {
            item = iterator.next();
        }
        return item;
    }

    default <E> E nextItem(Iterable<E> iterable) {
        if (iterable == null) {
            return null;
        }
        return nextItem(iterable.iterator());
    }

    default <E> E nextItem(Iterator<E> iterator) {
        ArrayList<E> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return nextItem(list);
    }

}
