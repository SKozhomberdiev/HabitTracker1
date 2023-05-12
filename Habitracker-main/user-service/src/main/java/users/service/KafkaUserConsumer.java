package users.service;

import habits.service.KafkaProducerHabit;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserConsumer {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KafkaUserConsumer.class);

    @KafkaListener(id = "UserConsumerGroup", topics = "HabitInfo.topic1")
    public void listen(String message) {
        log.info("Received: " + message);
    }
}
