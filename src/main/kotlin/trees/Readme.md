# TODO

1. CREATE
2. READ
3. UPDATE
4. DELETE


# Tress Data Structure
- Collection of `nodes` + `edge`
    - one of node is `root node`
    - rest of nodes are `dis-joint subset`
        - each subset is tree again
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
    
```
                              (A)  <- root node 
                              / \
             child node ->  (B) (C)  <- child node
                            / \
            child node -> (D) (F) <- child node
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

- if `n` nodes then `n-1` edges 
        - cause `root node` have `2` edges not `3` 
    - each subset is a tree or sub-tree
