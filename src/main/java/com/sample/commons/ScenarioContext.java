package com.sample.commons;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioContext {

    private static final Map<String, Object> data = new HashMap<>();

    public Object getData(String key) {
        return data.get(key);
    }

    public void saveData(String key, Object value) {
        data.put(key, value);
    }

}
