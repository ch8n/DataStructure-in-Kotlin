<h1 align="center">Self Implemented DataStructure-in-Kotlin <a href="https://chetangupta.net/bbk-main" target="_blank">BigBrainKotlin</a>
</h1>

![Big-Brain-Kotlin](../../../../../bigBrain.jpg)

## :hand: About
Hola Amigos! 🙌, welcome to my Kotlin Data-structure playground!
Here I'm doing my learning and research on data structures and implementing them myself using Kotlin, you are welcome to explore around 👩‍💻 

Do let me know if you find something useful or want to suggest some improvement
also don't forget to checkout of blogs at [`chetangupta.net`](https://chetangupta.net/)

I also have special [`Big-Brain-Kotlin Series`](https://chetangupta.net/bbk-main) on going which teaches Kotlin stdlib, 
for solving problems.

## :book: Content : Self Implemented LinkedList
Test Code for Implementation
* [Linked-List-Test](../../../../test/kotlin/linkedlist)

## Design Decisions

### Read Only Linked List
Checkout test-cases for behaviour understanding
```Kotlin
interface LinkedList<T> : Iterable<T> {
    val firstOrNull: T?
    val lastOrNull: T?
    val size: Int
    fun isEmpty(): Boolean
    fun get(index: Int): T?
}
```
### Read/Write Linked List i.e MutableLinked List
Checkout test-cases for behaviour understanding
```Kotlin
interface MutableLinkedList<T> :
    InsertLinkedList<T>,
    DeleteLinkedList<T>,
    LinkedList<T>,
    UpdateLinkedList<T>
```

### Insert Operations in Linked List
Checkout test-cases for behaviour understanding
```Kotlin
interface InsertLinkedList<T> {
    fun insertFirst(data: T)
    fun insertLast(data: T)
    fun insertAt(index: Int, data: T)
    fun insertAll(linkedList: LinkedList<T>)
}
```

### Delete Operations in Linked List
Checkout test-cases for behaviour understanding
```Kotlin
interface DeleteLinkedList<T> {
    fun deleteFirst()
    fun deleteLast()
    fun deleteAt(index: Int)
    fun delete(element: T)
}
```
### Update Operations in Linked List
**WIP**
Checkout test-cases for behaviour understanding
```Kotlin
interface UpdateLinkedList<T> {
    fun replace(index: Int, data: T)
    fun sort(isDescending: Boolean = false)
    fun reverse()
    fun distinct()
}
```


## :eyes: Social
[LinkedIn](https://bit.ly/ch8n-linkdIn) | 
[Medium](https://bit.ly/ch8n-medium-blog) | 
[Twitter](https://bit.ly/ch8n-twitter) | 
[StackOverflow](https://bit.ly/ch8n-stackOflow) | 
[CodeWars](https://bit.ly/ch8n-codewar) |
[WorkX](https://bit.ly/ch8n-home) |
[Github](https://bit.ly/ch8n-git) |
[Instagram](https://bit.ly/ch8n-insta) |
[Youtube](https://bit.ly/ch8n-youtube) 


## :cop: License
```
   Copyright [2020] [Chetan gupta] [chetangupta.net]
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 ```

