package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
    private Map<String, String> envHashMap;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String instanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String instanceAddress) {
        envHashMap = new HashMap<>();
        envHashMap.put("PORT", port);
        envHashMap.put("MEMORY_LIMIT", memoryLimit);
        envHashMap.put("CF_INSTANCE_INDEX", instanceIndex);
        envHashMap.put("CF_INSTANCE_ADDR", instanceAddress);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return this.envHashMap;
    }

}
