package com.rdm.tags.adapters.inbound.consumers

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaTopicConsumer {

    companion object Configs{
       const val KAFKA_TOPIC = "tag-topic"
       const val KAFKA_GROUP = "tag-topic-gr"
    }

    @KafkaListener(topics = [KAFKA_TOPIC], groupId = KAFKA_GROUP)
    fun listen(messages: List<String>){
        System.out.println("Thread ${Thread.currentThread().getId()} Message value: ${messages}")
    }
}