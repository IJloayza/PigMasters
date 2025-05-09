package m8.uf3.pigmasters.helpers;

import java.util.List;
import java.util.List;
import java.util.Random;

public class CustomListUtils {

    private static final Random random = new Random();

    public static <T> T pickRandom(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    public static <T> T pickRandom(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[random.nextInt(array.length)];
    }
}
