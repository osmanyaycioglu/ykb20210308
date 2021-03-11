package com.training.micro;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify-sms-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify-exc",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify.sms"))
    @SendTo("notify-response-exc/notify.response")
    public String handleSMSMessage(final NotifyRequest str) {
        System.out.println("Received SMS : " + str);
        return "SMS Sent Successfully : " + str;
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify-email-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify-exc",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify.email"))
    @SendTo("notify-response-exc/notify.response")
    public String handleEMAILMessage(final NotifyRequest str) {
        System.out.println("Received EMAIL : " + str);
        return "EMAIL Sent Successfully : " + str;
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify-te-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify-topic-exc",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "notify.topic.email.#"))
    public void handleTEMAILMessage(final NotifyRequest str) {

        System.out.println("Received Topic EMAIL : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify-ts-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify-topic-exc",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "notify.topic.sms.#"))
    public void handleSEMAILMessage(final NotifyRequest str) {

        System.out.println("Received Topic SMS : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify-ta-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify-topic-exc",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "notify.topic.#"))
    public void handleAllTopicMessage(final NotifyRequest str) {

        System.out.println("Received ALL : " + str);
    }

}
