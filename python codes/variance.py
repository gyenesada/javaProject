import numpy as np
import pandas as pd
import sys
from sklearn.feature_selection import VarianceThreshold

program = sys.argv[0]
tablename = sys.argv[2]
newtable = sys.argv[1]
th = float(sys.argv[3])
df = pd.read_csv(tablename)
cols = df.columns.values.tolist()
autoremove=True

def feature_selection(dframe):
    X = dframe.loc[:, cols].values
    vt = VarianceThreshold(threshold=th)
    vt.fit(X)
    feature_indices = vt.get_support(indices=True)
    feature_names = [cols[idx] for idx, _ in enumerate(cols) if idx in feature_indices]
    removed_features = list(np.setdiff1d(cols, feature_names))
    X_removed = vt.transform(X)
    dframe = pd.DataFrame(data=X_removed,columns=feature_names)
    return dframe
	
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
	
df_out = feature_selection(df)
if newtable == "true":
	df_out.to_csv(newtablename, index=False)
else:
	df_out.to_csv(tablename, index=False)