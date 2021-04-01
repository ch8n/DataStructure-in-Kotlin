package trees

fun <T> binaryTree(root: T, buildTree: BTree<T>.() -> Unit): BTree<T> {
    val tree = BTree(root)
    buildTree.invoke(tree)
    return tree
}

fun main() {
    val tree = binaryTree(1) {
        left(2)
        right(3)
    }
    println(tree.node)
    println(tree.preOrder())
    println(tree.postOrder())
    println(tree.inOrder())
}


