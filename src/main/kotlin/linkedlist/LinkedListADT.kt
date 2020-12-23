package linkedlist

interface InsertLinkedList<T> {
    fun insertFirst(data: T)
    fun insertLast(data: T)
    fun insertAt(index: Int, data: T)
}

interface UpdateLinkedList<T> {
    fun replace(index: Int, data: T?)
    fun sortAscending()
    fun sortDescending()
    fun reverse()
    fun distinct()
}

interface DeleteLinkedList<T> {
    fun deleteFirst()
    fun deleteLast()
    fun deleteAt(index: Int)
    fun delete(element: T)
}

abstract class Linked<T> {
    data class Node<T>(var value: T? = null, var next: Node<T>? = null)
}

interface LinkedList<T> {
    val firstOrNull: Linked.Node<T>?
    val lastOrNull: Linked.Node<T>?
    val size: Int
}

interface MutableLinkedList<T> :
    InsertLinkedList<T>,
    DeleteLinkedList<T>,
    LinkedList<T>,
    UpdateLinkedList<T>
