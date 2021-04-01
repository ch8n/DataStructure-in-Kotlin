package trees

// ---------ADT--------------

abstract class Branch<T> {
    data class Leaf<T>(var value: T?, val left: Leaf<T>? = null, val right: Leaf<T>? = null)
}

data class BinaryTree<T>(
    private var value: T,
    var left: Branch.Leaf<T>? = null,
    var right: Branch.Leaf<T>? = null
) {
    fun <T> node(value: T, branch: BinaryTree<T>.() -> Unit = {}): Branch.Leaf<T> {
        val node = BinaryTree(value)
        branch.invoke(node)
        return Branch.Leaf(
            value = node.value,
            left = node.left,
            right = node.right
        )
    }
}

fun <T> tree(root: T, action: BinaryTree<T>.() -> Unit): BinaryTree<T> {
    val tree = BinaryTree(root)
    action.invoke(tree)
    return tree
}

fun main() {
    val test = tree<Int>(0) {
        left = node(1) {
            left = node(2)
        }

    }

    println(test)
}


