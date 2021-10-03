package trees

class TreeNode<T>(
    val data: T,
    val isRoot: Boolean = false,
    var leftChild: TreeNode<T>? = null,
    var rightChild: TreeNode<T>? = null
)

fun <T> TreeNode<T>.node(data: T, body: TreeNode<T>.() -> Unit = {}): TreeNode<T> {
    val node = TreeNode(data)
    body(node)
    return node
}

fun <T> root(data: T, body: TreeNode<T>.() -> Unit = {}): TreeNode<T> {
    val root = TreeNode(data, isRoot = true)
    body(root)
    return root
}

fun <T> buildTree(body: () -> TreeNode<T>): ReadTree<T> {
    return TreeDsl(body.invoke())
}



class TreeDsl<T>(private val rootNode: TreeNode<T>) : ReadTree<T> {

    init {
        check(rootNode.isRoot) { "make sure isRoot is true for root node" }
    }

    override val root: T
        get() = rootNode.data

    override fun levelOrder(): List<T> {
        TODO("Not yet implemented")
    }

    override fun postOrder(): List<T> {
        TODO("Not yet implemented")
    }

    override fun preOrder(): List<T> {
        TODO("Not yet implemented")
    }

    override fun inOrder(): List<T> {
        TODO("Not yet implemented")
    }

}



