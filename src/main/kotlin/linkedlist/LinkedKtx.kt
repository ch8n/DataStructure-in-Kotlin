package linkedlist

// ---------- Meta ------------

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

fun <T> Iterable<T>.toLinkedList(): LinkedList<T> {
    return this.fold(mutableLinkedListOf()) { acc, item ->
        acc.insertLast(item)
        return@fold acc
    }
}
