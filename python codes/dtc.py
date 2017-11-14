import sys
import pandas as pd
import numpy as np
from sklearn.tree import DecisionTreeClassifier

program =  sys.argv[0] #dtc.py
tablename = sys.argv[1] #book.csv
original = sys.argv[2]
params = int(sys.argv[4])
target = sys.argv[3]

parameters=[]
i = 1
while (i <= params):
	parameters.append(sys.argv[4+i])
	i+=1
features = []
feat = int(sys.argv[5+params])
j = 1
while (j<=feat):
	features.append(sys.argv[5+params+j])
	j=j+1
	
outcols = []
out = int(sys.argv[6+params+feat])
k = 1
while (k<=out):
	outcols.append(sys.argv[6+params+feat+k])
	k=k+1

if parameters[0]=="false":
	presort = False
else:
	presort = True
	
print presort
max_depth = int(parameters[1])
random_state = int(parameters[2])
	
df = pd.read_csv(tablename)
dfo = pd.read_csv(original)

generated = np.random.rand(len(df))<0.8
train = df[generated]
test = df[~generated]

clf = DecisionTreeClassifier(max_depth = max_depth) 
clf.fit(train[features].values, train[target].values)

predictions = clf.predict(test[features].values)