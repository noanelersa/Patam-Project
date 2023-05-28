import Model.PTM1.CacheManager;
import Model.PTM1.LRU;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CacheManagerTest {

    @Test
    public void testBasic() {
        CacheManager cacheManager = new CacheManager(100, new LRU());
        cacheManager.add("Noa");
        cacheManager.add("Talia");

        assertTrue(cacheManager.query("Noa"));
        assertTrue(cacheManager.query("Talia"));
    }

    @Test
    public void testNotExist() {
        CacheManager cacheManager = new CacheManager(100, new LRU());
        cacheManager.add("Noa");
        cacheManager.add("Talia");

        assertFalse(cacheManager.query("Moshe"));
    }

    @Test
    public void testNull() {
        CacheManager cacheManager = new CacheManager(100, new LRU());
        cacheManager.add("Noa");
        cacheManager.add("Talia");

        assertFalse(cacheManager.query(null));
    }

    @Test
    public void testEmpty() {
        CacheManager cacheManager = new CacheManager(100, new LRU());

        assertFalse(cacheManager.query(null));
    }
}
