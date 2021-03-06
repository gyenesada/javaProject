import sys
import pandas as pd
import numpy as np

from sklearn import metrics as ms
from sklearn.ensemble import RandomForestClassifier

program =  sys.argv[0]
tablename = sys.argv[1]
original = sys.argv[2]
params = int(sys.argv[4])
target = sys.argv[3]

def get_parameters():
	temps=[]
	i = 1
	while (i <= params):
		temps.append(sys.argv[4+i])
		i+=1
	return temps

parameters = get_parameters()

feat = int(sys.argv[5+params])
def get_features():
	temps=[]
	i = 1
	while (i<=feat):
		temps.append(sys.argv[5+params+i])
		i=i+1
	return temps

features = get_features()

out = int(sys.argv[6+params+feat])
def get_outcols():
	temps=[]
	i = 1
	while (i<=out):
		temps.append(sys.argv[6+params+feat+i])
		i=i+1
	return temps

outcols = get_outcols()

max_depth = int(parameters[0])
n_estimators = int(parameters[1])
random_state = int(parameters[2])
n_jobs = int(parameters[3])

if parameters[4]=="false" or parameters[4] =="False":
	presort = False
else:
	presort = True

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

if max_depth==0:
	clf = RandomForestClassifier(random_state = random_state, n_jobs =n_jobs, n_estimators=n_estimators) 
elif random_state==0:
	clf = RandomForestClassifier(max_depth = max_depth,n_jobs =n_jobs, n_estimators=n_estimators) 
else:
	clf = RandomForestClassifier(max_depth = max_depth, random_state = random_state, n_jobs =n_jobs, n_estimators=n_estimators) 

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