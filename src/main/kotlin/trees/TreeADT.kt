package trees

interface BinaryTree<T> {
    val root: T
    fun preorder(): List<T>
}

abstract class Tree<T> {
    data class Node<T>(var value: T, var lChild: Node<T>? = null, var rChild: Node<T>? = null)
}
