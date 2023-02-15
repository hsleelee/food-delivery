package food.delivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.delivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.delivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired LogRepository logRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_AlertToUser(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener AlertToUser : " + accepted + "\n\n");


        

        // Sample Logic //
        Log.alertToUser(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AlertToUser(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AlertToUser : " + rejected + "\n\n");


        

        // Sample Logic //
        Log.alertToUser(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_AlertToUser(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener AlertToUser : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        Log.alertToUser(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_AlertToUser(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener AlertToUser : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Log.alertToUser(event);
        

        

    }

}


