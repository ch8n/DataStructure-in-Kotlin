package linkedlist.linear

// import java.lang.IllegalStateException
//
// // ---------- Mutable List ---------------
// fun MutableLinkedList<Int>.insertInAscendingSorted(data: Int) {
//     val isSorted = isSortedAscending
//     val size = size
//     when {
//         !isSorted -> throw IllegalStateException("List is not sorted")
//         size == 0 -> insertFirst(data)
//         else -> {
//             // head case need to handled separately
//             val first = firstOrNull
//             if ((first?.value ?: -1) > data) {
//                 insertFirst(data)
//                 return
//             }
//
//             // remaining cases
//             val node = Linked.Node(data)
//             var current = firstOrNull?.next
//             var tailing = firstOrNull
//             while (current != null && data > (current.value ?: -1)) {
//                 tailing = current
//                 current = current.next
//             }
//             node.next = current
//             tailing?.next = node
//         }
//     }
// }
//
// fun MutableLinkedList<Int>.distinctSorted() {
//     val isSortedAscending = isSortedAscending
//     val isSortedDescending = isSortedDescending
//     if (!isSortedAscending && !isSortedDescending) {
//         throw IllegalStateException("List isn't sorted")
//     }
//     var tailing = firstOrNull
//     var current = firstOrNull?.next
//     while (current != null && tailing != null) {
//         if (current.value == tailing.value) {
//             tailing.next = current.next
//         } else {
//             tailing = current
//         }
//         current = current.next
//     }
// }
//
