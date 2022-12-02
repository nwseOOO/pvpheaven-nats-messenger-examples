package pl.pvpheaven.nats.messenger.examples.handler;

import pl.pvpheaven.nats.messenger.examples.message.SomeOtherWrappedMessage;

public final class SomeOtherWrappedMessageHandler extends AbstractMessageHandler<SomeOtherWrappedMessage> {

    public SomeOtherWrappedMessageHandler() {
        super(SomeOtherWrappedMessage.class);
    }

    @Override
    public void handleMessage(SomeOtherWrappedMessage message) {
        System.out.println(message.getInteger());
    }

}