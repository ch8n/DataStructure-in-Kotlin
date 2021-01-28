package linkedlist.linear

class LinkedCollection<T> private constructor() : MutableLinkedList<T> {

    companion object {

        // ----- new instances ----
        fun <T> newInstance(): LinkedList<T> {
            return LinkedCollection()
        }

        fun <T> newMutableInstance(): MutableLinkedList<T> {
            return LinkedCollection()
        }

        // ----- from default values  ----
        fun <T> from(vararg many: T): LinkedList<T> {
            return LinkedCollection(*many)
        }

        fun <T> from(mutableList: MutableLinkedList<T>): LinkedList<T> {
            return LinkedCollection(mutableList)
        }

        fun <T> mutableFrom(vararg many: T): MutableLinkedList<T> {
            return LinkedCollection(*many)
        }

        fun <T> mutableFrom(list: LinkedList<T>): MutableLinkedList<T> {
            return LinkedCollection(list)
        }
    }

    private constructor(list: LinkedList<T>) : this() {
        var current = _first
        for (item in list) {
            if (current == null) {
                _first = Linked.Node(item)
            } else {
                current.next = Linked.Node(item)
                current = current.next
            }
        }
    }

    private constructor(vararg many: T) : this() {
        _first = Linked.Node(many[0])
        val leftovers = many.drop(1)
        var current = _first
        for (data in leftovers) {
            current?.next = Linked.Node(data)
            current = current?.next
        }
    }

    private var _first: Linked.Node<T>? = null
    private val _last: Linked.Node<T>?
        get() {
            var current = _first
            while (current?.next != null) {
                current = current.next
            }
            return current
        }

    override val firstOrNull: T?
        get() = _first?.value

    override val lastOrNull: T?
        get() = _last?.value

    override fun toString(): String {
        var current = _first
        var builder = ""
        while (current != null) {
            builder = "$builder ${current.value}"
            current = current.next
        }
        return builder
    }

    override val size: Int
        get() {
            val iterator = iterator()
            var size = 0
            iterator.forEach { ++size }
            return size
        }

    override fun isEmpty(): Boolean = _first == null

    override fun get(index: Int): T? {
        return when {
            isEmpty() -> throw IndexOutOfBoundsException("Cannot update empty list")
            index < 0 || index > size -> throw IndexOutOfBoundsException("Invalid Index")
            else -> {
                var current = _first
                var count = 0
                while (count != index) {
                    ++count
                    current = current?.next
                }
                current?.value
            }
        }
    }

    // --------------- Insert --------------------

    override fun insertFirst(data: T) {
        val node = Linked.Node(data)
        node.next = _first
        _first = node
    }

    override fun insertLast(data: T) {
        when (size) {
            0 -> insertFirst(data)
            else -> {
                val node = Linked.Node(data)
                var current = _first
                while (current?.next != null) {
                    current = current.next
                }
                current?.next = node
            }
        }
    }

    override fun insertAt(index: Int, data: T) {
        val size = size
        when {
            index > size || index < 0 -> throw IndexOutOfBoundsException("Invalid index for Insert")
            index == 0 -> insertFirst(data)
            index == size - 1 -> insertLast(data)
            else -> {
                val node = Linked.Node(data)
                var current = _first
                var tailing = _first
                var count = 0
                while (count != index) {
                    tailing = current
                    current = current?.next
                    ++count
                }
                tailing?.next = node
                node.next = current
            }
        }
    }

    override fun insertAll(linkedList: LinkedList<T>) {

        val isSecondEmpty = linkedList.isEmpty()
        // no item to enter
        if (isSecondEmpty) {
            return
        }

        val isFirstEmpty = isEmpty()
        // add item from last
        if (!isFirstEmpty) {
            var last = _last
            linkedList.forEach {
                val node = Linked.Node(it)
                last?.next = node
                last = node
            }
            return
        }

        // add item from first
        _first = Linked.Node(requireNotNull(linkedList.firstOrNull))
        val remaining = linkedList.drop(1)
        var current = _first
        remaining.forEach {
            val node = Linked.Node(it)
            current?.next = node
            current = node
        }
    }

    // --------------- Delete --------------------

    override fun deleteFirst() {
        val current = _first ?: return
        val next = current.next
        _first = next
    }

    override fun deleteLast() {
        when (size) {
            0, 1 -> deleteFirst()
            else -> {
                var current = _first
                var prev = _first
                while (current?.next != null) {
                    prev = current
                    current = current.next
                }
                prev?.next = null
            }
        }
    }

    override fun deleteAt(index: Int) {
        val size = size
        when {
            index > size || index < 0 -> throw IndexOutOfBoundsException("Invalid index for Deletion")
            index == 0 -> deleteFirst()
            index == size - 1 -> deleteLast()
            else -> {
                var current = _first
                var prev = _first
                var position = 0
                while (position != index) {
                    ++position
                    prev = current
                    current = current?.next
                }
                val next = current?.next
                prev?.next = next
            }
        }
    }

    override fun delete(element: T) {
        var current = _first

        if (current?.value == element) {
            deleteFirst()
            return
        }

        var prev = _first
        while (current?.next != null) {
            if (current.value == element) {
                break
            }
            prev = current
            current = current.next
        }

        val next = current?.next
        prev?.next = next
    }

    // --------------- Update --------------------

    override fun replace(index: Int, data: T) {
        when {
            isEmpty() -> throw IndexOutOfBoundsException("Cannot update empty list")
            index < 0 || index > size -> throw IndexOutOfBoundsException("Invalid Index")
            else -> {
                var current = _first
                var count = 0
                while (count != index) {
                    ++count
                    current = current?.next
                }
                current?.value = data
            }
        }
    }

    override fun distinct() {
        if (isEmpty() || size == 1) return

        var node = _first

        while (node != null) {

            var next = node.next
            var current = node

            while (next != null) {
                if (node.value == next.value) {
                    current?.next = next.next
                }
                current = next
                next = next.next
            }

            node = node.next
        }
    }

    override fun reverse() {

        if (isEmpty() || size == 1) {
            return
        }

        var prev: Linked.Node<T>? = null
        var current: Linked.Node<T>? = _first
        var next: Linked.Node<T>? = null

        while (current != null) {
            // hold next reference
            next = current.next

            // break link to next
            current.next = null

            // point current to previous
            current.next = prev

            // previous pointer point to the address of current node
            // we can directly use that to assign previous
            prev = current

            // proceed loop
            current = next
        }

        _first = prev
    }

    override fun iterator(): Iterator<T> {
        var current: Linked.Node<T>? = _first
        return object : Iterator<T> {
            override fun hasNext(): Boolean = current != null

            override fun next(): T {
                val value = current?.value
                current = current?.next
                return requireNotNull(value)
            }
        }
    }
}
