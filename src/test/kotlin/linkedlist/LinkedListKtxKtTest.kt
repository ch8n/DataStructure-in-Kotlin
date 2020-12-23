package linkedlist

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class LinkedListKtxKtTest {

    @Test
    fun `linkedListOf() returns new instance on each invoke`() {
        val list1 = linkedListOf<Int>()
        val list2 = linkedListOf<Int>()
        assertNotEquals(list1, list2)
    }

    @Test
    fun `linkedListOf(node) returns new instance with one item`() {
        val first = Linked.Node(1)
        val list1 = linkedListOf<Int>(first)
        assertEquals(list1.size, 1)
    }

    @Test
    fun `mutableLinkedListOf() returns new instance on each invoke`() {
        val list1 = mutableLinkedListOf<Int>()
        val list2 = mutableLinkedListOf<Int>()
        assertNotEquals(list1, list2)
    }

    @Test
    fun `mutableLinkedListOf(node) returns new instance with one item`() {
        val first = Linked.Node(1)
        val list1 = mutableLinkedListOf(first)
        assertEquals(list1.size, 1)
    }

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
    fun `mutable linked list to list is immutable instance`() {
        val first = Linked.Node(1)
        val list1 = mutableLinkedListOf(first)
        val list2 = list1.toLinkedList()

        first.value = 2

        println(list1)
        println(list2)

        assertEquals(list1.size, 1)
        assertEquals(list2.size, 1)

        assertEquals(list1.firstOrNull?.value, 1)
        assertEquals(list2.firstOrNull?.value, 1)
        assertNotEquals(list1, list2)
    }

    @Test
    fun `convert list to Linked List have same size`() {
        val list = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
        val linked = list.toLinkedList()

        println(list)
        println(linked)

        assertEquals(list.size, linked.size)
    }

    @Test
    fun `insert item in middle of ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(4)
        }
        list.insertInAscendingSorted(3)
        println(list)

        assertEquals(list.size, 4)
        assertEquals(list.firstOrNull?.value, 1)
        assertEquals(list.lastOrNull?.value, 4)
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
    fun `insert item in end of ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
        }
        list.insertInAscendingSorted(5)
        println(list)

        assertEquals(list.size, 4)
        assertEquals(list.firstOrNull?.value, 1)
        assertEquals(list.lastOrNull?.value, 5)
    }

    @Test
    fun `insert item in empty ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>()
        list.insertInAscendingSorted(5)
        println(list)

        assertEquals(list.size, 1)
        assertEquals(list.firstOrNull?.value, 5)
        assertEquals(list.lastOrNull?.value, 5)
    }

    @Test
    fun `insert item in start of ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
        }
        list.insertInAscendingSorted(0)
        println(list)

        assertEquals(list.size, 4)
        assertEquals(list.firstOrNull?.value, 0)
        assertEquals(list.lastOrNull?.value, 3)
    }

    @Test
    fun `no item can be inserted if linked list is not ascending sorted`() {
        val linkedList = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(0)
            insertLast(9)
        }

        Assertions.assertThrows(IllegalStateException::class.java) {
            linkedList.insertInAscendingSorted(5)
        }

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")
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

}
