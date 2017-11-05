import numpy as np
import pandas as pd
import sys
from sklearn.preprocessing import StandardScaler

program = sys.argv[0]
tablename = sys.argv[2]
newtable = sys.argv[1]
df = pd.read_csv(tablename)

standard_scaler = StandardScaler()

def normalize(table):
	numerics = list(table.select_dtypes(include=[np.number]).columns)
	for i in range(len(numerics)):
		table[numerics[i]] = standard_scaler.fit_transform(table[numerics[i]])
	return table
	
		
def get_prefix(program):
	splitted = program.split("\\")
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
	splitted = tablename.split("\\")
	return splitted[len(splitted)-1]
	
newtablename = get_newfile_path(tablename) + get_newfile_name(tablename)

df_out = normalize(df)
if newtable == "true":
	df_out.to_csv(newtablename, index=False)
else:
	df_out.to_csv(tablename, index=False)
