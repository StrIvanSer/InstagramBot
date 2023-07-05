package ru.telegram.bot.instagram.service.message.generator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class MessageHowAreYou implements MessageGenerator {

    @Override
    public String generateMessage() {
        return "как дела?";
    }
}