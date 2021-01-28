package linkedlist.linear

// ---------- Linked Collection KTX ---------------




//

// val LinkedList<Int>.isSortedAscending: Boolean
//     get() {
//         var current = firstOrNull
//         var next = firstOrNull
//         while (current != null && next != null) {
//             val isAscending = (current.value ?: Int.MIN_VALUE) <= (next.value ?: Int.MIN_VALUE)
//             if (!isAscending) {
//                 return false
//             }
//             current = next
//             next = current.next
//         }
//         return true
//     }
//
// val LinkedList<Int>.isSortedDescending: Boolean
//     get() {
//         var current = firstOrNull
//         var next = firstOrNull
//         while (current != null && next != null) {
//             val isDescending = (current.value ?: Int.MIN_VALUE) >= (next.value ?: Int.MIN_VALUE)
//             if (!isDescending) {
//                 return false
//             }
//             current = next
//             next = current.next
//         }
//         return true
//     }
//
// val <T> LinkedList<T>.isCyclic: Boolean
//     get() {
//         TODO()
//     }
//
// fun <T> LinkedList<T>.forEach(iteration: (element: T) -> Unit) {
//     var iterator = firstOrNull
//     while (iterator != null) {
//         iteration.invoke(iterator.value)
//         iterator = iterator.next
//     }
// }
//
// fun <T> LinkedList<T>.toMutableLinkedList(): MutableLinkedList<T> {
//     return LinkedCollection.fromMutable(this)
// }
//
// //TODO test
// fun <T, R> LinkedList<T>.map(emmit: (T) -> R): MutableLinkedList<R> {
//     val mapped = mutableLinkedListOf<R>()
//     var iterator = firstOrNull
//     while (iterator != null) {
//         val value = iterator.value
//         val result = emmit.invoke(value)
//         mapped.insertLast(result)
//         iterator = iterator.next
//     }
//     return mapped
// }
//
//
