import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * */

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        randomizedSet.getRandom();
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        randomizedSet.getRandom();
    }
}

class RandomizedSet {
    static ArrayList<Integer> list;
    static HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        System.out.println(Arrays.toString(new ArrayList[]{list})+" insert "+val);
        if(!map.containsKey(val)){
            int index = list.size();
            map.put(val, index);
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        System.out.println(Arrays.toString(new ArrayList[]{list})+" remove "+val);
        if(map.containsKey(val)){
            int index = map.get(val);
            list.set(index, list.get(list.size()-1));
            map.put(list.get(index), index);
            map.remove(val);
            list.remove(list.size()-1);
            System.out.println(Arrays.toString(new ArrayList[]{list})+"   "+index+" "+list.size());
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
