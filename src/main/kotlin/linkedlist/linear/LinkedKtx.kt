package linkedlist.linear

// ---------- Creation ------------

fun <T> linkedListOf(): LinkedList<T> {
    return LinkedCollection.newInstance()
}

fun <T> linkedListOf(vararg many: T): LinkedList<T> {
    return LinkedCollection.from(*many)
}

fun <T> mutableLinkedListOf(): MutableLinkedList<T> {
    return LinkedCollection.newMutableInstance()
}

fun <T> mutableLinkedListOf(vararg many: T): MutableLinkedList<T> {
    return LinkedCollection.mutableFrom(*many)
}

// ---------- Conversions ------------

// TODO TEST
fun <T> Iterable<T>.toLinkedList(): LinkedList<T> {
    return fold(mutableLinkedListOf()) { acc, item ->
        acc.insertLast(item)
        return@fold acc
    }
}

// TODO TEST
fun <T> Iterable<T>.toMutableLinkedList(): MutableLinkedList<T> {
    return fold(mutableLinkedListOf()) { acc, item ->
        acc.insertLast(item)
        return@fold acc
    }
}

// ---------- operations ----------


// ---------- reverse ----------

// TODO TEST
fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val contents = mutableListOf<T>()
    forEach { content -> contents.add(content) }
    return contents.reversed().toLinkedList()
}

// ---------- Sort ----------

// TODO TEST
private fun LinkedList<Int>.isAscending(): Boolean {
    this.fold(firstOrNull) { current: Int?, next: Int? ->
        val isAscending = current ?: 0 <= next ?: 0
        if (!isAscending) {
            return false
        }
        next
    }
    return true
}

// TODO TEST
private fun LinkedList<Int>.isDescending(): Boolean {
    this.fold(firstOrNull) { current: Int?, next: Int? ->
        val isAscending = current ?: 0 >= next ?: 0
        if (!isAscending) {
            return false
        }
        next
    }
    return true
}

// TODO TEST
fun LinkedList<Int>.isSorted(order: Order = Order.ASCENDING): Boolean = when (order) {
    Order.ASCENDING -> isAscending()
    Order.DESCENDING -> isDescending()
}

// ---------- insert Sort ----------

fun LinkedList<Int>.insertAscending(data: Int) {
    TODO("implementation")
}

fun LinkedList<Int>.insertDescending(data: Int) {
    TODO("implementation")
}

// TODO TEST
fun LinkedList<Int>.insertSorted(data: Int, order: Order = Order.ASCENDING): Unit = when (order) {
    Order.ASCENDING -> insertAscending(data)
    Order.DESCENDING -> insertDescending(data)
}







