package linkedlist

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LinkedKtxTest {

    @Test
    fun `linkedListOf() returns new instance on each invoke`() {
        val list1 = linkedListOf<Int>()
        val list2 = linkedListOf<Int>()
        Assertions.assertEquals(list1.size, 0)
        Assertions.assertEquals(list2.size, 0)
        Assertions.assertNotEquals(list1, list2)
    }

    @Test
    fun `linkedListOf(node) returns new instance with one item`() {
        val first = Linked.Node(1)
        val list = linkedListOf<Int>(first)
        Assertions.assertEquals(list.size, 1)
    }

    @Test
    fun `linkedListOf(node) node has nested nodes becomes linkedlist`() {
        val first = Linked.Node(1)
        val second = Linked.Node(2)
        val third = Linked.Node(3)

        first.next = second
        second.next = third

        val list = linkedListOf<Int>(first)
        println(list)
        Assertions.assertEquals(list.size, 3)
        Assertions.assertEquals(list.firstOrNull?.value, 1)
        Assertions.assertEquals(list.lastOrNull, 3)
    }

    @Test
    fun `linkedListOf(node) node has nested nodes becomes linkedlist and is immutable`() {
        val first = Linked.Node(1)
        val second = Linked.Node(2)
        val third = Linked.Node(3)

        first.next = second
        second.next = third
        val list = linkedListOf<Int>(first)

        third.value = 6

        println(list)
        Assertions.assertEquals(list.size, 3)
        Assertions.assertEquals(list.firstOrNull?.value, 1)
        Assertions.assertEquals(list.lastOrNull?.value, 3)
    }

    @Test
    fun `mutableLinkedListOf() returns new instance on each invoke`() {
        val list1 = mutableLinkedListOf<Int>()
        val list2 = mutableLinkedListOf<Int>()
        Assertions.assertNotEquals(list1, list2)
    }

    @Test
    fun `mutableLinkedListOf(node) returns new instance with one item`() {
        val first = Linked.Node(1)
        val list1 = mutableLinkedListOf(first)
        Assertions.assertEquals(list1.size, 1)
    }

    @Test
    fun `convert list to Linked List have same size`() {
        val list = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
        val linked = list.toLinkedList()

        println(list)
        println(linked)
    }
}
