package trees

abstract class Tree<T> {
    data class Node<T>(var value: T, var lChild: Node<T>? = null, var rChild: Node<T>? = null)
}

interface BinaryTree<T> {
    val root: T
    fun inOrder(): List<T>
    fun postOrder(): List<T>
    fun preOrder(): List<T>
    fun preOrderIterative(): List<T>
}

interface MutableBinaryTree<T> {
    val rootNode: Tree.Node<T>
    fun inOrderNodes(): List<Tree.Node<T>>
    fun postOrderNodes(): List<Tree.Node<T>>
    fun preOrderNodes(): List<Tree.Node<T>>
    fun directChildren(node: Tree.Node<T>): Pair<Tree.Node<T>?, Tree.Node<T>?>
}

