package food.delivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private Long orderId;
    private String payMethod;
    private Integer amount;
    private String status;
}


