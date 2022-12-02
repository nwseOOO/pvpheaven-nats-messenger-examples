package pl.pvpheaven.nats.messenger.examples.handler;

import pl.pvpheaven.nats.messenger.examples.message.WrappedMessage;

public final class WrappedMessageHandler extends AbstractMessageHandler<WrappedMessage> {

    public WrappedMessageHandler() {
        super(WrappedMessage.class);
    }

    @Override
    public void handleMessage(WrappedMessage message) {
        System.out.println(message.getString());
    }

}