package ru.rzn.sbt.javaschool.lesson6.bff;

import java.util.*;

public class Solution {

    /**
     * 1. Создайте обобщённый класс TwoItems, параметризовынный типом <T> и хранящий две ссылки на объекты типа T.
     * Введите конструктор, принимающий два аргумента и get-методы.
     *
     * 2. В {@link Collection} persons найдите персоны, у которых взаимно совпадают ссылки на лучших друзей
     * {@link Person#bestFriend}, сформируйте из них экземпляры класса TwoItems<Person> и разместите
     * в {@link Collection}<TwoItems>.
     *
     * 3. В качестве результата выполнения метода {@link Solution#findBestFriends(Collection)} верните размер коллекции
     * с парами лучших друзей.
     */
    public static int findBestFriends(Collection<Person> persons) {
        Collection<TwoItems<Person>> set = new HashSet<>();
        for(Person item : persons) {
            if (null == item) continue;
            Person itemBestFriend = item.getBestFriend();
            for(Person other : persons) {
                if (other == null) continue;
                if (other == item) continue;
                Person otherBestFriend = other.getBestFriend();
                if (Objects.equals(itemBestFriend, other) && Objects.equals(otherBestFriend, item)) {
                    set.add(new TwoItems<>(item, other));
                }
            }
        }
        return set.size();
    }
}
