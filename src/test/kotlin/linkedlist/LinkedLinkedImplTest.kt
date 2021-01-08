package linkedlist

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.fail
import java.lang.IndexOutOfBoundsException

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
                { assertEquals(linked.lastOrNull, 50) },
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

    // @Test
    // fun `insert item at first to prefilled linkedlist first and last should be different`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //     linkedList.insertFirst(10)
    //     linkedList.insertFirst(20)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //
    //     assertEquals(linkedList.firstOrNull?.value, 20)
    //     assertEquals(linkedList.lastOrNull?.value, 10)
    // }
    //
    // @Test
    // fun `insert item at end to empty linkedlist first and last should be equal`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //     linkedList.insertLast(10)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 1)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 10)
    //     assertEquals(linkedList.lastOrNull?.value, 10)
    // }
    //
    // @Test
    // fun `insert item at end to prefilled linkedlist first and last should be different`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //     linkedList.insertLast(10)
    //     linkedList.insertLast(20)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 10)
    //     assertEquals(linkedList.lastOrNull?.value, 20)
    // }
    //
    // @Test
    // fun `insert item at position 0 to empty linkedlist first and last should be equal`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //     linkedList.insertAt(0, 10)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 1)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 10)
    //     assertEquals(linkedList.lastOrNull?.value, 10)
    // }
    //
    // @Test
    // fun `insert item at position 1 to empty linkedlist throws exception`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //
    //     assertThrows(IndexOutOfBoundsException::class.java) {
    //         linkedList.insertAt(1, 10)
    //     }
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    // }
    //
    // @Test
    // fun `insert item at position between two nodes`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //     linkedList.insertFirst(30)
    //     linkedList.insertFirst(10)
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     linkedList.insertAt(1, 20)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 3)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 10)
    //     assertEquals(linkedList.lastOrNull?.value, 30)
    // }
    //
    // @Test
    // fun `delete first item of linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //     linkedList.insertAt(0, 1)
    //     linkedList.insertAt(1, 2)
    //     linkedList.insertAt(2, 3)
    //     linkedList.deleteFirst()
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //
    //     assertEquals(linkedList.firstOrNull?.value, 2)
    //     assertEquals(linkedList.lastOrNull?.value, 3)
    // }
    //
    // @Test
    // fun `delete first item of linked list no items`() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //
    //     linkedList.deleteFirst()
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 0)
    //     assertNull(linkedList.firstOrNull)
    //     assertNull(linkedList.lastOrNull)
    // }
    //
    // @Test
    // fun `delete last item of linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.deleteLast()
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 2)
    // }
    //
    // @Test
    // fun `delete item at 0 of linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.deleteAt(0)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 2)
    //     assertEquals(linkedList.lastOrNull?.value, 3)
    // }
    //
    // @Test
    // fun `delete item at 1 of linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.deleteAt(1)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 3)
    // }
    //
    // @Test
    // fun `delete item at 3 of linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.deleteAt(3)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 2)
    // }
    //
    // @Test
    // fun `delete item at invalid index of linked list with multiple items`() {
    //
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     assertThrows(IllegalArgumentException::class.java) {
    //         linkedList.deleteAt(5)
    //     }
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    // }
    //
    // @Test
    // fun `delete item with value 2 from linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.delete(2)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 3)
    // }
    //
    // @Test
    // fun `delete item with value 1 from linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.delete(1)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 2)
    //     assertEquals(linkedList.lastOrNull?.value, 3)
    // }
    //
    // @Test
    // fun `delete item with value 3 from linked list with multiple items`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.delete(3)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 2)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 2)
    // }
    //
    // @Test
    // fun `delete item with value 3 from empty linked list `() {
    //     val linkedList = mutableLinkedListOf<Int>()
    //
    //     linkedList.delete(3)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 0)
    //     assertNull(linkedList.firstOrNull)
    //     assertNull(linkedList.lastOrNull)
    // }
    //
    // @Test
    // fun `replace item at first index, with value 5 when list has multiple item`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.replace(0, 5)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 3)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 5)
    //     assertEquals(linkedList.lastOrNull?.value, 3)
    // }
    //
    // @Test
    // fun `replace item at middle index, with value 5 when list has multiple item`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.replace(1, 5)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 3)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 3)
    // }
    //
    // @Test
    // fun `replace item at last index, with value 5 when list has multiple item`() {
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     linkedList.replace(2, 5)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    //
    //     assertEquals(linkedList.size, 3)
    //     assertNotNull(linkedList.firstOrNull)
    //     assertNotNull(linkedList.lastOrNull)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 5)
    // }
    //
    // @Test
    // fun `replace item at in empty list throws exception`() {
    //
    //     val linkedList = mutableLinkedListOf<Int>().also {
    //         it.insertAt(0, 1)
    //         it.insertAt(1, 2)
    //         it.insertAt(2, 3)
    //     }
    //
    //     assertThrows(IllegalArgumentException::class.java) {
    //         linkedList.replace(5, 5)
    //     }
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    // }
    //
    // @Test
    // fun `replace item at invalid index in list throws exception`() {
    //
    //     val linkedList = mutableLinkedListOf<Int>()
    //
    //     assertThrows(IllegalStateException::class.java) {
    //         linkedList.replace(0, 2)
    //     }
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    // }
    //
    // @Test
    // fun `linked list have unique values on distinct`() {
    //
    //     val linkedList = mutableLinkedListOf<Int>().apply {
    //         insertLast(1)
    //         insertLast(2)
    //         insertLast(3)
    //         insertLast(4)
    //         insertLast(3)
    //     }
    //
    //     assertEquals(linkedList.size, 5)
    //
    //     linkedList.distinct()
    //
    //     assertEquals(linkedList.size, 4)
    //     assertEquals(linkedList.firstOrNull?.value, 1)
    //     assertEquals(linkedList.lastOrNull?.value, 4)
    //
    //     println("LinkedListContent : $linkedList")
    //     println("first : ${linkedList.firstOrNull}")
    //     println("last : ${linkedList.lastOrNull}")
    // }
    //
    // @Test
    // fun `reverse nodes or pointers of linked list `() {
    //
    //     val linkedList = mutableLinkedListOf<Int>().apply {
    //         insertLast(1)
    //         insertLast(2)
    //         insertLast(3)
    //         insertLast(4)
    //         insertLast(5)
    //     }
    //     println(linkedList)
    //
    //     linkedList.reverse()
    //
    //     assertEquals(linkedList.size, 5)
    //     assertEquals(linkedList.firstOrNull?.value, 5)
    //     assertEquals(linkedList.lastOrNull?.value, 1)
    // }
    //
    // @Test
    // fun `merge two linked list`() {
    //
    //     val linked1 = mutableLinkedListOf<Int>().apply {
    //         insertLast(1)
    //         insertLast(2)
    //         insertLast(3)
    //         insertLast(4)
    //         insertLast(5)
    //     }
    //
    //     val linked2 = mutableLinkedListOf<Int>().apply {
    //         insertLast(6)
    //         insertLast(7)
    //         insertLast(8)
    //         insertLast(9)
    //         insertLast(10)
    //     }
    //
    //     linked1.insertAll(linked2)
    //
    //     assertEquals(linked1.size, 10)
    //     assertEquals(linked1.firstOrNull?.value, 1)
    //     assertEquals(linked1.lastOrNull?.value, 10)
    // }
    //
    // @Test
    // fun `change in one of the two merged linked list doesn't effect merged list`() {
    //
    //     val linked1 = mutableLinkedListOf<Int>().apply {
    //         insertLast(1)
    //         insertLast(2)
    //         insertLast(3)
    //         insertLast(4)
    //         insertLast(5)
    //     }
    //
    //     val linked2 = mutableLinkedListOf<Int>().apply {
    //         insertLast(6)
    //         insertLast(7)
    //         insertLast(8)
    //         insertLast(9)
    //         insertLast(10)
    //     }
    //
    //     linked1.insertAll(linked2)
    //
    //     linked2.deleteAt(5)
    //
    //     assertEquals(linked2.size, 4)
    //     assertEquals(linked2.lastOrNull?.value, 9)
    //
    //     assertEquals(linked1.size, 10)
    //
    //     assertEquals(linked1.firstOrNull?.value, 1)
    //     assertEquals(linked1.lastOrNull?.value, 10)
    // }
    //
    // @AfterEach
    // fun tearDown() {
    // }
}
