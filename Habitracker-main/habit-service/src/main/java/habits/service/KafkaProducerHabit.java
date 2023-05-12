package habits.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KafkaProducerHabit {

    private final KafkaTemplate<String, String> template;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KafkaProducerHabit.class);

    public KafkaProducerHabit(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Scheduled(fixedDelay = 2000)
    public void sendFoo() {
        log.info("producing message to Kafka, topic=HabitInfo.topic1");
        this.template.send("HabitInfo.topic1", Instant.now().toString());
    }



    }

