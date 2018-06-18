package za.co.tman.workflow.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class MessageImplementationCondition implements Condition {
    
    /**
     * TODO - Implement switching between Google PubSub, Kafka and possible RabbitMQ implementations.
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Boolean.parseBoolean(context.getEnvironment().getProperty("googlepubsub.enabled"));
    }
}
