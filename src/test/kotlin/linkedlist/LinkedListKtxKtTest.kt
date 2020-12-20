package linkedlist


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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


}