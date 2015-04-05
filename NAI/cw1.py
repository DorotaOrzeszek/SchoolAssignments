import random
import math

def count_out_progowa_unipolarna(point, w1, w2, b):
	x = point[0]
	y = point[1]
	ans = w1*x + w2*y + b
	return ans

def count_out_sigmoidalna_unipolarna(point, w1, w2, b):
	x = point[0]
	y = point[1]
	u = w1*x + w2*y
	ans = 1.0 / (1 + pow(math.e, u) )
	return ans

w1 = random.uniform(-1,1)
w2 = random.uniform(-1,1)

b = 0

p = []

for i in range(0,50):
	x = random.randint(-5,5)
	y = random.randint(-5,5)
	p.append((x,y))

o1 = []
o2 = []

for point in p:
	ans1 = count_out_progowa_unipolarna(point, w1, w2, b)
	o1.append(ans1)
	ans2 = count_out_sigmoidalna_unipolarna(point, w1, w2, b)
	o2.append(ans2)

c1 = []
c2 = []
'''
0 black
1 blue
2 green
3 yellow
'''
for e in o1:
	if e >= 0:
		c1.append(0)
	else:
		c1.append(3)

for e in o2:
	if e >= 0.75 and e < 1.0:
		c2.append(0)
	elif e >= 0.5 and e < 0.75:
		c2.append(1)
	elif e >= 0.25 and e < 0.5:
		c2.append(2)
	elif e >= 0.0 and e < 0.25:
		c2.append(3)
	else:
		c2.append("-")

print "===== Progowa unipolarna ====="
for i in range(0,50):
	print p[i][0], p[i][1], c1[i]

print "===== Sigmoidalna uniporna ====="

for i in range(0,50):
	print p[i][0], p[i][1], c2[i]

