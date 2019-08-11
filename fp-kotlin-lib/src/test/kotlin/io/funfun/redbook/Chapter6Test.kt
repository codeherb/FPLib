package io.funfun.redbook

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class Chapter6Test {

    @Test fun testRNG() {
        val rng = SimpleRng(42)
        val (num, newRng) = rng.nextInt()
        println("@## num = $num")
        val (num2, newRng2) = newRng.nextInt()
        println("@## num2 = $num2")
        assertNotEquals(newRng2, newRng)

        val (num3, newRng3) = rng.nextInt()
        assertEquals(num, num3)
    }

    @Test fun testNonNegativeInt() {
        val rng = SimpleRng(42)
        val (n1, newRng1) = nonNegativeInt(rng)
        println("@## num1 = $n1")
        val (n2, newRng2) = nonNegativeInt(newRng1)
        println("@## num2 = $n2")
        val (n3, newRng3) = nonNegativeInt(newRng2)
        println("@## num3 = $n3")
        val (n4, newRng4) = nonNegativeInt(newRng3)
        println("@## num4 = $n4")
        val (n5, newRng5) = nonNegativeInt(newRng4)
        println("@## num5 = $n5")

        assertTrue { n1 >= 0 && n1 <= Int.MAX_VALUE }
        assertTrue { n2 >= 0 && n2 <= Int.MAX_VALUE }
        assertTrue { n3 >= 0 && n3 <= Int.MAX_VALUE }
        assertTrue { n4 >= 0 && n4 <= Int.MAX_VALUE }
        assertTrue { n5 >= 0 && n5 <= Int.MAX_VALUE }
    }

    @Test fun testNextDouble() {
        val rng = SimpleRng(42)
        val (n1, newRng1) = double(rng)
        println("@## num1 = $n1")
        val (n2, newRng2) = double(newRng1)
        println("@## num2 = $n2")
        val (n3, newRng3) = double(newRng2)
        println("@## num3 = $n3")
        val (n4, newRng4) = double(newRng3)
        println("@## num4 = $n4")
        val (n5, newRng5) = double(newRng4)
        println("@## num5 = $n5")

        assertTrue { n1 >= 0 && n1 < 1 }
        assertTrue { n2 >= 0 && n2 < 1 }
        assertTrue { n3 >= 0 && n3 < 1 }
        assertTrue { n4 >= 0 && n4 < 1 }
        assertTrue { n5 >= 0 && n5 < 1 }
    }

    @Test fun testRndInts() {
        val (list, rng) = ints(3, SimpleRng(42))
        println("@## list = $list")
        assertEquals(3, list.size)
    }

    @Test fun testDouble3() {
        val (doubles ,rng) = double3(SimpleRng(35))
        assertTrue { doubles.first != doubles.second && doubles.second != doubles.third && doubles.first != doubles.third }
    }

    @Test fun testBoth() {
        val (p1, rng1) = randIntDouble(SimpleRng(35))
        println("@## p1 = $p1")
        val (p2, rng2) = randDoubleInt(SimpleRng(35))
        println("@## p2 = $p2")
        assert(p1 != null)
        assert(p2 != null)
    }

}