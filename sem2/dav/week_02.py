# Week 2 - Lists, Tuples, Dictionaries, Sets

# ── Lab Manual ────────────────────────────────────────────────────────────────

# 1. Input numbers into a list; find largest, smallest, sum, average
n = int(input("Enter the number of elements: "))
l = []
sum = 0
for i in range(n):
    x = int(input("Enter element: "))
    sum += x
    l.append(x)
print("The list:", l)
l.sort()
print("Largest element:", l[n - 1])
print("Smallest element:", l[0])
print("Sum:", sum)
print("Average:", sum / n)


# 2. Create a tuple with five elements and demonstrate immutability
l = []
for i in range(5):
    x = int(input("Enter element: "))
    l.append(x)
print(tuple(l))
# The statement below will result in an error because tuple is immutable
# tup[2] = 2


# 3. Dictionary of Cricket World Cup winners
d = {}
n = int(input("Enter the number of Cricket World Cup Winners: "))
for i in range(n):
    key = int(input("Enter the year: "))
    val = input("Enter the country: ")
    d[key] = val
print(d)

count = {}
for i in d.values():
    if i in count:
        count[i] += 1
    else:
        count[i] = 1
best = max(count, key=count.get)
print("The best performing country is:", best)
unique = list(count.keys())
print("Unique countries:", unique)


# 4. Count word frequency in a sentence
str = input("Enter a sentence: ")
words = str.split()
count = {}
for i in words:
    n = words.count(i)
    count[i] = [n]
print(count)


# 5. Set operations: union, intersection, difference
s1 = set()
n1 = int(input("Enter the number of elements in set 1: "))
for i in range(n1):
    x = int(input("Enter the element: "))
    s1.add(x)

s2 = set()
n2 = int(input("Enter the number of elements in set 2: "))
for i in range(n2):
    y = int(input("Enter the element: "))
    s2.add(y)

union = s1 | s2
intersection = s1 & s2
difference = s1 - s2
print("Union of the two sets is", union)
print("Intersection of the two sets is", intersection)
print("Difference of the two sets is", difference)


# ── Additional Questions ──────────────────────────────────────────────────────

# 1. Return the longest string from a list
l = []
c = 0
n = int(input("Enter the number of strings: "))
for i in range(n):
    s = input("Enter the string: ")
    count = len(s)
    if count > c:
        c = count
        longest = s
    l.append(s)
print(l)
print("Longest String:", longest)


# 2. Return elements greater than 5
l = []
l1 = []
n = int(input("Enter the number of elements: "))
for i in range(n):
    x = int(input("Enter integer: "))
    l.append(x)
    if x > 5:
        l1.append(x)
print(l)
print(l1)


# 3. Swap two numbers using a tuple
a = int(input("Enter a: "))
b = int(input("Enter b: "))
print("a:", a)
print("b:", b)
(b, a) = (a, b)
print("After swapping:")
print("a:", a)
print("b:", b)
