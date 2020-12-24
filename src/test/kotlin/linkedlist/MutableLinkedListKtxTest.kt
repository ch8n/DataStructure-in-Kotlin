package linkedlist

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalStateException

class MutableLinkedListKtxTest {

    @Test
    fun `insert item in middle of ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(4)
        }
        list.insertInAscendingSorted(3)
        println(list)

        Assertions.assertEquals(list.size, 4)
        Assertions.assertEquals(list.firstOrNull?.value, 1)
        Assertions.assertEquals(list.lastOrNull?.value, 4)
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

        Assertions.assertEquals(list.size, 4)
        Assertions.assertEquals(list.firstOrNull?.value, 1)
        Assertions.assertEquals(list.lastOrNull?.value, 5)
    }

    @Test
    fun `insert item in empty ascending sorted linked list`() {
        val list = mutableLinkedListOf<Int>()
        list.insertInAscendingSorted(5)
        println(list)

        Assertions.assertEquals(list.size, 1)
        Assertions.assertEquals(list.firstOrNull?.value, 5)
        Assertions.assertEquals(list.lastOrNull?.value, 5)
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

        Assertions.assertEquals(list.size, 4)
        Assertions.assertEquals(list.firstOrNull?.value, 0)
        Assertions.assertEquals(list.lastOrNull?.value, 3)
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
    fun `Asending sorted linked list have unique values on distinct`() {

        val linkedList = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
            insertLast(3)
            insertLast(4)
        }

        Assertions.assertEquals(linkedList.size, 5)
        Assertions.assertEquals(linkedList.isSortedAscending, true)

        linkedList.distinctSorted()

        Assertions.assertEquals(linkedList.size, 4)
        Assertions.assertEquals(linkedList.firstOrNull?.value, 1)
        Assertions.assertEquals(linkedList.lastOrNull?.value, 4)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

    }

    @Test
    fun `Descending sorted linked list have unique values on distinct`() {

        val linkedList = mutableLinkedListOf<Int>().apply {
            insertLast(4)
            insertLast(3)
            insertLast(3)
            insertLast(3)
            insertLast(3)
            insertLast(2)
            insertLast(2)
            insertLast(1)
        }

        Assertions.assertEquals(linkedList.size, 8)
        Assertions.assertEquals(linkedList.isSortedDescending, true)

        linkedList.distinctSorted()

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")


        Assertions.assertEquals(linkedList.size, 4)
        Assertions.assertEquals(linkedList.firstOrNull?.value, 4)
        Assertions.assertEquals(linkedList.lastOrNull?.value, 1)


    }

    @Test
    fun `231144 is not sorted thus can't be distinct sorted`() {
        val list = mutableLinkedListOf<Int>().apply {
            insertLast(2)
            insertLast(3)
            insertLast(1)
            insertLast(1)
            insertLast(4)
            insertLast(4)
        }
        Assertions.assertEquals(list.size, 6)
        Assertions.assertEquals(list.isSortedDescending, false)
        Assertions.assertEquals(list.isSortedAscending, false)

        Assertions.assertThrows(IllegalStateException::class.java) {
            list.distinctSorted()
        }

        println(list)

    }

    @Test
    fun `reverse linked list elements `() {
        val linked = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
            insertLast(4)
        }
        println(linked)
        linked.reverseElements()
        println(linked)
        Assertions.assertEquals(linked.size, 4)
        Assertions.assertEquals(linked.toString(), " 4 3 2 1")
    }

    @Test
    fun `mutable linked list to list is immutable instance`() {
        val first = Linked.Node(1)
        val list1 = mutableLinkedListOf(first)
        val list2 = list1.toLinkedList()

        first.value = 2

        println(list1)
        println(list2)

        Assertions.assertEquals(list1.size, 1)
        Assertions.assertEquals(list2.size, 1)

        Assertions.assertEquals(list1.firstOrNull?.value, 1)
        Assertions.assertEquals(list2.firstOrNull?.value, 1)
        Assertions.assertNotEquals(list1, list2)
    }

}