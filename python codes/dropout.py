import pandas as pd
import numpy as np
import sys

tablename = sys.argv[2]
df = pd.read_csv(tablename)
newtable = sys.argv[1]
program = sys.argv[0]

dropout_list=[]
for arg in sys.argv[3:]:
    dropout_list.append(arg)
	
def dropout_cols(table):
	table.drop(dropout_list, inplace=True, axis=1)
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


df_out = dropout_cols(df)
if newtable == "true":
	print "true ag"
	df_out.to_csv(newtablename, index=False)
else:
	df_out.to_csv(tablename, index=False)