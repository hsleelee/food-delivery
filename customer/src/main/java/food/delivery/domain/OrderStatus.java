package food.delivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderStatus_table")
@Data
public class OrderStatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String customerId;
        private String foodId;
        private String storeId;
        private Integer qty;
        private String status;
        private Long orderId;


}
