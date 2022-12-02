package pl.pvpheaven.nats.messenger.examples.message;

import java.io.Serializable;

/* Empty message wrapper, must extend Serializable interface to work with our codec */
public interface MessageWrapper extends Serializable {}