package cn.thoughtworks.school.application.usecases.notification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties
@Setter
@Getter
@NoArgsConstructor
public class Properties {
    private Map<String, String> notifications;
}
