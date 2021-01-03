package linkedlist

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
        fun <T> from(first: T): LinkedList<T> {
            return LinkedCollection(first)
        }

        fun <T> from(mutableList: MutableLinkedList<T>): LinkedList<T> {
            return LinkedCollection(mutableList)
        }

        fun <T> mutableFrom(first: T): MutableLinkedList<T> {
            return LinkedCollection(first)
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

    private constructor(first: T) : this() {
        _first = Linked.Node(first)
    }

    private var _first: Linked.Node<T>? = null

    override val firstOrNull: T?
        get() = _first?.value

    override val lastOrNull: T?
        get() {
            val iterator = iterator()
            var last: T? = null
            while (iterator.hasNext()) {
                last = iterator.next()
            }
            return last
        }

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

    // --------------- Insert --------------------

    override fun insertFirst(data: T) {
        val node = Linked.Node(data)
        node.next = _first
        _first = node
    }

    override fun insertLast(data: T) {
        // when (size) {
        //     0 -> insertFirst(data)
        //     else -> {
        //         val node = Linked.Node(data)
        //         var current = _first
        //         while (current?.next != null) {
        //             current = current.next
        //         }
        //         current?.next = node
        //     }
        // }
    }

    override fun insertAt(index: Int, data: T) {
        // val size = size
        // when {
        //     index > size -> throw IndexOutOfBoundsException("Invalid index for Insert")
        //     index == 0 -> insertFirst(data)
        //     index == size -> insertLast(data)
        //     else -> {
        //         val node = Linked.Node(data)
        //         var current = _first
        //         var tailing = _first
        //         var count = 0
        //         while (count != index) {
        //             tailing = current
        //             current = current?.next
        //             ++count
        //         }
        //         tailing?.next = node
        //         node.next = current
        //         current = node
        //     }
        // }
    }

    override fun insertAll(linkedList: LinkedList<T>) {
        // var last = lastOrNull
        // linkedList.forEachNode {
        //     last?.next = it?.copy()
        //     last = last?.next
        // }
    }

    // --------------- Delete --------------------

    override fun deleteFirst() {
        // val current = _first ?: return
        // val next = current.next
        // _first = next
    }

    override fun deleteLast() {
        // when (size) {
        //     0, 1 -> deleteFirst()
        //     else -> {
        //         var current = _first
        //         var prev = _first
        //         while (current?.next != null) {
        //             prev = current
        //             current = current.next
        //         }
        //         prev?.next = null
        //     }
        // }
    }

    override fun deleteAt(index: Int) {
        // val size = size
        // when {
        //     index > size -> throw IllegalArgumentException("Invalid index for Deletion")
        //     index == 0 -> deleteFirst()
        //     index == size -> deleteLast()
        //     else -> {
        //         var current = _first
        //         var prev = _first
        //         var position = 0
        //         while (position != index) {
        //             ++position
        //             prev = current
        //             current = current?.next
        //         }
        //         val next = current?.next
        //         prev?.next = next
        //         current = null
        //     }
        // }
    }

    override fun delete(element: T) {
        // var current = _first
        //
        // if (current?.value == element) {
        //     deleteFirst()
        //     return
        // }
        //
        // var prev = _first
        // while (current?.next != null) {
        //     if (current.value == element) {
        //         break
        //     }
        //     prev = current
        //     current = current.next
        // }
        //
        // val next = current?.next
        // prev?.next = next
        // current = null
    }

    // --------------- Update --------------------

    override fun replace(index: Int, data: T) {
        // val size = size
        // when {
        //     size == 0 -> throw IllegalStateException("Cannot update an empty list")
        //     index > size -> throw IllegalArgumentException("Invalid index for update")
        //     index == 0 -> _first?.value = data
        //     else -> {
        //         var current = _first
        //         var count = 0
        //         while (count != index) {
        //             ++count
        //             current = current?.next
        //         }
        //         current?.value = data
        //     }
        // }
    }

    override fun distinct() {

        // var node = _first
        //
        // while (node != null) {
        //
        //     var current = node.next
        //     var tailing = node
        //
        //     while (current != null) {
        //         if (node.value == current.value) {
        //             tailing?.next = current.next
        //         }
        //         tailing = current
        //         current = current.next
        //     }
        //
        //     node = node.next
        // }
    }

    override fun sort(isDescending: Boolean) {
        TODO("Not yet implemented")
    }

    override fun reverse() {
        // var prev: Linked.Node<T>? = null
        // var current: Linked.Node<T>? = _first
        // var next: Linked.Node<T>? = null
        //
        // while (current != null) {
        //     // hold next reference
        //     next = current.next
        //
        //     // break link to next
        //     current.next = null
        //
        //     // point current to previous
        //     current.next = prev
        //
        //     // previous pointer point to the address of current node
        //     // we can directly use that to assign previous
        //     prev = current
        //
        //     // proceed loop
        //     current = next
        // }
        //
        // _first = prev
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
