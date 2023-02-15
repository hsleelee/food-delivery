package food.delivery.domain;

import food.delivery.domain.CookStarted;
import food.delivery.domain.Accepted;
import food.delivery.domain.Rejected;
import food.delivery.domain.CookFinished;
import food.delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;

    @PostUpdate
    public void onPostUpdate(){


        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }

    public void accept(){
        //
    }



    public static void orderInfoTransfer(OrderPlaced orderPlaced){

        /** Example 1:  new item  */
        StoreOrder storeOrder = new StoreOrder();
        
        storeOrder.setFoodId(orderPlaced.getFoodId());
        storeOrder.setPreference(orderPlaced.getPreference());
        storeOrder.setOrderId(orderPlaced.getId());
        storeOrder.setStatus(orderPlaced.getStatus());
        
        repository().save(storeOrder);


        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }
    public static void notifyOrderCancelled(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);
       */
      
        /** Example 2:  finding and process */
        
        repository().findByOrderId(orderCanceled.getId()).ifPresent(storeOrder->{
            
            storeOrder.setStatus(orderCanceled.getStatus());
            repository().save(storeOrder);
 
         });
       

        
    }


}
