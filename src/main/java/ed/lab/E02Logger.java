package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    private final Map<String, Integer> lastPrinted;

    public E02Logger() {
        lastPrinted = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastPrinted.containsKey(message) || timestamp - lastPrinted.get(message) >= 10) {
            lastPrinted.put(message, timestamp);
            return true;
        }
        return false;
    }
}
