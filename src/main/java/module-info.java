module experimentMain {
    exports nl.basjes.stats;

    // Optional: Allow reflection by Kryo
    requires static com.esotericsoftware.kryo;
    opens nl.basjes.stats to com.esotericsoftware.kryo, experimentTest;
}