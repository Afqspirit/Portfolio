from itertools import takewhile
z = int(input()) #количество чисел вывода
def fib(a=0, b=1):
    while True:
        yield a
        a, b = b, a+b
  
fibs = takewhile(lambda f: f < 500, fib())
print(list(f for f in fibs if f % 2 == 0)[:z])