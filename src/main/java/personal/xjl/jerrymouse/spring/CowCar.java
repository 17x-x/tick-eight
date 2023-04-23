package personal.xjl.jerrymouse.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myNMWC")
@Data
public class CowCar {
    @Autowired
    @Qualifier("myNMW")
    private Cow cow;
    @Value("3")
    private int wheel;
}
