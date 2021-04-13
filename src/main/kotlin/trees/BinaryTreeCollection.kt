package trees

class BinaryTreeCollection<T>(value: T) :
    MutableBinaryTree<T>,
    BinaryTree<T> {

    private val _root = Tree.Node(value)

    override fun directChildren(node: Tree.Node<T>): Pair<Tree.Node<T>?, Tree.Node<T>?> {
        var collector = Pair<Tree.Node<T>?, Tree.Node<T>?>(null, null)
        fun recursiveFind(node: Tree.Node<T>?, targetValue: T) {
            if (node != null) {
                if (node.value == targetValue) {
                    collector = collector.copy(first = node.lChild, second = node.rChild)
                } else {
                    recursiveFind(node.lChild, targetValue)
                    recursiveFind(node.rChild, targetValue)
                }
            }
        }
        recursiveFind(_root, node.value)
        return collector
    }

    fun left(value: T, branch: BinaryTreeCollection<T>.() -> Unit = {}) {
        val tree = BinaryTreeCollection(value)
        branch.invoke(tree)
        _root.lChild = tree.rootNode
    }

    fun right(value: T, branch: BinaryTreeCollection<T>.() -> Unit = {}) {
        val tree = BinaryTreeCollection(value)
        branch.invoke(tree)
        _root.rChild = tree.rootNode
    }

    // ------- Nodes ----------

    override val rootNode: Tree.Node<T>
        get() = _root

    override fun preOrderIterative(): List<T> {
        val visit = mutableListOf<Tree.Node<T>?>()
        val preOrder = mutableListOf<T>()

        var current: Tree.Node<T>? = _root

        while (current != null || visit.isNotEmpty()) {
            val node = current
            if (node != null) {
                preOrder.add(node.value)
                visit.add(node)
                current = node.lChild
            } else {
                val parent = visit.removeLast()
                current = parent?.rChild
            }
        }
        return preOrder
    }

    override fun inOrderNodes(): List<Tree.Node<T>> {
        val collector = mutableListOf<Tree.Node<T>>()
        fun recursivePreorder(node: Tree.Node<T>?, collector: MutableList<Tree.Node<T>>) {
            if (node != null) {
                recursivePreorder(node.lChild, collector)
                collector.add(node)
                recursivePreorder(node.rChild, collector)
            }
        }
        recursivePreorder(_root, collector)
        return collector
    }

    override fun postOrderNodes(): List<Tree.Node<T>> {
        val collector = mutableListOf<Tree.Node<T>>()
        fun recursivePreorder(node: Tree.Node<T>?, collector: MutableList<Tree.Node<T>>) {
            if (node != null) {
                recursivePreorder(node.lChild, collector)
                recursivePreorder(node.rChild, collector)
                collector.add(node)
            }
        }
        recursivePreorder(_root, collector)

        return collector
    }

    override fun preOrderNodes(): List<Tree.Node<T>> {
        val collector = mutableListOf<Tree.Node<T>>()
        fun recursivePreorder(node: Tree.Node<T>?, collector: MutableList<Tree.Node<T>>) {
            if (node != null) {
                collector.add(node)
                recursivePreorder(node.lChild, collector)
                recursivePreorder(node.rChild, collector)
            }
        }
        recursivePreorder(_root, collector)
        return collector
    }

    // -------- Values --------

    override val root: T
        get() = _root.value

    override fun inOrder(): List<T> = inOrderNodes().map { it.value }
    override fun postOrder(): List<T> = postOrderNodes().map { it.value }
    override fun preOrder(): List<T> = preOrderNodes().map { it.value }
}

