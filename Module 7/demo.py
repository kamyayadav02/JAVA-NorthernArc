print("Hello World")

#single line comment



x=10
print(x)
x="is"
print(x)

#Datatypes
#number-int , float,complex
#string- str
#boolean-Bool(true,false)

x=3.14 #float
print(x)

#multivariable assignment
x=y=z=100
print(x)
print(y)
print(z)

a,b=10,20
print(a)
print(b)
print(type(x))

f=10.35
name="Ram"
isActive=True
print(type(f))
print(type(name))
print(type(isActive))

#operations
#Exponent operator: a**b
a=2
b=5
print(a**b)

#membership operator- in and not in
list=["Apple","Mango","Banana"]
print("Orange" in list)
print("Banana" not in list)

#identity operators- value and memory allocation both are same-> is and is not
a=10
b=10
print(a is b)
c=24
print(a is c)

#swap
i=10
j=20
i,j=j,i
print(i,j)

#type conversion- int(), float(), str(), bool()
x="25"
print(int(x))
print(float(x))
print(str(x))

#isInstance- to check if a particular variable belongs to a particular type
print(isinstance(x,str))

age=20
if(age>18):
    print("You are eligible to vote")
else:
    ("You are not eligible to vote")
    

a =45
b=20
c=50
if a>b:
    if a>              c:
        print("a is greatest")
    else:
        print("a is not the greatest")


#for loop 1-5
for i in range(5):
    print(i)


#while condition
print("Using while loop")
x=i


def greetUser(name,age):
    return f"Hello,{name} is {age} \n old"

def WelcomeUser(name="Guest"):
    return "Welcome" + name

print (greetUser("Ram",20))
print(WelcomeUser())

def printDetails(name,age,college="VIT"):
    return f"{name} is {age} and studies in {college}"
print(printDetails("Ram",22))


#lambda function
#lambda syntax
#lambda arguements: expression
 
square=lambda x:x*x
print(square(5))
