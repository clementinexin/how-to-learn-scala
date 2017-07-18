package functionalthinking.ch3

/**
 * Created by dj on 2017/7/11.
 */
class Employee {
    def name,salary
}

def paidMore(amount) {
    return {functionalthinking.ch3.Employee e -> e.salary > amount}
}

isHighPaid = paidMore(100000)

def Smithers = new Employee(name:"Fred", salary:120000)
def Homer = new Employee(name:"Homer", salary:80000)
println isHighPaid(Smithers)
println isHighPaid(Homer)

isHigherPaid = paidMore(200000)
println isHigherPaid(Smithers)
println isHigherPaid(Homer)
def Burns = new Employee(name:"Monty", salary:1000000)
println isHigherPaid(Burns)


def Closure counter() {
    def local_variable = 0
    return {return local_variable +=1}
}

c1 = counter()
c1()
c1()
c1()
c1()

c2 = counter()
c2()
c2()

println "C1 = ${c1()} ,C2 = ${c2()}"


def product = {x,y -> x*y}

def quadrate = product.curry(4)
def octate = product.curry(8)

println "4x4 : ${quadrate.call(4)}"
println "8x4 : ${octate(4)}"

def volume = {h,w,l -> h * w * l};

def area = volume.curry(1)
def lengthPA = volume.curry(1,1)
def lengthC = volume.curry(1).curry(1)

println "2x3x4的体积，   ${volume(2, 3, 4)}"
println "3x4的面积  ，   ${area(3, 4)}"
println "参数6的长度 ，   ${lengthPA(6)}"
println "参数6的长度 ，   ${lengthC(6)}"

def composite = {f,g,x -> f(g(x))}
def times32 = composite.curry(quadrate,octate)
println "32 * 2 : ${times32(2)}"