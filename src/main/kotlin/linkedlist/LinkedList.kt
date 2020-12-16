package linkedlist


class LinkedList<T> : InsertLinkedList<T> {
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
            builder.append(" $value")
            current = current.next
        }
        return builder.toString()
    }

    fun size(): Int {
        var current = _first
        var size = 0
        while (current != null) {
            ++size
            current = current.next
        }
        return size
    }

    override fun insertFirst(data: T) {
        val node = Node(data).apply { next = _first }
        // if first is null then we are adding new item first time
        _first = node
        if (size() == 1) {
            _last = _first
        }
    }

    override fun insertEnd(data: T) {
        TODO("Not yet implemented")
    }

    override fun insertAt(position: Int, data: T) {
        TODO("Not yet implemented")
    }

}

