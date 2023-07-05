package ru.telegram.bot.instagram.service.message.generator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class MessageHello implements MessageGenerator {

    @Override
    public String generateMessage() {
        return "привет";
    }
}
