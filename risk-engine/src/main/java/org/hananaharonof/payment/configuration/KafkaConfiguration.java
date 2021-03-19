package org.hananaharonof.payment.configuration;

import java.util.List;
import org.hananaharonof.payment.kafka.model.KafkaTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean("messageTopics")
    public List<String> messageTopics() {
        return List.of(KafkaTopic.RISK_ENGINE_IN.getTopicName());
    }

    @Bean("messageGroup")
    public String messageGroup(@Value("spring.kafka.consumer.group-id") String groupId) {
        return groupId;
    }

}
