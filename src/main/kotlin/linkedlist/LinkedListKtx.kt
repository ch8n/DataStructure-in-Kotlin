package linkedlist

fun <T> LinkedList<T>.toStringRecursive() {
    fun recursive(node: LinkedList.Node<T>?): T? {
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
    return LinkedList()
}