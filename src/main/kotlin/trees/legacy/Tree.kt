package trees.legacy

import com.google.gson.Gson

class Tree {

    data class Node(
        val value: Int,
        var leftChild: Node? = null,
        var rightChild: Node? = null
    )

    private val buffer = mutableListOf<Node>()

    init {
        val tree = addRootNode()
        while (buffer.isNotEmpty()) {
            val node = buffer.removeAt(0)
            addLeftChild(node)
            addRightChild(node)
        }
        println(Gson().toJson(tree))
    }

    private fun addRootNode(): Node {
        println("Enter Root value :")
        val root = requireNotNull(readLine()?.toInt())
        val node = Node(value = root)
        buffer.add(node)
        return node
    }

    private fun addLeftChild(parent: Node) {
        println("Enter Left-Child for ${parent.value} :")
        val left = readLine()?.toIntOrNull()
        if (left != null) {
            val leftChild = Node(value = left)
            parent.leftChild = leftChild
            buffer.add(leftChild)
        }
    }

    private fun addRightChild(parent: Node) {
        println("Enter Right-Child for ${parent.value} :")
        val right = readLine()?.toIntOrNull()
        if (right != null) {
            val rightChild = Node(value = right)
            parent.rightChild = rightChild
            buffer.add(rightChild)
        }
    }
}

fun main(){
    val tree = Tree()
}