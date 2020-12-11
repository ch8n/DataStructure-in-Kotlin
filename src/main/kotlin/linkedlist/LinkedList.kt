package linkedlist

class LinkedList<T> {
    data class Node<T>(var value: T? = null, var next: Node<T>? = null)

    private var _first: Node<T>? = null
    private var _last = _first

    val firstOrNull: Node<T>?
        get() = _first

    val lastOrNull: Node<T>?
        get() = _last

    override fun toString(): String {
        var current = _first
        val builder = StringBuilder("")
        while (current != null) {
            val value = current.value ?: ""
            builder.append(value)
            current = current.next
        }
        return builder.toString()
    }
}