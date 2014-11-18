package edu.queueing.model.utils;

/**
 * @author GromHoll
 */
public class CheckUtils {

    public static void checkArgument(boolean condition, String message) {
        if (!condition) throw new IllegalArgumentException(message);
    }

}
