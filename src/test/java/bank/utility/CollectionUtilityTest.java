package bank.utility;

import com.bank.utility.CollectionUtility;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionUtilityTest {

    @Test
    public void nullSafeListInitializeShouldReturnEmptyListIfInputNull() {
        List<Object> actual = CollectionUtility.nullSafeListInitialize(null);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void nullSafeListInitializeShouldReturnListIfInputNotNull() {
        List<Integer> items = Arrays.asList(1, 2, 3);
        List<Integer> actual = CollectionUtility.nullSafeListInitialize(items);

        assertFalse(actual.isEmpty());
        assertEquals(3, actual.size());
    }
}