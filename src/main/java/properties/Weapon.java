package properties;

import lombok.Data;

import java.util.List;

@Data
public class Weapon {
    private String name;
    private List<String> instances;
}
