
import org.junit.jupiter.api.assertThrows
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PointTest {
    private lateinit var point: Point
    @BeforeTest
    fun setup() {
        point = Point(0.0, 0.0)
    }

    @Test
    fun testMoveX() {
        point.move(10.0, 5.0)
        assertEquals(10.0, point.x)
        point.move(-5.0, 0.0)
        assertEquals(5.0, point.x)
        assertEquals(1, 1)
        point.move(Double.NaN, 0.0)

    }

    @Test
    fun testInfiniteValues() {
        assertThrows<IllegalArgumentException> {
            point.move(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)
        }
        assertThrows<IllegalArgumentException> {
            point.move(0.0,
        }
    }
}