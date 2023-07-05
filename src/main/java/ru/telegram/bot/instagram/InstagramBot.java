package ru.telegram.bot.instagram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PreDestroy;

@Slf4j
@EnableAsync(proxyTargetClass = true)
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class InstagramBot {

    /**
     * Запускает приложение.
     *
     * @param args аргументы вызова (не используются)
     */
    public static void main(@Nullable final String[] args) {
        log.info("Запуск Spring-приложения");
        SpringApplication.run(InstagramBot.class);
    }

    /**
     * Обработка события готовность приложения.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void startingHandler() {
        log.info("Spring-приложение запущено");
    }

    /**
     * Обработка события - остановка приложения.
     */
    @PreDestroy
    public void destroy() {
        log.info("Spring-приложение останавливается");
    }
}
