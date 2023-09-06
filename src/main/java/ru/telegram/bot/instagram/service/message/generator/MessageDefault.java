package ru.telegram.bot.instagram.service.message.generator;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name = "generator.default.enable", havingValue = "true")
public class MessageDefault implements MessageGenerator {

    @Override
    public String generateMessage() {
        return "дефолт";
    }
}
