package pl.pvpheaven.nats.messenger.examples.handler;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.pvpheaven.nats.messenger.examples.message.MessageWrapper;
import pl.pvpheaven.nats.messenger.handler.NatsHandler;

@RequiredArgsConstructor
public abstract class AbstractMessageHandler<M extends MessageWrapper> implements NatsHandler<MessageWrapper> {

    private final Class<M> type;

    @Override @SuppressWarnings("unchecked") /* Because we don't care about this warning */
    public void onMessageReceive(MessageWrapper messageWrapper) {
        if (messageWrapper.getClass().isAssignableFrom(this.type)) this.handleMessage((M) messageWrapper);
    }

    public abstract void handleMessage(M message);

}