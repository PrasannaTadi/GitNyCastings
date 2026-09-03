package utilities;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static final Map<String, Object> scenarioData = new HashMap<>();

    public static void set(String key, Object value) {
        scenarioData.put(key, value);
    }

    public static Object get(String key) {
        return scenarioData.get(key);
    }
}
