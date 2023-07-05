package ru.telegram.bot.instagram.service.message.generator;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
@Component
@ConditionalOnProperty(prefix = "generator.default", name = "enable", havingValue = "true")
public class MessageDefault implements MessageGenerator {

    @Override
    public String generateMessage() {
        return "дефолт";
    }
}
