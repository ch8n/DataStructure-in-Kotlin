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
        right("z") {
            right("x")
        }
    }

    //println(tree.root) // a
    println(tree.preOrder()) // [a, b, c, d, z, x]
    // println(tree.postOrder()) // [c, d, b, x, z, a]
    // println(tree.inOrder()) // [c, b, d, a, z, x]
    println(tree.preOrderIterative())
}


