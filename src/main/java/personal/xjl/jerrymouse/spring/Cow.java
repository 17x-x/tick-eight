package personal.xjl.jerrymouse.spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("myNMW")
@Data
public class Cow {
    @Value("NiuMoWang")
    private String name;
    @Value("500")
    private int weight ;


}
