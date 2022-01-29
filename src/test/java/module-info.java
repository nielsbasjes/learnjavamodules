open module tests.nl.basjes.jpms.experiment {
    requires transitive nl.basjes.jpms.experiment;

    requires com.esotericsoftware.kryo;

    requires org.slf4j;
    requires org.slf4j.simple;
    requires transitive org.junit.jupiter.engine;
    requires transitive org.junit.jupiter.api;
}