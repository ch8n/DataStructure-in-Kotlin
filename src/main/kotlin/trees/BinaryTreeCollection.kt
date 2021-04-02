package trees

class BinaryTreeCollection<T>(value: T) {

    private val _node = Tree.Node(value)

    val root: Tree.Node<T>
        get() = _node

    fun getDirectChildren(value: T): Pair<T?, T?> {
        var collector = Pair<T?, T?>(null, null)
        fun recursiveFind(node: Tree.Node<T>?, targetValue: T) {
            if (node != null) {
                if (node.value == targetValue) {
                    collector = collector.copy(first = node.lChild?.value, second = node.rChild?.value)
                } else {
                    recursiveFind(node.lChild, targetValue)
                    recursiveFind(node.rChild, targetValue)
                }
            }
        }

        recursiveFind(_node, value)

        return collector
    }

    fun left(value: T, branch: BinaryTreeCollection<T>.() -> Unit = {}) {
        val tree = BinaryTreeCollection(value)
        branch.invoke(tree)
        _node.lChild = tree.root
    }

    fun right(value: T, branch: BinaryTreeCollection<T>.() -> Unit = {}) {
        val tree = BinaryTreeCollection(value)
        branch.invoke(tree)
        _node.rChild = tree.root
    }

    fun preOrder(): List<T> {
        val collector = mutableListOf<T>()

        fun recursivePreorder(node: Tree.Node<T>?, collector: MutableList<T>) {
            if (node != null) {
                collector.add(node.value)
                recursivePreorder(node.lChild, collector)
                recursivePreorder(node.rChild, collector)
            }
        }

        recursivePreorder(_node, collector)
        return collector
    }

    fun postOrder(): List<T> {
        val collector = mutableListOf<T>()

        fun recursivePreorder(node: Tree.Node<T>?, collector: MutableList<T>) {
            if (node != null) {
                recursivePreorder(node.lChild, collector)
                recursivePreorder(node.rChild, collector)
                collector.add(node.value)
            }
        }

        recursivePreorder(_node, collector)

        return collector
    }

    fun inOrder(): List<T> {
        val collector = mutableListOf<T>()

        fun recursivePreorder(node: Tree.Node<T>?, collector: MutableList<T>) {
            if (node != null) {
                recursivePreorder(node.lChild, collector)
                collector.add(node.value)
                recursivePreorder(node.rChild, collector)
            }
        }

        recursivePreorder(_node, collector)

        return collector
    }
}
