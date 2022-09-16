class BST:
    class Node:
        def __init__(self, key):
            self.key = key
            self.left = None
            self.right = None

    # BST 객체의 핵심 객체 변수 정의
    def __init__(self):
        self.root = None

    # BST 객체의 도구 함수들
    def get(self, key):             # 키 값이 key인 노드를 찾기
        node = self.recGet(self.root, key)
        if node is not None:
            return node.key

    def recGet(self, node, key):    # 키 값이 key인 노드를 리커시브로 찾는 내부 함수
        if node == None:
            return None
        elif node.key == key:
            return node
        elif key < node.key:
            return self.recGet(node.left, key)
        elif key > node.key:
            return self.rectGet(node.right, key)

    def put(self, key):                     # 키 값이 key인 노드를 넣기
        self.root = self.recPut(self.root, key)

    def recPut(self, node, key):    # 키 값이 key인 노드를 리커시브로 넣는 내부 함수
        if node is None:
            return self.Node(key)         
        elif key == node.key:
            return node
        elif key < node.key:
            node.left = self.recPut(node.left, key)
            return node
        elif key > node.key:
            node.right = self.recPut(node.right, key)
            return node

    def delete(self, key):        # 키 값이 key인 노드를 빼기
        self.root = self.recDelete(self.root, key)

    def recDelete(self, node, key): # 키 값이 key인 노드를 리커시브로 빼는 내부 함수
        if node is None:
            return None
        elif key < node.key:
            node.left = self.recDelete(node.left, key)
            return node
        elif key > node.key:
            node.right = self.recDelete(node.right, key)
            return node
        elif key == node.key:
            if node.left is None and node.right is None:        # case 1
                return None
            elif node.left is None:         # case 2
                return node.right
            elif node.right is None:        # case 2
                return node.left
            else:                                   # case 3
                newNode = self.Node(None)
                newNode.left = node.left
                minNode =  self.minimum(node.right)
                newNode.key = minNode.key
                newNode.right = self.deleteMin(node.right)
                return newNode

    def minimum(self, node):
        if node.left is None:
            return node
        else:
            return self.minimum(node.left)

    def deleteMin(self, node):
        if node.left is None:
            return node.right
        else:
            node.left = self.deleteMin(node.left)
            return node

#    def preorder(self):

    def inorder(self):
        self.recInorder(self.root)

    def recInorder(self, node):
        if node is None:
            return
        else:
            self.recInorder(node.left)
            print(node.key)
            self.recInorder(node.right)

#    def postorder(self):

#    def levelorder(self):

    def size(self):
        return self.recSize(self.root)

    def recSize(self, node):
        if node is None:
            return 0
        else:
            return 1 + self.recSize(node.left) + self.recSize(node.right)

    def height(self):
        return self.recHeight(self.root)

    def recHeight(self, node):
        if node is None:
            return 0
        else:
            return 1 + max(self.recHeight(node.left), self.recHeight(node.right))

﻿

# 메인 콘솔 코드
tree = BST()
tree.put(8)
tree.put(5)
tree.put(9)
tree.put(3)
tree.put(7)
tree.inorder()
tree.delete(3)
tree.inorder()
print(tree.get(3))
print(tree.size())
print(tree.height())
