import sys
import pandas as pd
import numpy as np

program = sys.argv[0]
newtable = sys.argv[1]
tablename = sys.argv[2]
mode = sys.argv[3]
table = pd.read_csv(tablename)

def handle_nan_zero(df):
	df = df.fillna(0)
	return df
	
def handle_nan_median(df):
	df = df.fillna(df.median())
	return df
	
def handle_nan_mean(df):
	df = df.fillna(df.mean())
	return df
	
def handle_nan_delete(df):
	df = df.dropna()
	return df

def handle_nan_mode(df):
	df = df.fillna(df.mode().ix[0])
	return df
	
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

if mode == "zero":
	table_out = handle_nan_zero(table)
if mode == "mean":
	table_out = handle_nan_mean(table)
if mode == "median":
	table_out = handle_nan_median(table)
if mode == "del":
	table_out = handle_nan_delete(table)
if mode == "modusz":
	table_out = handle_nan_mode(table)
	
if newtable == "true":
	table_out.to_csv(newtablename, index=False)
else:
	table_out.to_csv(tablename, index=False)
	

