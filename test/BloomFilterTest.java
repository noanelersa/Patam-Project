import Model.PTM1.BloomFilter;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloomFilterTest {

    @Test
    public void testContains() {
        BloomFilter bloomFilter = new BloomFilter(256,"MD5","SHA1");
        bloomFilter.add("dog");
        assertTrue(bloomFilter.contains("dog"));
    }

    @Test
    public void testNotContains() {
        BloomFilter bloomFilter = new BloomFilter(256,"MD5","SHA1");
        bloomFilter.add("dog");
        assertFalse(bloomFilter.contains("cat"));
    }

    @Test
    public void testWithNoData() {
        BloomFilter bloomFilter = new BloomFilter(256);
        assertFalse(bloomFilter.contains("cat"));
    }

    @Test
    public void testNull() {
        BloomFilter bloomFilter = new BloomFilter(256, "MD5", "SHA1");
        assertFalse(bloomFilter.contains(null));
    }

    @Test
    public void testEmptyString() {
        BloomFilter bloomFilter = new BloomFilter(256, "MD5");
        assertFalse(bloomFilter.contains(""));
    }
}
