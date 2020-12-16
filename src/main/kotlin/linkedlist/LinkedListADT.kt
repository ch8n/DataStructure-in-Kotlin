package linkedlist

interface InsertLinkedList<T> {
    fun insertFirst(data: T)
    fun insertEnd(data: T)
    fun insertAt(position: Int, data: T)
}