package za.co.tman.workflow.service.messaging;

import org.springframework.messaging.Message;


public interface IMMessageProcessor {
    
    void processMessageReceived(Message<?> message);

}
