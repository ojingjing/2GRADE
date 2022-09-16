class Queue:
    class Node:
        def __init__(self,data,link):
            self.data =data
            self.before = link
            
       def __init__(self):
           self.front =None
           self.rear=None

      def enqueue(self,data):
          newNode =self.Node(data,None)
          if self.rear ==None:
              self.front =newNode
              self.rear =newNode
          else:
              
