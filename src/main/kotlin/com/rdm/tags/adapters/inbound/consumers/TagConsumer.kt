package com.rdm.tags.adapters.inbound.consumers

import com.rdm.tags.adapters.dtos.TagDto
import com.rdm.tags.application.domain.Tag
import com.rdm.tags.application.ports.TagServicePort
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.util.*

@Component
class TagConsumer(val tagServicePort: TagServicePort ) {

    @RabbitListener(queues = ["\${spring.rabbitmq.queue}"])
    fun listen(@Payload tagDto: TagDto){
       // var tag = Tag( UUID.randomUUID())
        System.out.println("Tag value: " + tagDto.toString())
    }
}