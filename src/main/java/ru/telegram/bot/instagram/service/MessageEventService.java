package ru.telegram.bot.instagram.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.bot.instagram.events.InboundMessageApplicationEvent;
import ru.telegram.bot.instagram.model.InboundMessageEvent;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageEventService {
    ApplicationEventPublisher applicationEventPublisher;

    public void inboundProcessing(Update update) {
        log.info("получено входящее сообщение");
        this.applicationEventPublisher.publishEvent(new InboundMessageApplicationEvent(this, new InboundMessageEvent(update)));
    }
}
