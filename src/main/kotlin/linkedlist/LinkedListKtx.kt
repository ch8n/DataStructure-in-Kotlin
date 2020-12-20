package linkedlist

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
