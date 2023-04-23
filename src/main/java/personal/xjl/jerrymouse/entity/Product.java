package personal.xjl.jerrymouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String name;
    private float price;
    private int count;
}
