package procedures.example.procedures_backend.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.log.LogMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    private static final Log logger = LogFactory.getLog(RabbitMQProducer.class);

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public boolean sendMessage(String email){
        try{
            var correlationId = UUID.randomUUID().toString();
            CorrelationData correlationData = new CorrelationData(correlationId);
            Message messageBytes = new Message(email.getBytes());
            Message request = rabbitTemplate.sendAndReceive(exchange, routingKey, messageBytes, correlationData);
            logger.info(LogMessage.format("[x] Received '" + new String(request.getBody()) + "'"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
