package linkedlist

interface InsertLinkedList<T> {
    fun insertFirst(data: T)
    fun insertLast(data: T)
    fun insertAt(index: Int, data: T)
    fun insertAll(linkedList: LinkedList<T>)
}

interface UpdateLinkedList<T> {
    fun replace(index: Int, data: T)
    fun reverse()
    fun distinct()
}

enum class Order {
    ASCENDING,
    DESCENDING
}


/**
 *  TODO
 *  fun LinkedList<Int>.sum()
 *  fun LinkedList<Int>.distinct() returns new list with distinct items
 *  fun LinkedList<Int>.isSorted(Order= Order.ASCENDING)
 *  fun LinkedList<Int>.sort(order: Order = Order.ASCENDING)
 **/

interface DeleteLinkedList<T> {
    fun deleteFirst()
    fun deleteLast()
    fun deleteAt(index: Int)
    fun delete(element: T)
}

abstract class Linked<T> {
    data class Node<T>(var value: T, var next: Node<T>? = null)
}

interface LinkedList<T> :
    Iterable<T> {
    val firstOrNull: T?
    val lastOrNull: T?
    val size: Int
    fun isEmpty(): Boolean
    fun get(index: Int): T?
}

interface MutableLinkedList<T> :
    InsertLinkedList<T>,
    DeleteLinkedList<T>,
    LinkedList<T>,
    UpdateLinkedList<T>
