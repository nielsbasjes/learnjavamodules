package nl.basjes.stats;

import com.esotericsoftware.kryo.Kryo;
import org.slf4j.Logger;

import java.util.Objects;

public class Average {
    private int sum;
    private int count;

    public Average() {
        this.sum = 0;
        this.count = 0;
    }

    public void add(int extra) {
        sum += extra;
        count++;
    }

    public double get(){
        return ((double) sum)/count;
    }

    /**
     * This is used to configure the provided Kryo instance if Kryo serialization is desired.
     * The expected type here is Object because otherwise the Kryo library becomes
     * a mandatory dependency on any project that uses this.
     * @param kryoInstance The instance of com.esotericsoftware.kryo.Kryo that needs to be configured.
     */
    public static void configureKryo(Object kryoInstance) {
        Kryo kryo = (Kryo) kryoInstance;
        kryo.register(Average.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Average)) return false;
        Average average = (Average) o;
        return sum == average.sum && count == average.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, count);
    }

    @Override
    public String toString() {
        return "Average[" + sum + "/" + count + "]=" + get();
    }

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Average.class);

    public void print() {
        LOG.info("PRINTED: {}", this);
    }

}
