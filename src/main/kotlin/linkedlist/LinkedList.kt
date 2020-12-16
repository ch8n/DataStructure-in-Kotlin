package linkedlist


class LinkedList<T> : InsertLinkedList<T> {
    data class Node<T>(var value: T? = null, var next: Node<T>? = null)

    private var _first: Node<T>? = null

    val firstOrNull: Node<T>?
        get() = _first

    val lastOrNull: Node<T>?
        get() {
            return when (size()) {
                0 -> null
                1 -> _first
                else -> {
                    var current = _first
                    while (current?.next != null) {
                        current = current.next
                    }
                    current
                }
            }
        }

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
        val node = Node(data)
        node.next = _first
        _first = node
    }

    override fun insertEnd(data: T) {
        val node = Node(data)
        if (size() == 0) {
            _first = node
            return
        }

        var current = _first
        while (current?.next != null) {
            current = current.next
        }
        current?.next = node
    }

    override fun insertAt(position: Int, data: T) {
        TODO("Not yet implemented")
    }

}

