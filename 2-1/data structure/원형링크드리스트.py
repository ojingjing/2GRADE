class CList :
    class Node:
        def __init__(self.data.link):
            self.data =data
            self.next =link


   def __init__(self):
        self.last = None
        
        
   def insert(self, data):
       newNode = self Node(data,self.last.next)
       if self.last ==None:
           newNode.next = newNode
           self.last = NewNode
       else:
          newNode.next = self.last.next
          self.last.next = newNode
          self.last =newNode

          
  def delete(self):
      if self.last == None:
          return
      elif self.last == self.last.next:
          self.alst = None
      else:
          temp = self.last
          while temp.next !=self.last:
              temp = temp.next
            temp.next =temp.next.next
            self.last =temp

    def printList(self):
        if self.last ==None:
            return
        else:
           temp = self.last.next
           while temp !=self.last:
               print(temp.data)
               temp =temp.next
         print(temp.data)

      #메인코드 시작
      f=CList()
      f.delete()
      f.insert("사과")
      f.insert("체리")
      f.insert("배")
      f.insert("복숭아")
      f.printList()
      f.delete()
      f.printList()
     
