package ua.com.owu.demojavad2.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "reference-data")
public class ReferenceDataProperties {
    private List<String> raceTypes;
    private List<Weapon> weapons;
}
