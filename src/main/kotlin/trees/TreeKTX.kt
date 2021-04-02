package trees

fun <T> binaryTree(root: T, buildTree: BinaryTreeCollection<T>.() -> Unit): BinaryTree<T> {
    val tree = BinaryTreeCollection(root)
    buildTree.invoke(tree)
    return tree
}

fun <T> mutableBinaryTree(root: T, buildTree: BinaryTreeCollection<T>.() -> Unit): MutableBinaryTree<T> {
    val tree = BinaryTreeCollection(root)
    buildTree.invoke(tree)
    return tree
}



fun main() {
    val tree = binaryTree("a") {
        left("b") {
            left("c")
            right("d")
        }
        right("z"){
            right("x")
        }
    }
    println(tree.root)
    println(tree.preOrder())
    println(tree.postOrder())
    println(tree.inOrder())
}


