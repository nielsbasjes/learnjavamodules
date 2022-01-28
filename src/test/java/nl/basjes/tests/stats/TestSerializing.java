package nl.basjes.tests.stats;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.ByteBufferOutput;
import nl.basjes.stats.Average;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSerializing {

    byte[] serialize(Average uaa) {
        Kryo kryo             = new Kryo();
        Average.configureKryo(kryo);

        // For debugging
        kryo.setRegistrationRequired(true);
        kryo.setWarnUnregisteredClasses(true);

        ByteBufferOutput byteBufferOutput = new ByteBufferOutput(1_000_000, -1);
        kryo.writeClassAndObject(byteBufferOutput, uaa);

        ByteBuffer buf = byteBufferOutput.getByteBuffer();
        byte[] arr = new byte[buf.position()];
        buf.rewind();
        buf.get(arr);

        return arr;
    }

    Average deserialize(byte[] bytes) {
        Kryo            kryo            = new Kryo();
        Average.configureKryo(kryo);

        ByteBufferInput byteBufferInput = new ByteBufferInput(bytes);
        return (Average) kryo.readClassAndObject(byteBufferInput);
    }

    @Test
    void testSerializing() {
        Average average = new Average();
        average.add(1);
        average.add(9);
        assertEquals(5, average.get());

        byte[] bytes = serialize(average);
        Average result = deserialize(bytes);
        assertEquals(5, result.get());
        assertEquals(average, result);
    }
    
}
