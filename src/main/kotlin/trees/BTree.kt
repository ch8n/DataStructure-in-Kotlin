package trees

class BTree<T>(value: T) {
    private val _node = Tree.Node(value)
    val node: Tree.Node<T>
        get() = _node

    fun left(value: T, branch: BTree<T>.() -> Unit = {}) {
        val tree = BTree(value)
        branch.invoke(tree)
        _node.lChild = tree.node
    }

    fun right(value: T, branch: BTree<T>.() -> Unit = {}) {
        val tree = BTree(value)
        branch.invoke(tree)
        _node.rChild = tree.node
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
