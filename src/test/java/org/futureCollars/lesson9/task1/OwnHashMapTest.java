package org.futureCollars.lesson9.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class OwnHashMapTest {
    @Test
    public void shouldDisplayValueForEnteredKey() {
        OwnMap map = new OwnHashMap();
        assertTrue(map.put("Poland", "Warsaw"));
        assertEquals("Warsaw", map.get("Poland"));
    }

    @Test
    public void testContainsKey() {
        OwnMap map = new OwnHashMap();
        map.put("Poland", "Warsaw");
        assertTrue(map.containsKey("Poland"));
        assertFalse(map.containsKey("Germany"));
    }

    @Test
    public void testContainsValue() {
        OwnMap map = new OwnHashMap();
        map.put("Poland", "Warsaw");
        assertTrue(map.containsValue("Warsaw"));
        assertFalse(map.containsValue("Berlin"));
    }

    @Test
    public void shouldRemoveKeyAndDisplayNullIfKeyIsEmpty() {
        OwnMap map = new OwnHashMap();
        map.put("Poland", "Warsaw");
        assertEquals("Warsaw", map.remove("Poland"));
        assertNull(map.get("Poland"));
    }
}
