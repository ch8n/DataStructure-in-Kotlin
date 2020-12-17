package linkedlist

//TODO test
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

//TODO test
fun <T> linkedListOf(): LinkedList<T> {
    return LinkedCollection.newInstance()
}

//TODO test
fun <T> mutableLinkedListOf(): MutableLinkedList<T> {
    return LinkedCollection.newMutableInstance()
}

//TODO test for mutability
fun <T> LinkedList<T>.toMutableLinkedList(): MutableLinkedList<T> {
    return LinkedCollection.mutableFrom(this)
}

//TODO test for mutability
fun <T> MutableLinkedList<T>.toLinkedList(): LinkedList<T> {
    return this
}