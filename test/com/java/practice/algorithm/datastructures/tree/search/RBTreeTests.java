package com.java.practice.algorithm.datastructures.tree.search;

/**
 * 应用广泛
 *
 * 红黑树一样也是平衡二叉搜索树，也是工业界最主要使用的二叉搜索平衡树。但平衡度红黑树没AVL那么好。
 * 一般工业界把红黑树作为一种更通用的平衡搜索数来用，Java用它来实现TreeMap, C++的std::set/map/multimap，nginx中，用红黑树管理timer等
 *
 * 一种二叉查找树，但在每个节点增加一个存储位表示节点的颜色，可以是red或black（非红即黑）。
 * 通过对任何一条从根到叶子的路径上各个节点着色的方式的限制，红黑树确保没有一条路径会比其它路径长出两倍。
 * 它是一种弱平衡二叉树(由于是弱平衡，可以推出，相同的节点情况下，AVL树的高度低于红黑树)，相对于要求严格的AVL树来说，它的旋转次数少，所以对于搜索、插入、删除操作较多的情况下，我们就用红黑树。
 */
public class RBTreeTests {
}
