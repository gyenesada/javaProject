import sys 
import pandas as pd
import numpy as np

from pandas.api.types import is_numeric_dtype

program = sys.argv[0]
tablename = sys.argv[1]

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
	
df = pd.read_csv(tablename)

nullvalues = not(df.isnull().values.any())
print nullvalues

isnumerictype=[]
for i in range(len(features)):
	if is_numeric_dtype(df[features[i]]):
		isnumerictype.append(True)
	else:
		isnumerictype.append(False)

if is_numeric_dtype(df[target]):
	isnumerictype.append(True)
else:
	isnumerictype.append(False)

factorised = all(isnumerictype)

finalboolean = factorised and nullvalues
print finalboolean
#if true, the classifier can start
