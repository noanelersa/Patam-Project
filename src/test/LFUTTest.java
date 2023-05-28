import Model.PTM1.LFU;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LFUTTest {

    @Test
    public void testBasicLFU() {
        LFU lfu = new LFU();
        lfu.add("amit");
        lfu.add("amit");
        lfu.add("amit");
        lfu.add("amit");
        lfu.add("bar");
        lfu.add("coral");
        lfu.add("coral");
        lfu.add("coral");
        lfu.add("coral");

        assertEquals("bar", lfu.remove());
    }

    @Test
    public void testNullLFU() {
        LFU lfu = new LFU();
        lfu.add("amit");
        lfu.add(null);
        lfu.add(null);
        lfu.add(null);


        assertEquals("amit", lfu.remove());
    }

    @Test
    public void testEmptyLFU() {
        LFU lfu = new LFU();
        assertNull(lfu.remove());
}


}