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
        if node == None:
            return self.Node(key)          
        elif key == node.key:
            return node
        elif key < node.key:
            node.left = self.recPut(node.left, key)
            return node
        elif key > node.key:
            node.right = self.recPut(node.right, key)
            return node

#    def delete(self, key):        # 키 값이 key인 노드를 빼기

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

#    def size(self):

#    def height(self):



# 메인 콘솔 코드
tree = BST()
tree.put(8)
tree.put(5)
tree.put(9)
tree.put(3)
tree.put(7)
tree.inorder()
print(tree.get(3))
