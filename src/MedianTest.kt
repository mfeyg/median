import org.junit.Assert.*
import org.junit.Test
import java.util.*

class MedianTest {
    @Test fun median() {
        assertEquals(3, median(listOf(1,2,3,4,5), emptyList()))
        assertEquals(3, median(listOf(1,2,3), listOf(4,5)))
        (1..5000).forEach {
            val l1 = Random().ints(Random().nextInt(5000).toLong(), 1, 40000).toArray().sorted()
            val l2 = Random().ints(Random().nextInt(5000).toLong(), 1, 40000).toArray().sorted()
            val m = (l1 + l2).sorted()[(l1.size + l2.size) / 2]
            assertEquals(median(l1, l2), m)
        }
    }
}