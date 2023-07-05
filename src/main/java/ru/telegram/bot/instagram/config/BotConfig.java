package ru.telegram.bot.instagram.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@Setter
@Getter
@Configuration
public class BotConfig {

    @Bean
    public SetWebhook setWebhookInstance(TelegramConfigProp telegramConfigProp) {
        return SetWebhook.builder().url(telegramConfigProp.getWebhookPath()).build();
    }

    @Bean
    public InstaTelegramBot instaTelegramBot(SetWebhook setWebhook, TelegramConfigProp telegramConfigProp) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        InstaTelegramBot mySuperInstaTelegramBot = new InstaTelegramBot(setWebhook, telegramBotsApi);
        mySuperInstaTelegramBot.setBotUserName(telegramConfigProp.getBotName());
        mySuperInstaTelegramBot.setBotToken(telegramConfigProp.getBotToken());
        mySuperInstaTelegramBot.setWebHookPath(telegramConfigProp.getWebhookPath());
        return mySuperInstaTelegramBot;
    }
}
