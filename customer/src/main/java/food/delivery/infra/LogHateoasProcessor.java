package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class LogHateoasProcessor implements RepresentationModelProcessor<EntityModel<Log>>  {

    @Override
    public EntityModel<Log> process(EntityModel<Log> model) {

        
        return model;
    }
    
}
