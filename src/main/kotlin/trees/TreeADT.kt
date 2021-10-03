package trees


interface ReadTree<T> {
    val root: T
    fun levelOrder(): List<T>
    fun postOrder(): List<T>
    fun preOrder(): List<T>
    fun inOrder(): List<T>
}


