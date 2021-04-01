package trees

// ---------ADT--------------

interface BinaryTree<T> {

}

interface InsertTree<T> {
    fun addLeaf(leaf: Branch.Leaf<T>)
}

interface MutableBinaryTree<T> :
    BinaryTree<T>,
    InsertTree<T>

// ---------Collection--------------

class BinaryTreeCollection<T> : MutableBinaryTree<T> {

    private var _root: Branch.Leaf<T>? = null
    private val leafs = mutableListOf<Branch.Leaf<T>>()
    val rootOrNull: Branch.Leaf<T>?
        get() = _root

    override fun addLeaf(leaf: Branch.Leaf<T>) {
        if (_root == null) {
            _root = leaf
        }
        leafs.add(leaf)
        leafs.forEach {

        }
    }
}

/**
root() {
left() {

}

right() {

}
}

 **/

abstract class Branch<T> {
    data class Leaf<T>(var value: T, val left: Leaf<T>? = null, val right: Leaf<T>? = null)
}

class TreeADT<T> {

    fun left(value: T): Branch.Leaf<T> {
        return Branch.Leaf(value)
    }

    fun right(value: T): Branch.Leaf<T> {
        return Branch.Leaf(value)
    }

    fun root(value: T, function: TreeADT<T>.() -> Pair<Branch.Leaf<T>, Branch.Leaf<T>>): Branch.Leaf<T> {
        val rootValue = value
        val (lChild, rChild) = function.invoke(TreeADT())
        return Branch.Leaf(rootValue, lChild, rChild)
    }
}

fun <T> tree(action: TreeADT<T>.() -> Unit) {
    action.invoke(TreeADT())
}

fun main() {
    tree<Int> {
        val test = root(1) {
            val lChild = left(2)
            val rChild = right(3)
            lChild to rChild
        }

        println(test)
    }
}


