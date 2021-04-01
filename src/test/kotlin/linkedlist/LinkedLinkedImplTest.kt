package linkedlist

import linkedlist.linear.linkedListOf
import linkedlist.linear.mutableLinkedListOf
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LinkedLinkedImplTest {

    @BeforeEach
    fun setUp() {
    }

    @Nested
    inner class `LinkedList test` {

        @Test
        fun `empty list has first null`() {
            val linked = linkedListOf<Int>()
            assertNull(linked.firstOrNull)
            println(linked.toString())
        }

        @Test
        fun `empty list has last null`() {
            val linked = linkedListOf<Int>()
            assertNull(linked.lastOrNull)
            println(linked.toString())
        }



        @Test
        fun `adding default item list get inserted correctly`() {
            val linked = linkedListOf<Int>(10, 20, 30, 40, 50)
            assertAll(
                { assertEquals(linked.size, 5) },
                { assertNotNull(linked.firstOrNull) },
                { assertNotNull(linked.lastOrNull) },
                { assertEquals(linked.firstOrNull, 10) },
                { assertEquals(linked.lastOrNull, 50) }
            )
            println(linked.toString())
        }

        @Test
        fun `default item list has first and last are same`() {
            val linked = linkedListOf<Int>(10)
            assertAll(
                { assertNotNull(linked.lastOrNull) },
                { assertEquals(linked.lastOrNull, 10) },
                { assertEquals(linked.lastOrNull, linked.firstOrNull) },
            )
            println(linked.toString())
        }

        @Test
        fun `linked list is empty check`() {
            val emptylist = linkedListOf<Int>()
            val filledList = linkedListOf<Int>(1, 2, 3)
            assertAll(
                { assertEquals(emptylist.size, 0) },
                { assertEquals(filledList.size, 3) },
                { assertTrue(emptylist.isEmpty()) },
                { assertFalse(filledList.isEmpty()) },
            )
        }

        @Test
        fun `linked list get item at index from filled list throws error`() {
            val filledList = linkedListOf<Int>(1, 2, 3)
            assertAll(
                { assertEquals(filledList.size, 3) },
                { assertEquals(filledList.get(0), 1) },
                { assertEquals(filledList.get(1), 2) },
                { assertEquals(filledList.get(2), 3) },
                {
                    assertThrows<IndexOutOfBoundsException> {
                        filledList.get(4)
                    }
                },
                {
                    assertThrows<IndexOutOfBoundsException> {
                        filledList.get(-1)
                    }
                }
            )
        }

        @Test
        fun `linked list get item at index from empty list throws error`() {
            val emptylist = linkedListOf<Int>()

            assertAll(
                { assertEquals(emptylist.size, 0) },
                {
                    assertThrows<IndexOutOfBoundsException> {
                        emptylist.get(0)
                    }
                }
            )
        }
    }

    @Nested
    inner class `Mutable LinkedList test` {

        @Test
        fun `empty list has first null`() {
            val linked = mutableLinkedListOf<Int>()
            assertNull(linked.firstOrNull)
            println(linked.toString())
        }

        @Test
        fun `adding default item list get inserted correctly`() {
            val linked = mutableLinkedListOf<Int>(10, 20, 30, 40, 50)
            assertAll(
                { assertEquals(linked.size, 5) },
                { assertNotNull(linked.firstOrNull) },
                { assertNotNull(linked.lastOrNull) },
                { assertEquals(linked.firstOrNull, 10) },
                { assertEquals(linked.lastOrNull, 50) },
            )
            println(linked.toString())
        }

        @Test
        fun `empty list has last null`() {
            val linked = mutableLinkedListOf<Int>()
            assertNull(linked.lastOrNull)
            println(linked.toString())
        }

        @Test
        fun `default item list has first and last are same`() {
            val linked = mutableLinkedListOf<Int>(10)
            assertAll(
                { assertNotNull(linked.lastOrNull) },
                { assertEquals(linked.lastOrNull, 10) },
                { assertEquals(linked.lastOrNull, linked.firstOrNull) }
            )
            println(linked.toString())
        }
    }

    @Nested
    inner class InsertLinkedListTest {

        @Nested
        inner class `InsertFirst Test` {

            @Test
            fun `add one item to empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.insertFirst(10)
                assertAll(
                    { assertEquals(linkedList.size, 1) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 10) },
                    { assertEquals(linkedList.lastOrNull, 10) }
                )
            }

            @Test
            fun `add two item to empty list`() {
                val linkedList = mutableLinkedListOf<Int>(10)
                linkedList.insertFirst(20)
                assertAll(
                    { assertEquals(linkedList.size, 2) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 20) },
                    { assertEquals(linkedList.lastOrNull, 10) }
                )
            }

            @Test
            fun `add object item to empty list`() {
                data class Pokemon(val name: String = "pokemon")

                val poke = Pokemon()
                val linkedList = mutableLinkedListOf<Pokemon>()
                linkedList.insertFirst(poke)

                assertAll(
                    { assertEquals(linkedList.size, 1) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, poke) },
                    { assertEquals(linkedList.lastOrNull, poke) }
                )
            }

            @Test
            fun `var in linkedList is free from mutation`() {
                var number = "test"
                val linkedList = mutableLinkedListOf(number)

                number = "best"
                assertAll(
                    { assertEquals(linkedList.size, 1) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, "test") },
                    { assertEquals(linkedList.lastOrNull, "test") }
                )
            }
        }

        @Nested
        inner class `InsertLast Test` {

            @Test
            fun `insert last item to empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.insertLast(10)
                assertAll(
                    { assertEquals(linkedList.size, 1) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 10) },
                    { assertEquals(linkedList.lastOrNull, 10) }
                )
            }

            @Test
            fun `add two item at last of list`() {
                val linkedList = mutableLinkedListOf(10)
                linkedList.insertLast(20)
                assertAll(
                    { assertEquals(linkedList.size, 2) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 10) },
                    { assertEquals(linkedList.lastOrNull, 20) }
                )
            }

            @Test
            fun `add object item to empty list`() {
                data class Pokemon(val name: String = "pokemon")

                val poke1 = Pokemon()
                val poke2 = Pokemon(name = "poke2")
                val linkedList = mutableLinkedListOf<Pokemon>()
                linkedList.insertLast(poke1)
                linkedList.insertLast(poke2)

                assertAll(
                    { assertEquals(linkedList.size, 2) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, poke1) },
                    { assertEquals(linkedList.lastOrNull, poke2) }
                )
            }

            @Test
            fun `var in linkedList is free from mutation`() {
                val linkedList = mutableLinkedListOf("ok")
                var test = "test"
                linkedList.insertLast(test)
                test = "best"
                assertAll(
                    { assertEquals(linkedList.size, 2) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, "ok") },
                    { assertEquals(linkedList.lastOrNull, "test") }
                )
            }
        }

        @Nested
        inner class `InsertAt index Test` {

            @Test
            fun `insert at pos 0 in empty list`() {
                val linked = mutableLinkedListOf<Int>()
                linked.insertAt(0, 10)

                Assertions.assertAll(
                    { assertEquals(linked.size, 1) },
                    { assertEquals(linked.firstOrNull, 10) },
                    { assertEquals(linked.lastOrNull, 10) },
                )
                println(linked.toString())
            }

            @Test
            fun `insert at pos 0 in filled list`() {
                val linked = mutableLinkedListOf<Int>(1, 2, 3, 4)
                linked.insertAt(0, 10)

                Assertions.assertAll(
                    { assertEquals(linked.size, 5) },
                    { assertEquals(linked.firstOrNull, 10) },
                    { assertEquals(linked.lastOrNull, 4) },
                )
                println(linked.toString())
            }

            @Test
            fun `insert at last in filled list`() {
                val linked = mutableLinkedListOf<Int>(1, 2, 3, 4)
                linked.insertAt(linked.size - 1, 10)

                Assertions.assertAll(
                    { assertEquals(linked.size, 5) },
                    { assertEquals(linked.firstOrNull, 1) },
                    { assertEquals(linked.lastOrNull, 10) },
                )
                println(linked.toString())
            }

            @Test
            fun `insert at pos 1 in empty list throws IndexOutOfBound`() {
                val linked = mutableLinkedListOf<Int>()

                assertThrows<IndexOutOfBoundsException>() {
                    linked.insertAt(1, 10)
                }
                println(linked.toString())
            }

            @Test
            fun `insert at pos invalid position in list throws IndexOutOfBound`() {
                val linked = mutableLinkedListOf<Int>(2)

                assertThrows<IndexOutOfBoundsException>() {
                    linked.insertAt(-1, 10)
                }
                println(linked.toString())
            }
        }

        @Nested
        inner class `InsertAll Test` {

            @Test
            fun `insert empty linkedlist into empty linkedList`() {
                val list1 = mutableLinkedListOf<Int>()
                val list2 = linkedListOf<Int>()
                list1.insertAll(list2)

                Assertions.assertAll(
                    { assertEquals(list1.size, 0) },
                    { assertNull(list1.firstOrNull) },
                    { assertNull(list1.lastOrNull) }
                )
                println(list1.toString())
            }

            @Test
            fun `insert filled linkedlist into empty linkedList`() {
                val list1 = mutableLinkedListOf<Int>()
                val list2 = linkedListOf<Int>(1, 2, 3)
                list1.insertAll(list2)

                Assertions.assertAll(
                    { assertEquals(list1.size, 3) },
                    { assertNotNull(list1.firstOrNull) },
                    { assertNotNull(list1.lastOrNull) },
                    { assertEquals(list1.firstOrNull, 1) },
                    { assertEquals(list1.lastOrNull, 3) },
                )
                println(list1.toString())
            }

            @Test
            fun `insert empty linkedlist into filled linkedList`() {
                val list1 = linkedListOf<Int>()
                val list2 = mutableLinkedListOf(1, 2, 3)
                list2.insertAll(list1)

                Assertions.assertAll(
                    { assertEquals(list2.size, 3) },
                    { assertNotNull(list2.firstOrNull) },
                    { assertNotNull(list2.lastOrNull) },
                    { assertEquals(list2.firstOrNull, 1) },
                    { assertEquals(list2.lastOrNull, 3) },
                )
                println(list1.toString())
            }

            @Test
            fun `insert filled linkedlist into filled linkedList`() {
                val list1 = linkedListOf<Int>(5, 6, 7)
                val list2 = mutableLinkedListOf(1, 2, 3)
                list2.insertAll(list1)

                Assertions.assertAll(
                    { assertEquals(list2.size, 6) },
                    { assertNotNull(list2.firstOrNull) },
                    { assertNotNull(list2.lastOrNull) },
                    { assertEquals(list2.firstOrNull, 1) },
                    { assertEquals(list2.lastOrNull, 7) },
                )
                println(list2.toString())
            }
        }
    }

    @Nested
    inner class DeleteLinkedListTest {

        @Nested
        inner class `Delete first test` {
            @Test
            fun `delete one item to empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.deleteFirst()
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `delete one item to make a empty list`() {
                val linkedList = mutableLinkedListOf<Int>(1)
                linkedList.deleteFirst()
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `delete one item to filled list`() {
                val linkedList = mutableLinkedListOf<Int>(1, 2, 3)
                linkedList.deleteFirst()
                assertAll(
                    { assertEquals(linkedList.size, 2) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 2) },
                    { assertEquals(linkedList.lastOrNull, 3) }
                )
            }
        }

        @Nested
        inner class `Delete last test` {

            @Test
            fun `delete last item of empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.deleteLast()
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `delete last item from filled list to make list empty`() {
                val linkedList = mutableLinkedListOf<Int>(1)
                linkedList.deleteLast()
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `delete last item to filled list`() {
                val linkedList = mutableLinkedListOf<Int>(1, 2, 3)
                linkedList.deleteLast()
                assertAll(
                    { assertEquals(linkedList.size, 2) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 1) },
                    { assertEquals(linkedList.lastOrNull, 2) }
                )
            }
        }

        @Nested
        inner class `Delete at index test` {

            @Test
            fun `delete item at 0 of empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.deleteAt(0)
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `delete item at invalid index -1 of empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                assertThrows<IndexOutOfBoundsException> {
                    linkedList.deleteAt(-1)
                }
            }

            @Test
            fun `delete item at invalid index 5 of list empty`() {
                val linkedList = mutableLinkedListOf<Int>(1)
                assertThrows<IndexOutOfBoundsException> {
                    linkedList.deleteAt(5)
                }
            }

            @Test
            fun `delete item at index 0 to make list empty`() {
                val linkedList = mutableLinkedListOf<Int>(1)
                linkedList.deleteAt(0)
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) },
                )
            }

            @Test
            fun `delete item at index 3 from filled list`() {
                val linkedList = mutableLinkedListOf<Int>(1, 2, 3, 4, 5)
                linkedList.deleteAt(3)
                println(linkedList)
                assertAll(
                    { assertEquals(linkedList.size, 4) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 1) },
                    { assertEquals(linkedList.lastOrNull, 5) },
                )
            }
        }

        @Nested
        inner class `Delete element test` {

            @Test
            fun `delete element from empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.delete(0)
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `delete element to make filled list empty`() {
                val linkedList = mutableLinkedListOf<Int>(0)
                linkedList.delete(0)
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `delete element from filled list`() {
                val linkedList = mutableLinkedListOf<Int>(1, 2, 3, 4, 5)
                linkedList.deleteAt(3)
                println(linkedList)
                assertAll(
                    { assertEquals(linkedList.size, 4) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 1) },
                    { assertEquals(linkedList.lastOrNull, 5) },
                )
            }
        }
    }

    @Nested
    inner class UpdateLinkedListTest {

        @Nested
        inner class `Replace item test` {

            @Test
            fun `replace item at any index from empty list throws error`() {

                val linked = mutableLinkedListOf<Int>()
                assertAll(
                    {
                        assertThrows<IndexOutOfBoundsException> {
                            linked.replace(0, 1)
                        }
                    },
                    {
                        assertThrows<IndexOutOfBoundsException> {
                            linked.replace(5, 1)
                        }
                    },
                    {
                        assertThrows<IndexOutOfBoundsException> {
                            linked.replace(100, 1)
                        }
                    },
                    { assertEquals(linked.size, 0) },
                )
            }

            @Test
            fun `replace item in filled list at invalid position throw error`() {

                val linked = mutableLinkedListOf<Int>(1, 2, 3)
                assertAll(
                    {
                        assertThrows<IndexOutOfBoundsException> {
                            linked.replace(-5, 1)
                        }
                    },
                    {
                        assertThrows<IndexOutOfBoundsException> {
                            linked.replace(5, 1)
                        }
                    },
                    { assertEquals(linked.size, 3) },
                )
            }

            @Test
            fun `replace item in valid position updates the value in filled list`() {
                val linked = mutableLinkedListOf<Int>(1, 2, 3)
                linked.replace(0, 5)
                linked.replace(2, 5)
                println(linked)
                assertAll(
                    { assertEquals(linked.size, 3) },
                    { assertEquals(linked.get(0), 5) },
                    { assertEquals(linked.get(2), 5) },
                )
            }
        }

        @Nested
        inner class `Reverse linked list` {
            @Test
            fun `reverse element from empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.reverse()
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `reverse element of make filled list with 1 item`() {
                val linkedList = mutableLinkedListOf<Int>(0)
                linkedList.reverse()
                assertAll(
                    { assertEquals(linkedList.size, 1) },
                    { assertEquals(linkedList.firstOrNull, 0) },
                    { assertEquals(linkedList.lastOrNull, 0) },
                )
            }

            @Test
            fun `reverse element from filled list`() {
                val linkedList = mutableLinkedListOf<Int>(1, 2, 3, 4)
                linkedList.reverse()
                println(linkedList)
                assertAll(
                    { assertEquals(linkedList.size, 4) },
                    { assertNotNull(linkedList.firstOrNull) },
                    { assertNotNull(linkedList.lastOrNull) },
                    { assertEquals(linkedList.firstOrNull, 4) },
                    { assertEquals(linkedList.lastOrNull, 1) },
                    { assertEquals(linkedList.get(3), 1) },
                    { assertEquals(linkedList.get(2), 2) },
                    { assertEquals(linkedList.get(1), 3) },
                    { assertEquals(linkedList.get(0), 4) },
                )
            }
        }

        @Nested
        inner class `Distinct linked list` {
            @Test
            fun `distinct element from empty list`() {
                val linkedList = mutableLinkedListOf<Int>()
                linkedList.distinct()
                assertAll(
                    { assertEquals(linkedList.size, 0) },
                    { assertNull(linkedList.firstOrNull) },
                    { assertNull(linkedList.lastOrNull) }
                )
            }

            @Test
            fun `distinct element of make filled list with 1 item`() {
                val linkedList = mutableLinkedListOf<Int>(0)
                linkedList.distinct()
                assertAll(
                    { assertEquals(linkedList.size, 1) },
                    { assertEquals(linkedList.firstOrNull, 0) },
                    { assertEquals(linkedList.lastOrNull, 0) },
                )
            }

            @Test
            fun `distinct element from filled list`() {
                val linkedList = mutableLinkedListOf<Int>(1, 1, 2, 5, 3, 3, 4, 3)
                linkedList.distinct()
                println(linkedList)
                assertAll(
                    { assertEquals(linkedList.size, 5) },
                    { assertEquals(linkedList.firstOrNull, 1) },
                    { assertEquals(linkedList.lastOrNull, 4) },
                    { assertEquals(linkedList.get(0), 1) },
                    { assertEquals(linkedList.get(1), 2) },
                    { assertEquals(linkedList.get(2), 5) },
                    { assertEquals(linkedList.get(3), 3) },
                    { assertEquals(linkedList.get(4), 4) },
                )
            }
        }
    }
}
