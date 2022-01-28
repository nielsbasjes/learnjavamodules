module experimentTest {
    requires experimentMain;

    requires org.junit.jupiter.api;
    requires com.esotericsoftware.kryo;

    opens nl.basjes.tests.stats to org.junit.platform.commons;
}