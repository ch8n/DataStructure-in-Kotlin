package linkedlist

import java.lang.IllegalStateException

// TODO test
fun <T> LinkedCollection<T>.toStringRecursive() {
    fun recursive(node: Linked.Node<T>?): T? {
        print(node?.value)
        return if (node == null) {
            node?.value
        } else {
            recursive(node.next)
        }
    }
    recursive(firstOrNull)
}

fun MutableLinkedList<Int>.insertInAscendingSorted(data: Int) {
    val isSorted = isSortedAscending
    val size = size
    when {
        !isSorted -> throw IllegalStateException("List is not sorted")
        size == 0 -> insertFirst(data)
        else -> {
            // head case need to handled separately
            val first = firstOrNull
            if ((first?.value ?: -1) > data) {
                insertFirst(data)
                return
            }

            // remaining cases
            val node = Linked.Node(data)
            var current = firstOrNull?.next
            var tailing = firstOrNull
            while (current != null && data > (current.value ?: -1)) {
                tailing = current
                current = current.next
            }
            node.next = current
            tailing?.next = node
        }
    }
}

val LinkedList<Int>.isSortedAscending: Boolean
    get() {
        var current = firstOrNull
        var next = firstOrNull
        while (current != null && next != null) {
            val isAscending = (current.value ?: Int.MIN_VALUE) <= (next.value ?: Int.MIN_VALUE)
            if (!isAscending) {
                return false
            }
            current = next
            next = current.next
        }
        return true
    }

val LinkedList<Int>.isSortedDescending: Boolean
    get() {
        var current = firstOrNull
        var next = firstOrNull
        while (current != null && next != null) {
            val isDescending = (current.value ?: Int.MIN_VALUE) >= (next.value ?: Int.MIN_VALUE)
            if (!isDescending) {
                return false
            }
            current = next
            next = current.next
        }
        return true
    }

fun MutableLinkedList<Int>.distinctSorted() {
    val isSortedAscending = isSortedAscending
    val isSortedDescending = isSortedDescending
    if (!isSortedAscending && !isSortedDescending) {
        throw IllegalStateException("List isn't sorted")
    }
    var tailing = firstOrNull
    var current = firstOrNull?.next
    while (current != null && tailing != null) {
        if (current.value == tailing.value) {
            tailing.next = current.next
        } else {
            tailing = current
        }
        current = current.next
    }
}

fun <T> linkedListOf(): LinkedList<T> {
    return LinkedCollection.newInstance()
}

fun <T> linkedListOf(first: Linked.Node<T>): LinkedList<T> {
    return LinkedCollection.from(first)
}

fun <T> mutableLinkedListOf(first: Linked.Node<T>): MutableLinkedList<T> {
    return LinkedCollection.mutableFrom(first)
}

fun <T> mutableLinkedListOf(): MutableLinkedList<T> {
    return LinkedCollection.newMutableInstance()
}

fun <T> LinkedList<T>.toMutableLinkedList(): MutableLinkedList<T> {
    return LinkedCollection.mutableFrom(this)
}

fun <T> MutableLinkedList<T>.toLinkedList(): LinkedList<T> {
    return LinkedCollection.from(this)
}

fun <T> Iterable<T>.toLinkedList(): LinkedList<T> {
    return this.fold(mutableLinkedListOf()) { acc, item ->
        acc.insertLast(item)
        return@fold acc
    }
}
