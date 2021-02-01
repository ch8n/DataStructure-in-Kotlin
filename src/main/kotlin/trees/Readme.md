# TODO

1. CREATE
2. READ
3. UPDATE
4. DELETE


# Tress Data Structure
- Tree is Collection of `nodes` + `edge`
    - one of node is `root node`
    - rest of nodes are `dis-joint subset`
        - each subset is tree again
- if `n` nodes then `n-1` edges 
        - cause `root node` have `2` edges not `3` 
    - each subset is a tree or sub-tree   
    
## Terminology of Trees    
- Root - topmost node of tree
- Parent - node is parent to the descendants nodes
- Child - node which have a parent
- Siblings - parent of same parent
- Descendants - all the nodes than can be reached `under` a node in tree
- Ancestors - all the nodes `up` from `that node` to `root node` is ancestors
- Degree of node - `number of direct children` a node has [❌ descendants]
- Internal/External nodes `|` non-leaf/leaf `|` terminal/non-terminal nodes 
    - node with `degree 0` are external/leaf/terminal node
    - node with `degree > 0` are interal/non-leaf/non-terminal node
- levels - horizontal nodes/floor of nodes [starts with 1] - count path to reach a node
- height - floor of node [starts with 0] - number of edges
- forest - collection of trees


```
                                                    | Levels    |   Height
                              (A)  <- root node     |   1       |     0
                              / \                   |           |
             child node ->  (B) (C)  <- child node  |   2       |     1
                            / \                     |           |
            child node -> (D) (F) <- child node     |   3       |     2
                                                    |           |
--------------------------------------------------------------------------------
 [Root]
   A
--------------------------------------------------------------------------------
[Parent]
A - Parent -> B, C 
B - Parent -> D, F 
--------------------------------------------------------------------------------
[Child]             |        [Siblings]         |      [Descendants]
B - Child -> A      |       B,C -> Siblings     |   A - descendants -> B,C,D,F 
C - Child -> A      |       D,F -> Siblings     |   B - descendants -> D,F
D - Child -> B      |                           |   
F - Child -> B      |                           |
--------------------------------------------------------------------------------
   [Ancestors]          |       [Degree]        |   [internal/external-nodes]
D - ancestors -> B,A    |   A - degree -> 2     |     A - internal/non-leaf
F - ancestors -> B,A    |   B - degree -> 2     |     B - internal/non-leaf
B - ancestors -> A      |   C - degree -> 0     |     C - external/leaf
C - ancestors -> A      |   D - degree -> 0     |     D - external/leaf
                        |   F - degree -> 0     |     F - external/leaf
--------------------------------------------------------------------------------

```

## Binary Tree
A tree of degree `2` - i.e. max it can have 2 children node, can `have less than 2` but more than 2.
```
    degree(T) = 2                       (A)
    children = {0,1,2}                  / \     [Binary tree]
                                      (B) (C)
```