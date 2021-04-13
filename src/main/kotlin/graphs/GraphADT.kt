package graphs

abstract class AbstractGraph<T> {
    data class Edges<T>(val pointsTo: Vertex<T>)
    data class Vertex<T>(val data: T, val edges: List<Edges<T>>)
}

interface Graph<T> {
    fun breadthTraversal()
    fun depthTraversal()
}

interface MutableGraph<T> : Graph<T>

class GraphCollection
