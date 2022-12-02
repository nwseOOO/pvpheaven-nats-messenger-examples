package pl.pvpheaven.nats.messenger.examples.codec;

import lombok.SneakyThrows;
import pl.pvpheaven.nats.messenger.codec.NatsCodec;
import pl.pvpheaven.nats.messenger.examples.message.MessageWrapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* You should somehow deal with exceptions thrown in the methods */
public final class MessageWrapperCodec implements NatsCodec<MessageWrapper> {

    @Override @SneakyThrows
    public MessageWrapper decodeValue(byte[] byteArray) {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (MessageWrapper) objectInputStream.readObject();
    }

    @Override @SneakyThrows
    public byte[] encodeValue(MessageWrapper value) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(value);
        return byteArrayOutputStream.toByteArray();
    }

}