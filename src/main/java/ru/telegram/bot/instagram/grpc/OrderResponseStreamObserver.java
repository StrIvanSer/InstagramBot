package ru.telegram.bot.instagram.grpc;

import br.com.rformagio.grpc.server.grpcserver.OrderResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;


import java.time.Instant;


@Slf4j
public class OrderResponseStreamObserver implements StreamObserver<OrderResponse> {

    @Override
    public void onNext(OrderResponse orderResponse) {
        log.info("пришел еще один ответ на стрим время получения {%s}".formatted(Instant.now()));
    }

    @Override
    public void onError(Throwable throwable) {
        log.warn("ошибочка");
    }

    @Override
    public void onCompleted() {
        log.info("я все)");
    }

}
