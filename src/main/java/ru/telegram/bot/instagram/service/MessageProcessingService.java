package ru.telegram.bot.instagram.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.telegram.bot.instagram.config.InstaTelegramBot;
import ru.telegram.bot.instagram.events.InboundMessageApplicationEvent;
import ru.telegram.bot.instagram.grpc.AddressClientService;
import ru.telegram.bot.instagram.service.message.generator.MessageGenerator;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageProcessingService {
    InstaTelegramBot instaTelegramBot;
    List<MessageGenerator> messageGeneratorList;
    AddressClientService addressClientService;

    @Async
    @EventListener
    public void inboundMessageProcessing(@NotNull InboundMessageApplicationEvent inboundMessageApplicationEvent) {
        val update = inboundMessageApplicationEvent.getInboundMessageEvent().getUpdate();
        val user = update.getMessage().getFrom();
        log.info("получено событие от пользователя [name={}, lastName={}, userName={}]",
                user.getFirstName(), user.getLastName(), user.getUserName());
        if (update.getMessage().getText().equalsIgnoreCase("как дела")) {
            instaTelegramBot.sendMessage(update.getMessage().getChatId().toString(), "все отлично, я даже не пукаю)))ЫЫЫЫ");
        } else if (update.getMessage().getText().equalsIgnoreCase("что делаешь?")) {
            instaTelegramBot.sendMessage(update.getMessage().getChatId().toString(), "я с ВАМИ общаюсь, пук пук =))))");
        } else {
            List<String> strings = messageGeneratorList.stream().map(MessageGenerator::generateMessage).toList();
            instaTelegramBot.sendMessage(update.getMessage().getChatId().toString(), String.join(", ", strings));
        }
        var address = addressClientService.getAddress("13960000");
        addressClientService.getAddress2();
    }
}
