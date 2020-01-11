package com.java.practice.algorithm.datastructures.tree.bst;

import org.junit.jupiter.api.Test;

/**
 * 应用广泛
 * <p>
 * 红黑树一样也是平衡二叉搜索树，也是工业界最主要使用的二叉搜索平衡树。但平衡度红黑树没AVL那么好。
 * 一般工业界把红黑树作为一种更通用的平衡搜索数来用，Java用它来实现TreeMap, C++的std::set/map/multimap，nginx中，用红黑树管理timer等
 * <p>
 * 一种二叉查找树，但在每个节点增加一个存储位表示节点的颜色，可以是red或black（非红即黑）。
 * 通过对任何一条从根到叶子的路径上各个节点着色的方式的限制，红黑树确保没有一条路径会比其它路径长出两倍。
 * 它是一种弱平衡二叉树(由于是弱平衡，可以推出，相同的节点情况下，AVL树的高度低于红黑树)，相对于要求严格的AVL树来说，它的旋转次数少，所以对于搜索、插入、删除操作较多的情况下，我们就用红黑树。
 */
 class RedBlackTreeTests {

    public static class RedBlackTree {

        private static final int R = 0;
        private static final int B = 1;

        private static class Node {

            int key = -1, color = B;
            Node left = nil, right = nil, p = nil;

            Node(int key) {
                this.key = key;
            }
        }

        private static final Node nil = new Node(-1);
        private static Node root = nil;

        static void printTree(Node node) {
            if (node == nil) {
                return;
            }
            printTree(node.left);
            System.out.print(((node.color == R) ? " R " : " B ") + "Key: " + node.key + " Parent: " + node.p.key + "\n");
            printTree(node.right);
        }

        static void printTreepre(Node node) {
            if (node == nil) {
                return;
            }
            System.out.print(((node.color == R) ? " R " : " B ") + "Key: " + node.key + " Parent: " + node.p.key + "\n");
            printTree(node.left);
            printTree(node.right);
        }

        private static Node findNode(Node findNode, Node node) {
            if (root == nil) {
                return null;
            }
            if (findNode.key < node.key) {
                if (node.left != nil) {
                    return findNode(findNode, node.left);
                }
            } else if (findNode.key > node.key) {
                if (node.right != nil) {
                    return findNode(findNode, node.right);
                }
            } else if (findNode.key == node.key) {
                return node;
            }
            return null;
        }

        static void insert(Node node) {
            Node temp = root;
            if (root == nil) {
                root = node;
                node.color = B;
                node.p = nil;
            } else {
                node.color = R;
                while (true) {
                    if (node.key < temp.key) {
                        if (temp.left == nil) {
                            temp.left = node;
                            node.p = temp;
                            break;
                        } else {
                            temp = temp.left;
                        }
                    } else if (node.key >= temp.key) {
                        if (temp.right == nil) {
                            temp.right = node;
                            node.p = temp;
                            break;
                        } else {
                            temp = temp.right;
                        }
                    }
                }
                fixTree(node);
            }
        }

        private static void fixTree(Node node) {
            while (node.p.color == R) {
                Node y = nil;
                if (node.p == node.p.p.left) {
                    y = node.p.p.right;

                    if (y != nil && y.color == R) {
                        node.p.color = B;
                        y.color = B;
                        node.p.p.color = R;
                        node = node.p.p;
                        continue;
                    }
                    if (node == node.p.right) {
                        node = node.p;
                        rotateLeft(node);
                    }
                    node.p.color = B;
                    node.p.p.color = R;
                    rotateRight(node.p.p);
                } else {
                    y = node.p.p.left;
                    if (y != nil && y.color == R) {
                        node.p.color = B;
                        y.color = B;
                        node.p.p.color = R;
                        node = node.p.p;
                        continue;
                    }
                    if (node == node.p.left) {
                        node = node.p;
                        rotateRight(node);
                    }
                    node.p.color = B;
                    node.p.p.color = R;
                    rotateLeft(node.p.p);
                }
            }
            root.color = B;
        }

        static void rotateLeft(Node node) {
            if (node.p != nil) {
                if (node == node.p.left) {
                    node.p.left = node.right;
                } else {
                    node.p.right = node.right;
                }
                node.right.p = node.p;
                node.p = node.right;
                if (node.right.left != nil) {
                    node.right.left.p = node;
                }
                node.right = node.right.left;
                node.p.left = node;
            } else {
                Node right = root.right;
                root.right = right.left;
                right.left.p = root;
                root.p = right;
                right.left = root;
                right.p = nil;
                root = right;
            }
        }

        static void rotateRight(Node node) {
            if (node.p != nil) {
                if (node == node.p.left) {
                    node.p.left = node.left;
                } else {
                    node.p.right = node.left;
                }

                node.left.p = node.p;
                node.p = node.left;
                if (node.left.right != nil) {
                    node.left.right.p = node;
                }
                node.left = node.left.right;
                node.p.right = node;
            } else {
                Node left = root.left;
                root.left = root.left.right;
                left.right.p = root;
                root.p = left;
                left.right = root;
                left.p = nil;
                root = left;
            }
        }

        static void transplant(Node target, Node with) {
            if (target.p == nil) {
                root = with;
            } else if (target == target.p.left) {
                target.p.left = with;
            } else
                target.p.right = with;
            with.p = target.p;
        }

        static Node treeMinimum(Node subTreeRoot) {
            while (subTreeRoot.left != nil) {
                subTreeRoot = subTreeRoot.left;
            }
            return subTreeRoot;
        }

        static boolean delete(Node z) {
            if ((z = findNode(z, root)) == null)
                return false;
            Node x;
            Node y = z;
            int yorigcolor = y.color;

            if (z.left == nil) {
                x = z.right;
                transplant(z, z.right);
            } else if (z.right == nil) {
                x = z.left;
                transplant(z, z.left);
            } else {
                y = treeMinimum(z.right);
                yorigcolor = y.color;
                x = y.right;
                if (y.p == z)
                    x.p = y;
                else {
                    transplant(y, y.right);
                    y.right = z.right;
                    y.right.p = y;
                }
                transplant(z, y);
                y.left = z.left;
                y.left.p = y;
                y.color = z.color;
            }
            if (yorigcolor == B)
                deleteFixup(x);
            return true;
        }

        static void deleteFixup(Node x) {
            while (x != root && x.color == B) {
                if (x == x.p.left) {
                    Node w = x.p.right;
                    if (w.color == R) {
                        w.color = B;
                        x.p.color = R;
                        rotateLeft(x.p);
                        w = x.p.right;
                    }
                    if (w.left.color == B && w.right.color == B) {
                        w.color = R;
                        x = x.p;
                        continue;
                    } else if (w.right.color == B) {
                        w.left.color = B;
                        w.color = R;
                        rotateRight(w);
                        w = x.p.right;
                    }
                    if (w.right.color == R) {
                        w.color = x.p.color;
                        x.p.color = B;
                        w.right.color = B;
                        rotateLeft(x.p);
                        x = root;
                    }
                } else {
                    Node w = x.p.left;
                    if (w.color == R) {
                        w.color = B;
                        x.p.color = R;
                        rotateRight(x.p);
                        w = x.p.left;
                    }
                    if (w.right.color == B && w.left.color == B) {
                        w.color = R;
                        x = x.p;
                        continue;
                    } else if (w.left.color == B) {
                        w.right.color = B;
                        w.color = R;
                        rotateLeft(w);
                        w = x.p.left;
                    }
                    if (w.left.color == R) {
                        w.color = x.p.color;
                        x.p.color = B;
                        w.left.color = B;
                        rotateRight(x.p);
                        x = root;
                    }
                }
            }
            x.color = B;
        }
    }

    @Test
    void insertDemo() {
        while (true) {
            System.out.println("Add items");
            int item;
            RedBlackTree.Node node;
            item = 9;
            while (item != -999) {
                node = new RedBlackTree.Node(item);
                RedBlackTree.insert(node);
                item = 10;
            }
            RedBlackTree.printTree(RedBlackTree.root);
            System.out.println("Pre order");
            RedBlackTree.printTreepre(RedBlackTree.root);
            break;
        }
    }

    @Test
    void deleteDemo() {
        int item;
        RedBlackTree.Node node;
        item = 9;
        node = new RedBlackTree.Node(item);
        System.out.print("Deleting item " + item);
        if (RedBlackTree.delete(node)) {
            System.out.print(": deleted!");
        } else {
            System.out.print(": does not exist!");
        }
        System.out.println();
        RedBlackTree.printTree(RedBlackTree.root);
        System.out.println("Pre order");
        RedBlackTree.printTreepre(RedBlackTree.root);
    }
}
