import sys
import pandas as pd
import numpy as np
import time as t 
cpu_start = t.clock() 
real_start = t.time()

from sklearn import metrics as ms
from sklearn.ensemble import AdaBoostClassifier

program = sys.argv[0]
tablename = sys.argv[1]
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
	
n_estimators = int(parameters[0])
learning_rate = float(parameters[1])
algorithm = parameters[2]
random_state = int(parameters[3])
	
df = pd.read_csv(tablename)
dfo = pd.read_csv(original)

generated = np.random.rand(len(df))<0.8
train = df[generated]
test = df[~generated]
or_test = dfo[~generated]


trainvalues = train[target].values.tolist()
testvalues = test[target].values.tolist()
for i in range(len(trainvalues)):
	trainvalues[i] = trainvalues[i]*100.0
	
for i in range(len(testvalues)):
	testvalues[i] = testvalues[i]*100.0

train[target] = trainvalues
train[target] = train[target].apply(np.int64)	

test[target] = testvalues
test[target] = test[target].apply(np.int64)

if random_state==0:
	clf = AdaBoostClassifier(n_estimators = n_estimators, algorithm=algorithm, learning_rate=learning_rate) 
else:
	clf = AdaBoostClassifier(n_estimators = n_estimators, algorithm=algorithm, learning_rate=learning_rate, random_state=random_state) 
clf.fit(train[features].values, train[target].values)

predictions = clf.predict(test[features].values)

print ms.accuracy_score(test[target].values,predictions)

def get_prefix(program):
	splitted = program.split("/")
	py = splitted[len(splitted)-1].split(".py");
	prefix = py[0]+"_"
	return prefix

def get_newfile_name(tablename):
	newfilename = get_prefix(program)+get_tablename(tablename)
	return newfilename
	
def get_newfile_path(tablename):
	path = tablename[:len(tablename)-len(get_tablename(tablename))]
	return path
	
def get_tablename(tablename):
	splitted = tablename.split("/")
	return splitted[len(splitted)-1]
	
newtablename = get_newfile_path(tablename) + get_newfile_name(tablename)

df_out = pd.DataFrame(columns=outcols)
df_out[outcols] = or_test[outcols]

float_pred = []
for i in range(len(predictions)):
	float_pred.append(predictions[i]/100.0)
	
df_out[target] = float_pred

df_out.to_csv(newtablename, index=False)

cpu_time = t.clock()-cpu_start
real_time = t.time()-real_start
print('CPU: %s, Valos:%s' %(cpu_time, real_time))