class Circle:
    """ 원 클래스  """
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        r = self.radius
        return r * r * 3.14


class Rectangle:  
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def area(self):
        w = self.width
        h = self.height
        return w * h


r1 = Rectangle(5, 6)
print(r1.width)
print(r1.height)
print(r1.area())
