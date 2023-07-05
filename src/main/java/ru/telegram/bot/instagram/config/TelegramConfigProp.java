package ru.telegram.bot.instagram.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class TelegramConfigProp {
    private String webhookPath;
    private String botName;
    private String botToken;
}
