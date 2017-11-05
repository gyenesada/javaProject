import pandas as pd
import sys

tablename = sys.argv[2]
newtable = sys.argv[1]
program = sys.argv[0]
df = pd.read_csv(tablename)

def factorising_string(table):
	strings = list(table.select_dtypes(include=['object']).columns)
	for i in range(len(strings)):
		table[strings[i]] = pd.factorize(table[strings[i]])[0]
	return table
	
def factorising_bools(table):
	booleans = list(table.select_dtypes(include=['bool']).columns)
	for i in range(len(booleans)):
		table[booleans[i]] = pd.factorize(table[booleans[i]])[0]
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

df_out = factorising_bools(factorising_string(df))
if newtable == "true":
	df_out.to_csv(newtablename, index=False)
else:
	df_out.to_csv(tablename, index=False)


#df_out.to_csv('./factorized_'+tablename+'.csv', index=False)
