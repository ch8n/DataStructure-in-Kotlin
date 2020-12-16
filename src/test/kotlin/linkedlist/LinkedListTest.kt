package linkedlist

import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before

import org.junit.Test
import kotlin.test.assertNotNull


class LinkedListTest {

    @Before
    fun setUp() {
    }

    @Test
    fun `new list has 0 size and null first last nodes`() {
        val linkedList = linkedListOf<Int>()
        println("LinkedListContent : $linkedList")
        assertEquals(linkedList.size(), 0)
        assertEquals(linkedList.firstOrNull, null)
        assertEquals(linkedList.lastOrNull, null)

    }

    @Test
    fun `adding first linkedlist successful`() {
        val linkedList = linkedListOf<Int>()
        linkedList.insertFirst(10)
        println("LinkedListContent : $linkedList")
        assertEquals(linkedList.size(), 1)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }

    @After
    fun tearDown() {
    }
}