package pl.pvpheaven.nats.messenger.examples.message;

import lombok.Data;

public final @Data class SomeOtherWrappedMessage implements MessageWrapper {
    private final int integer;
}