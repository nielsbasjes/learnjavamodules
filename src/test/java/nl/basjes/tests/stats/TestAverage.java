package nl.basjes.tests.stats;

import nl.basjes.stats.Average;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAverage {

    private static final Logger LOG = LoggerFactory.getLogger(TestAverage.class);

    @Test
    void testAvg() throws NoSuchFieldException, IllegalAccessException {
        Average average = new Average();
        average.add(1);
        average.add(9);
        assertEquals(5, average.get());

//        assertEquals(10, average.sum);
//        assertEquals(2, average.count);

        Field sumField = average.getClass().getDeclaredField("sum");
        sumField.setAccessible(true);
        int sum = (int) sumField.get(average);
        assertEquals(10, sum);

        Field countField = average.getClass().getDeclaredField("count");
        countField.setAccessible(true);
        int count = (int) countField.get(average);
        assertEquals(2,  count);

        average.print();
        LOG.info("Average = {}", average);

    }

}
