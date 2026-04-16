# Week 1 - Python Basics Demo and Lab Exercises

# ── Demo ──────────────────────────────────────────────────────────────────────

print("Hello, World!")

a = 2
b = 3
c = a + b
print("c=", c)

print(a / b)
print(a // b)

x = 0.345
y = 6.8e-4
print(x + y)

str_a = "This is my first Python class"
str_b = """String that spans
Multiple Lines
"""
print(str_b)

str_b.count("\n")

str_c = str_a.replace("class", "demonstration")
print(str_c)

bool_a = True
bool_b = False

int_ = 1
bool_c = bool(int_)
print(bool_c)
print(type(int_))
print(type(bool_c))


def fn(a, b, c=None):
    result = a + b
    if c is not None:
        result = result * c
    return result


print(fn(1, 2, None))

x = -5
if x < 0:
    print("It's negative")

x = 5
if x < 0:
    print("It's negative")
elif x == 0:
    print("Equal to zero")
elif 0 < x < 5:
    print("Positive but smaller than 5")
else:
    print("Positive and larger than or equal to 5")

a = [1, 2, None, 4, None, 5]
tot = 0
for i in a:
    if i is None:
        continue
    tot += i
print(tot)

a = [1, 2, 0, 4, 6, 5, 2, 1]
tot = 0
for i in a:
    if i == 5:
        break
    tot += i
print(tot)

x = 256
tot = 0
while x > 0:
    if tot > 500:
        break
    tot += x
    x = x // 2
print(tot)

x = 0
if x < 0:
    print("negative!")
elif x == 0:
    pass
else:
    print("positive!")

print(list(range(10)))

a = [1, 2, 3, 4]
for i in range(len(a)):
    print(a[i])


# ── Lab Manual ────────────────────────────────────────────────────────────────

# 1. Input two numbers and perform calculations
def calculations(x, y):
    print("Addition:", x + y)
    print("Subtraction:", x - y)
    print("Multiplication:", x * y)
    print("Division:", x / y)


a = int(input("Enter an integer: "))
b = int(input("Enter an integer: "))
calculations(a, b)


# 2. Check if a number is prime
def prime(a):
    f = 1
    for i in range(2, a):
        if a % i == 0:
            f = 0
            break
    return f == 1


x = int(input("Enter an integer: "))
print(prime(x))


# 3. Print odd numbers between 1-100 and sum of even numbers
sum = 0
for i in range(101):
    if i % 2 == 0:
        sum += i
    else:
        print(i)
print("Sum:", sum)


# 4. Add two elements and display the result
def add(a, b):
    return a + b


x = input("Enter an element: ")
y = input("Enter an element: ")
print(add(x, y))


# 5. Count vowels and consonants in a string
def countstring(a):
    v = 0
    c = 0
    for i in a:
        if i in ['a', 'e', 'i', 'o', 'u']:
            v += 1
        else:
            c += 1
    print("Vowel Count:", v)
    print("Consonant Count:", c)


x = input("Enter a string: ")
countstring(x)
