package pl.pvpheaven.nats.messenger.examples;

import io.nats.client.Options;
import pl.pvpheaven.nats.messenger.NatsClient;
import pl.pvpheaven.nats.messenger.NatsConnection;
import pl.pvpheaven.nats.messenger.NatsMessenger;
import pl.pvpheaven.nats.messenger.codec.NatsStringCodec;
import pl.pvpheaven.nats.messenger.examples.codec.MessageWrapperCodec;
import pl.pvpheaven.nats.messenger.examples.handler.SomeOtherWrappedMessageHandler;
import pl.pvpheaven.nats.messenger.examples.handler.WrappedMessageHandler;
import pl.pvpheaven.nats.messenger.examples.message.MessageWrapper;
import pl.pvpheaven.nats.messenger.examples.message.SomeOtherWrappedMessage;
import pl.pvpheaven.nats.messenger.examples.message.WrappedMessage;

import java.util.UUID;

final class NatsExampleMain {

    public static void main(String[] args) {

        final Options natsOptions = new Options.Builder()
                .server("nats://demo.nats.io:4222")
                .build();
        final NatsClient natsClient = NatsMessenger.create(natsOptions);
        final NatsConnection<MessageWrapper> natsConnection = natsClient.createConnection(new MessageWrapperCodec());

        final String uniqueTopic1 = UUID.randomUUID().toString(); /* Because we are using public nats demo server */
        natsConnection.subscribe(uniqueTopic1, new WrappedMessageHandler());
        natsConnection.subscribe(uniqueTopic1, new SomeOtherWrappedMessageHandler());

        final WrappedMessage wrappedMessage = new WrappedMessage("Test 1 passed!");
        final SomeOtherWrappedMessage someOtherWrappedMessage = new SomeOtherWrappedMessage(999);

        natsConnection.publish(uniqueTopic1, wrappedMessage);
        natsConnection.publish(uniqueTopic1, someOtherWrappedMessage);

        /* Using built-in string codec */
        final NatsConnection<String> natsStringCodecConnection = natsClient.createConnection(new NatsStringCodec());
        final String uniqueTopic2 = UUID.randomUUID().toString(); /* Because we are using public nats demo server */

        natsStringCodecConnection.subscribe(uniqueTopic2, System.out::println);
        natsStringCodecConnection.publish(uniqueTopic2, "Test 2 passed!");

    }

}