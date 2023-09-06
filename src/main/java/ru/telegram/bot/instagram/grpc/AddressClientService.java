package ru.telegram.bot.instagram.grpc;

import br.com.rformagio.grpc.server.grpcserver.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AddressClientService {

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9095)
            .usePlaintext()
            .build();

//    ECommerceServiceGrpc.ECommerceServiceStub clientStub = ECommerceServiceGrpc.newStub(channel);


    public AddressResponse getAddress(String cep) {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9095)
//                .usePlaintext()
//                .build();
        CepServiceGrpc.CepServiceBlockingStub stub = CepServiceGrpc.newBlockingStub(this.channel);
        AddressResponse addressResponse = stub.getAddress(AddressRequest.newBuilder()
                .setCep(cep)
                .build());
//        channel.shutdown();
        return addressResponse;
    }

    public void getAddress2() {
        OrderRequest ebook = OrderRequest.newBuilder().setOrderCategory(Category.ELECTRONICS).build();
        ECommerceServiceGrpc.ECommerceServiceStub clientStub = ECommerceServiceGrpc.newStub(channel);
        clientStub.placeOrder(ebook, new OrderResponseStreamObserver());
    }
}
