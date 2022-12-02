package pl.pvpheaven.nats.messenger.examples.message;

import lombok.Data;

public final @Data class WrappedMessage implements MessageWrapper {
    private final String string;
}