package kt.rtuset.empty

import org.junit.Test
import kotlin.math.sqrt

/**
 * We define a set by its characteristic function
 */
typealias Set = (Int) -> Boolean

/**
 * NB!: You're allowed to use self-implemented Set functions as well
 * as `forAll()` in other function implementations
 */

    /**
    * If a set contains an element.
    */
    infix fun Set.contains(elem: Int): Boolean = this(elem)

    /**
     * Singleton set from one element
     */
    fun singletonSet(elem: Int): Set = {it == elem}

    /**
     * Union of the two sets
     */
    infix fun Set.union(set: Set): Set = {set(it) || this(it)}

    /**
     * Intersection of the two sets
     */
    infix fun Set.intersect(set: Set): Set = {set(it) && this(it)}
    /**
     * Difference of two given sets
     */
    infix fun Set.diff(set: Set): Set = {this(it) && !set(it)}

    /**
     * Filter
     */
    fun Set.filter(predicate: (Int) -> Boolean): Set = {this(it) == predicate(it)}

    /** =========== For brave enough =========== */

    const val BOUND = 1000

    /**
     * if  all bounded integers within s satisfy p
     */
    fun Set.forAll(predicate: (Int) -> Boolean): Boolean {
        tailrec fun iterate(a: Int): Boolean =
                when {
                    a > BOUND -> true
                    invoke(a) and predicate(a).not() -> false
                    else -> iterate(a + 1)
                }
        return iterate(-BOUND)
    }

    infix fun Set.exists(predicate: (Int) -> Boolean): Boolean = TODO()

    fun Set.map(transform: (Int) -> Int): Set = TODO()

    val Set.contents: String
    get() = TODO()

    class RtuSetTest {

        @Test
        fun `Set contains a given element`() {
            val set: Set = { it == 1 }
            assert(set contains 1)
        }

        @Test
        fun `Singleton set contains a given element`() {
            val set: Set = singletonSet(2)
            assert(set contains 2)
        }

        @Test
        fun `Union set contains both elements`() {
            val set = singletonSet(1) union singletonSet(2)
            assert(set contains 1)
            assert(set contains 2)
        }

        @Test
        fun `Intersect set works correctly`() {
            val set = singletonSet(1) union singletonSet(2) intersect singletonSet(1)
            assert(set contains 1)
            assert((set contains 2).not())
        }

        @Test
        fun `Diff set works correctly`() {
            val set = singletonSet(1) union singletonSet(2) union singletonSet(3) diff singletonSet(2)
            assert(set contains 1)
            assert(set contains 3)
            assert((set contains 2).not())
        }

        @Test
        fun `Filter set works correctly`() {
            val set = (singletonSet(1) union singletonSet(2)).filter { it == 1 }
            assert(set contains 1)
            assert((set contains 2).not())
        }

        @Test
        fun `Exists set works correctly`() {
            val set = singletonSet(1) union singletonSet(2)
            assert(set.exists { it == 1 })
            assert(set.exists { it == 2 })
        }

        @Test
        fun `Map set works correctly`() {
            val set = singletonSet(1).map { it * -1 }
            assert(set contains -1)
        }

        @Test
        fun `For all set works correctly`() {
            val set = singletonSet(2) union singletonSet(4) union singletonSet(6)
            assert(set.forAll { it % 2 == 0 })
            assert((set.forAll { sqrt(it.toFloat()).toInt() % 2 == 0 }).not())
        }

        @Test
        fun `Content works correctly`() {
            val set = singletonSet(1) union singletonSet(2)
            assert(set.contents == "{1,2}")
        }
    }