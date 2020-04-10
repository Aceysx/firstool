package cn.thoughtworks.school.adapter.inbound.rest.resources.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class SettingsResource {

    @Value("${appContextPath}")
    private String appContextPath;

    @GetMapping("/settings")
    public Map<String, String> getSettings() {
        Map<String, String> result = new HashMap<>();

        result.put("appContextPath", appContextPath);
        return result;
    }

}
