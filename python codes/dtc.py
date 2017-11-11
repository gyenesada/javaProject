import sys
import pandas as pd
import numpy as np
from sklearn.tree import DecisionTreeClassifier

# python dtc.py book.csv target 3 param1 param2 param3 2 feat1 feat2 1 out1
program =  sys.argv[0] #dtc.py
tablename = sys.argv[1] #book.csv
params = int(sys.argv[3]) #3
target = sys.argv[2]
parameters=[]
i = 1
while (i <= params):
	parameters.append(sys.argv[3+i])
	i+=1
features = []
feat = int(sys.argv[4+params])
j = 1
while (j<=feat):
	features.append(sys.argv[4+params+j])
	j=j+1
	
outcols = []
out = int(sys.argv[5+params+feat])
k = 1
while (k<=out):
	outcols.append(sys.argv[5+params+feat+k])
	k=k+1


	
df = pd.read_csv(tablename);

generated = np.random.rand(len(df))<0.8
train = df[generated]
test = df[~generated]

target = sys.argv[2]
features = sys.argv[3:]

clf = DecisionTreeClassifier(max_depth = 2) #param
clf.fit(train[features].values, df[target].values)

predictions = clf.predict(test[features].values)
'''
