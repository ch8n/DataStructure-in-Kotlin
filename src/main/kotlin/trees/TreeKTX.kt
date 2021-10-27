package trees

fun main() {
    /***
     *  buildTree {
     *      root(1){
     *          leftNode = node(1){
     *              leftNode = node(3) {}
     *              rightNode = node(4) {}
     *          }
     *          rightNode = node(2){
     *              rightNode = node(5)
     *          }
     *      }
     *  }
     */

    val tree = buildTree {
        root(1) {

        }
    }
    println(tree.root)

}

