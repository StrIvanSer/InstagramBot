package ru.telegram.bot.instagram.events;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationEvent;
import ru.telegram.bot.instagram.model.InboundMessageEvent;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InboundMessageApplicationEvent extends ApplicationEvent {
    InboundMessageEvent inboundMessageEvent;

    public InboundMessageApplicationEvent(Object source, InboundMessageEvent inboundMessageEvent) {
        super(source);
        this.inboundMessageEvent = inboundMessageEvent;
    }

    public InboundMessageEvent getInboundMessageEvent() {
        return this.inboundMessageEvent;
    }
}