package linkedlist

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.IndexOutOfBoundsException

class LinkedLinkedImplTest {

    @BeforeEach
    fun setUp() {
    }



    @Test
    fun `insert item at first to empty linked list first and last should be equal`() {
        val linkedList = mutableLinkedListOf<Int>()
        linkedList.insertFirst(10)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 1)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }

    @Test
    fun `insert item at first to prefilled linkedlist first and last should be different`() {
        val linkedList = mutableLinkedListOf<Int>()
        linkedList.insertFirst(10)
        linkedList.insertFirst(20)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)

        assertEquals(linkedList.firstOrNull?.value, 20)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }

    @Test
    fun `insert item at end to empty linkedlist first and last should be equal`() {
        val linkedList = mutableLinkedListOf<Int>()
        linkedList.insertLast(10)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 1)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }

    @Test
    fun `insert item at end to prefilled linkedlist first and last should be different`() {
        val linkedList = mutableLinkedListOf<Int>()
        linkedList.insertLast(10)
        linkedList.insertLast(20)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 20)
    }

    @Test
    fun `insert item at position 0 to empty linkedlist first and last should be equal`() {
        val linkedList = mutableLinkedListOf<Int>()
        linkedList.insertAt(0, 10)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 1)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }

    @Test
    fun `insert item at position 1 to empty linkedlist throws exception`() {
        val linkedList = mutableLinkedListOf<Int>()

        assertThrows(IndexOutOfBoundsException::class.java) {
            linkedList.insertAt(1, 10)
        }

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")
    }

    @Test
    fun `insert item at position between two nodes`() {
        val linkedList = mutableLinkedListOf<Int>()
        linkedList.insertFirst(30)
        linkedList.insertFirst(10)
        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        linkedList.insertAt(1, 20)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 3)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 30)
    }

    @Test
    fun `delete first item of linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>()
        linkedList.insertAt(0, 1)
        linkedList.insertAt(1, 2)
        linkedList.insertAt(2, 3)
        linkedList.deleteFirst()
        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)

        assertEquals(linkedList.firstOrNull?.value, 2)
        assertEquals(linkedList.lastOrNull?.value, 3)
    }

    @Test
    fun `delete first item of linked list no items`() {
        val linkedList = mutableLinkedListOf<Int>()

        linkedList.deleteFirst()

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 0)
        assertNull(linkedList.firstOrNull)
        assertNull(linkedList.lastOrNull)
    }

    @Test
    fun `delete last item of linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.deleteLast()

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 1)
        assertEquals(linkedList.lastOrNull?.value, 2)
    }

    @Test
    fun `delete item at 0 of linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.deleteAt(0)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 2)
        assertEquals(linkedList.lastOrNull?.value, 3)
    }

    @Test
    fun `delete item at 1 of linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.deleteAt(1)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 1)
        assertEquals(linkedList.lastOrNull?.value, 3)
    }

    @Test
    fun `delete item at 3 of linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.deleteAt(3)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 1)
        assertEquals(linkedList.lastOrNull?.value, 2)
    }

    @Test
    fun `delete item at invalid index of linked list with multiple items`() {

        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        assertThrows(IllegalArgumentException::class.java) {
            linkedList.deleteAt(5)
        }

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")
    }

    @Test
    fun `delete item with value 2 from linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.delete(2)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 1)
        assertEquals(linkedList.lastOrNull?.value, 3)
    }

    @Test
    fun `delete item with value 1 from linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.delete(1)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 2)
        assertEquals(linkedList.lastOrNull?.value, 3)
    }

    @Test
    fun `delete item with value 3 from linked list with multiple items`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.delete(3)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 1)
        assertEquals(linkedList.lastOrNull?.value, 2)
    }

    @Test
    fun `delete item with value 3 from empty linked list `() {
        val linkedList = mutableLinkedListOf<Int>()

        linkedList.delete(3)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 0)
        assertNull(linkedList.firstOrNull)
        assertNull(linkedList.lastOrNull)
    }

    @Test
    fun `replace item at first index, with value 5 when list has multiple item`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.replace(0, 5)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 3)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 5)
        assertEquals(linkedList.lastOrNull?.value, 3)
    }

    @Test
    fun `replace item at middle index, with value 5 when list has multiple item`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.replace(1, 5)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 3)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 1)
        assertEquals(linkedList.lastOrNull?.value, 3)
    }

    @Test
    fun `replace item at last index, with value 5 when list has multiple item`() {
        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        linkedList.replace(2, 5)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size, 3)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 1)
        assertEquals(linkedList.lastOrNull?.value, 5)
    }

    @Test
    fun `replace item at in empty list throws exception`() {

        val linkedList = mutableLinkedListOf<Int>().also {
            it.insertAt(0, 1)
            it.insertAt(1, 2)
            it.insertAt(2, 3)
        }

        assertThrows(IllegalArgumentException::class.java) {
            linkedList.replace(5, 5)
        }

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")
    }

    @Test
    fun `replace item at invalid index in list throws exception`() {

        val linkedList = mutableLinkedListOf<Int>()

        assertThrows(IllegalStateException::class.java) {
            linkedList.replace(0, 2)
        }

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")
    }

    @Test
    fun `linked list have unique values on distinct`() {

        val linkedList = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
            insertLast(4)
            insertLast(3)
        }

        assertEquals(linkedList.size,5)

        linkedList.distinct()

        assertEquals(linkedList.size,4)
        assertEquals(linkedList.firstOrNull?.value,1)
        assertEquals(linkedList.lastOrNull?.value,4)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

    }

    @Test
    fun `reverse nodes or pointers of linked list `() {

        val linkedList = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
            insertLast(4)
            insertLast(5)
        }
        println(linkedList)

        linkedList.reverse()

        assertEquals(linkedList.size,5)
        assertEquals(linkedList.firstOrNull?.value,5)
        assertEquals(linkedList.lastOrNull?.value,1)

    }

    @Test
    fun `merge two linked list`() {

        val linked1 = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
            insertLast(4)
            insertLast(5)
        }

        val linked2 = mutableLinkedListOf<Int>().apply {
            insertLast(6)
            insertLast(7)
            insertLast(8)
            insertLast(9)
            insertLast(10)
        }

        linked1.insertAll(linked2)

        assertEquals(linked1.size,10)
        assertEquals(linked1.firstOrNull?.value,1)
        assertEquals(linked1.lastOrNull?.value,10)

    }

    @Test
    fun `change in one of the two merged linked list doesn't effect merged list`() {

        val linked1 = mutableLinkedListOf<Int>().apply {
            insertLast(1)
            insertLast(2)
            insertLast(3)
            insertLast(4)
            insertLast(5)
        }

        val linked2 = mutableLinkedListOf<Int>().apply {
            insertLast(6)
            insertLast(7)
            insertLast(8)
            insertLast(9)
            insertLast(10)
        }

        linked1.insertAll(linked2)

        linked2.deleteAt(5)

        assertEquals(linked2.size, 4)
        assertEquals(linked2.lastOrNull?.value, 9)

        assertEquals(linked1.size, 10)

        assertEquals(linked1.firstOrNull?.value, 1)
        assertEquals(linked1.lastOrNull?.value, 10)
    }


    @AfterEach
    fun tearDown() {
    }
}
