package ru.telegram.bot.instagram.config;


import lombok.Setter;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Setter
public class InstaTelegramBot extends SpringWebhookBot {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    public InstaTelegramBot(SetWebhook webhook, TelegramBotsApi telegramBotsApi) {
        super(webhook);
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    public void sendMessage(String chatId, String message) {
        try {
            this.execute(new SendMessage(chatId, message));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
