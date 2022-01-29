//@SuppressWarnings({ "exports", "requires-automatic", "requires-transitive-automatic" })
module nl.basjes.jpms.experiment {
    exports nl.basjes.stats;

    // Optional: Allow reflection by Kryo
    requires static com.esotericsoftware.kryo;
    requires org.slf4j;
    opens nl.basjes.stats to com.esotericsoftware.kryo, tests.nl.basjes.jpms.experiment;
}