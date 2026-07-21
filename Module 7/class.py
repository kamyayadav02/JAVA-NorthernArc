class calculator:
    #constructor
    #self-> refers to the current object
    def __init__(self,x,y):
        self.x=x
        self.y=y
    def add(self):
        return self.x+self.y
    
    c=calculator(10,20)
    result=c.add()
    print(result)


#constructor
