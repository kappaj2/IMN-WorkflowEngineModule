package za.co.tman.workflow.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import za.co.tman.workflow.enums.enumwrappers.PubSubMessageTypeDeserializer;
import za.co.tman.workflow.enums.enumwrappers.PubSubMessageTypeSerializer;


/**
 * The different message types that will be transmitted between the modules.
 * Each module can in turn have different message types, it create of Incident, update of Incident, etc.
 */
@JsonDeserialize(using = PubSubMessageTypeDeserializer.class)
@JsonSerialize(using = PubSubMessageTypeSerializer.class)
public enum PubSubMessageType {
    
    GENERIC("GenericMessage", "Generic string message."),
    INCIDENT("IncidentMessage", "Message used to create/update/close incidents."),
    LOGGING("LoggingMessage", "Message that must be logged to MongoDB");
    
    private String messageTypeCode;
    private String messageTypeDescription;
    
    private static final Map<String, PubSubMessageType> pubSubMessageTypeMap = new HashMap<>();

    static {
        Arrays.stream(PubSubMessageType.values()).forEach(messageType
            -> pubSubMessageTypeMap.put(messageType.getMessageTypeCode(), messageType));
    }
    
    PubSubMessageType(String messageTypeCode, String messageTypeDescription) {
        this.messageTypeCode = messageTypeCode;
        this.messageTypeDescription = messageTypeDescription;
    }
    
    public String getMessageTypeCode() {
        return messageTypeCode;
    }
    
    public String getMessageTypeDescription() {
        return messageTypeDescription;
    }
    
    public static PubSubMessageType findPubSubMessageType(String messageTypeCode) {
        return pubSubMessageTypeMap.get(messageTypeCode);
    }
}

