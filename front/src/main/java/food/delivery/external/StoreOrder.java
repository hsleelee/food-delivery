package food.delivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class StoreOrder {

    private Long id;
    private String foodId;
    private String preference;
    private Long orderId;
    private String status;
}


