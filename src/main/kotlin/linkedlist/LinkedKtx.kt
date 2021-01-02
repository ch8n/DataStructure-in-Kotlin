package linkedlist

// ---------- Meta ------------

fun <T> linkedListOf(): LinkedList<T> {
    return LinkedCollection.newInstance()
}

fun <T> linkedListOf(first: T): LinkedList<T> {
    return LinkedCollection.from(first)
}

fun <T> mutableLinkedListOf(): MutableLinkedList<T> {
    return LinkedCollection.newMutableInstance()
}

fun <T> mutableLinkedListOf(first: T): MutableLinkedList<T> {
    return LinkedCollection.fromMutable(first)
}


fun <T> Iterable<T>.toLinkedList(): LinkedList<T> {
    return fold(mutableLinkedListOf()) { acc, item ->
        acc.insertLast(item)
        return@fold acc
    }
}

fun <T> Iterable<T>.toMutableLinkedList(): MutableLinkedList<T> {
    return fold(mutableLinkedListOf()) { acc, item ->
        acc.insertLast(item)
        return@fold acc
    }
}
