package alogs


fun main() {

    /***
     *
     *  // TODO how to solve concurrent read write
     *
     *  val graph = graphOf(1,4,5,6,7,8,9)
     *
     *  val visits = mutableListOf<Edge>()
     *  var explored = visit.toList() <<<<<< this is code noise | cause of concurrent read and write
     *  val directEdges = list<Edge>()
     *  var visitIndex = 0
     *
     *  // repeat all steps until all nodes are visited
     *  while(explored.size == graph.size){
     *
     *  // visit a node -> put in visits
     *  val subGraph: Vertex = graph.get(visitIndex)
     *
     *  //  find all the direct edges of visits[index] --> directEdges.addAll(edges)
     *  val directEdges = subGraph.edges
     *
     *  // if --> visit contains directEdges[index] --> don't add to visit
     *  // if --> visit not contains directEdges[index] --> add to visit
     *  val notContainedEdges: List<Edges> = directEdges.filter { !visits.contains(it) }
     *
     *  // add not contained edges to visits
     *  visits.addAll(notContainedEdges)
     *  explored = visit.toList()
     *
     *  //print result of visits
     *  println(explored[visitIndex])
     *  ++visitIndex
     *
     *  }
     *
     *
     *
     */

}
