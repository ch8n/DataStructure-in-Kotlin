package linkedlist

import linkedlist.linear.linkedListOf
import linkedlist.linear.mutableLinkedListOf
import linkedlist.linear.toLinkedList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LinkedKtxTest {

    @Nested
    inner class `linkedListOf test` {

        @Test
        fun `creates new instance successfully`() {
            val linked = linkedListOf<Int>()
            assertAll(
                { assertEquals(linked.size, 0) },
                { assertNull(linked.firstOrNull) },
                { assertNull(linked.lastOrNull) },
            )
        }

        @Test
        fun `creates new instance with default primitive successfully`() {
            val linked = linkedListOf(10)
            println(linked)
            assertAll(
                { assertEquals(linked.size, 1) },
                { assertNotNull(linked.firstOrNull) },
                { assertEquals(linked.firstOrNull, 10) },
                { assertNotNull(linked.lastOrNull) },
                { assertEquals(linked.lastOrNull, 10) }
            )
        }

        @Test
        fun `creates new instance with default object successfully`() {
            data class Poo(val name: String = "poopoo")

            val foo = Poo()
            val linked = linkedListOf(foo)

            assertAll(
                { assertEquals(linked.size, 1) },
                { assertNotNull(linked.firstOrNull) },
                { assertNotNull(linked.lastOrNull) },
                { assertTrue(linked.firstOrNull is Poo) },
                { assertTrue(linked.lastOrNull is Poo) },
                // { assertEquals(linked.firstOrNull?.value?.name, foo.name) },
                // { assertEquals(linked.lastOrNull?.name, foo.name) }
            )
        }

        @Test
        fun `returns new instance on each invoke`() {
            val list1 = linkedListOf<Int>()
            val list2 = linkedListOf<Int>()
            assertEquals(list1.size, 0)
            assertEquals(list2.size, 0)
            assertNotEquals(list1, list2)
        }
    }

    @Nested
    inner class `mutablelinkedListOf test` {

        @Test
        fun `creates new instance successfully`() {
            val linked = mutableLinkedListOf<Int>()
            assertAll(
                { assertEquals(linked.size, 0) },
                { assertNull(linked.firstOrNull) },
                { assertNull(linked.lastOrNull) },
            )
        }

        @Test
        fun `creates new instance with default primitive successfully`() {
            val linked = mutableLinkedListOf<Int>(10)
            assertAll(
                { assertEquals(linked.size, 1) },
                { assertNotNull(linked.firstOrNull) },
                { assertEquals(linked.firstOrNull, 10) },
                { assertNotNull(linked.lastOrNull) },
                { assertEquals(linked.lastOrNull, 10) }
            )
        }

        @Test
        fun `creates new instance with default object successfully`() {
            data class Poo(val name: String = "poopoo")

            val foo = Poo()
            val linked = mutableLinkedListOf(foo)

            assertAll(
                { assertEquals(linked.size, 1) },
                { assertNotNull(linked.firstOrNull) },
                { assertNotNull(linked.lastOrNull) },
                { assertTrue(linked.firstOrNull is Poo) },
                { assertTrue(linked.lastOrNull is Poo) },
                // { assertEquals(linked.firstOrNull?.name, foo.name) },
                // { assertEquals(linked.lastOrNull?.name, foo.name) }
            )
        }

        @Test
        fun `returns new instance on each invoke`() {
            val list1 = mutableLinkedListOf<Int>()
            val list2 = mutableLinkedListOf<Int>()
            assertEquals(list1.size, 0)
            assertEquals(list2.size, 0)
            assertNotEquals(list1, list2)
        }
    }

    @Nested
    inner class `toLinkedList test` {
        @Test
        fun `list to linkedlist successfully`() {
            val list = mutableListOf(1, 2, 3, 4, 5, 6)
            val linked = list.toLinkedList()
            assertAll(
                { assertEquals(list.size, linked.size) },
                { assertEquals(list.first(), linked.firstOrNull) },
                { assertEquals(list.last(), linked.lastOrNull) },
                { assertNotEquals(list, linked) },
            )
        }
    }
}
