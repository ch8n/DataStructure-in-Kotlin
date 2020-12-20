package linkedlist

interface InsertLinkedList<T> {
    fun insertFirst(data: T)
    fun insertLast(data: T)
    fun insertAt(index: Int, data: T)
}


interface ReplaceLinkedList<T> {
    fun replace(index: Int, data: T)
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
    fun size(): Int
}

interface MutableLinkedList<T> :
    InsertLinkedList<T>,
    DeleteLinkedList<T>,
    LinkedList<T>,
    ReplaceLinkedList<T>

