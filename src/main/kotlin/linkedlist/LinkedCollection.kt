package linkedlist


class LinkedCollection<T> private constructor() : LinkedList<T>, MutableLinkedList<T> {

    constructor(list: LinkedList<T>) : this() {
        _first = list.firstOrNull?.copy()
    }

    private var _first: Linked.Node<T>? = null

    override val firstOrNull: Linked.Node<T>?
        get() = _first

    override val lastOrNull: Linked.Node<T>?
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

    override fun size(): Int {
        var current = _first
        var size = 0
        while (current != null) {
            ++size
            current = current.next
        }
        return size
    }

    override fun insertFirst(data: T) {
        val node = Linked.Node(data)
        node.next = _first
        _first = node
    }

    override fun insertLast(data: T) {
        val node = Linked.Node(data)

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
        val size = size()
        if (position > size) {
            throw IndexOutOfBoundsException("Invalid Position for Insert")
        }

        val node = Linked.Node(data)

        if (position == 0) {
            node.next = _first
            _first = node
            return
        }

        var current = _first
        var tailing = _first
        var count = 0
        while (count != position) {
            tailing = current
            current = current?.next
            ++count
        }
        tailing?.next = node
        node.next = current
        current = node
    }


    override fun deleteFirst() {
        TODO("Not yet implemented")
    }

    override fun deleteLast() {
        TODO("Not yet implemented")
    }

    override fun deleteAt(position: Int) {
        TODO("Not yet implemented")
    }

    override fun delete(element: T) {
        TODO("Not yet implemented")
    }

    companion object {
        fun <T> newInstance(): LinkedList<T> {
            return LinkedCollection()
        }

        fun <T> newMutableInstance(): MutableLinkedList<T> {
            return LinkedCollection()
        }

        fun <T> mutableFrom(list: LinkedList<T>): LinkedCollection<T> {
            return LinkedCollection(list)
        }

    }

}

