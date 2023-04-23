package personal.xjl.jerrymouse.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myBenz")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Value("Benz")
    private String brand;
    @Value("E400")
    private String type;
    @Value("400")
    private int maxSpeed;
}
