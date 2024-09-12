package procedures.example.mail_sender.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.log.LogMessage;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Message;

@Service
public class SenderService {

    private static final Log logger = LogFactory.getLog(SenderService.class);

    @RabbitListener(queues = "procedures")
    public Message consume(Message message)  {
        logger.info(LogMessage.format("[x] Received request for " + new String(message.getBody())));
        var response = "Email sent out";
        return new Message(response.getBytes());
    }
}
