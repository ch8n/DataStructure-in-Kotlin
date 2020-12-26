package linkedlist

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class LinkedListKtxKtTest {

    @Test
    fun `linkedList to mutable list always return new object`() {
        val list1 = mutableLinkedListOf<Int>()
        val list2 = list1.toMutableLinkedList()
        assertNotEquals(list1, list2)
    }

    @Test
    fun `linkedList of 1 item to mutable list always return new object 1 item`() {
        val first = Linked.Node(1)
        val list1 = mutableLinkedListOf(first)
        val list2 = list1.toMutableLinkedList()
        println(list1)
        println(list2)
        assertEquals(list1.size, 1)
        assertEquals(list2.size, 1)
        assertNotEquals(list1, list2)
    }

    @Test
    fun `linkedList when converted to mutable item stays immutable`() {
        val first = Linked.Node("pokemon")
        val list1 = mutableLinkedListOf(first)
        val list2 = list1.toMutableLinkedList()
        first.value = "test"

        println(list1)
        println(list2)
        assertEquals(list1.firstOrNull?.value, "pokemon")
        assertEquals(list2.firstOrNull?.value, "pokemon")
        assertEquals(list1.size, 1)
        assertEquals(list2.size, 1)
        assertNotEquals(list1, list2)
    }

    @Test
    fun `linkedList when converted to mutable item is object then it is mutable`() {
        data class Dummy(var data: Int = 2)

        val dummy = Dummy()

        val first = Linked.Node(dummy)
        val list1 = mutableLinkedListOf(first)
        val list2 = list1.toMutableLinkedList()

        dummy.data = 5

        println(list1)
        println(list2)
        assertEquals(list1.size, 1)
        assertEquals(list2.size, 1)
        assertEquals(list1.firstOrNull?.value?.data, 5)
        assertEquals(list2.firstOrNull?.value?.data, 5)
        assertNotEquals(list1, list2)
    }







    @Test
    fun `159 is ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(5)
            insertLast(9)
        }
        assertEquals(list.size, 3)
        assertEquals(list.isSortedAscending, true)

        println(list)
        println("Ascending sorted : ${list.isSortedAscending}")
    }

    @Test
    fun `310 is not ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(3)
            insertLast(1)
            insertLast(0)
        }
        assertEquals(list.size, 3)
        assertEquals(list.isSortedAscending, false)

        println(list)
        println("Ascending sorted : ${list.isSortedAscending}")
    }






    @Test
    fun `321 is descending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(3)
            insertLast(2)
            insertLast(1)
        }
        assertEquals(list.size, 3)
        assertEquals(list.isSortedDescending, true)

        println(list)
        println("Descending sorted : ${list.isSortedDescending}")
    }

    @Test
    fun `356 is not descending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(3)
            insertLast(5)
            insertLast(6)
        }
        assertEquals(list.size, 3)
        assertEquals(list.isSortedDescending, false)

        println(list)
        println("Descending sorted : ${list.isSortedDescending}")
    }


    @Test
    fun `forEach elements emit every data in linkedList`() {
        val linked = mutableLinkedListOf<Int>().apply {
            insertLast(2)
            insertLast(3)
            insertLast(1)
            insertLast(1)
            insertLast(4)
            insertLast(4)
        }

        val list = mutableListOf<Int?>()
        linked.forEach { list.add(it) }

        assertEquals(linked.size, 6)
        assertEquals(list.size, 6)
        println(linked)
        println(list)

    }



}
