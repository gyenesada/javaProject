import sys
import pandas as pd
import numpy as np
import nltk
import re
from sklearn.feature_extraction.text import CountVectorizer
from nltk.stem.porter import PorterStemmer
from sklearn.linear_model import LogisticRegression
from sklearn.cross_validation import train_test_split

program = sys.argv[0]
newtable = bool(sys.argv[1])
tablename = sys.argv[2]
target = sys.argv[3]

train = pd.read_csv('/mnt/disk4/gyenesadrienn/csv/train.csv', nrows=5000)
test = pd.read_csv(tablename)

stemmer = PorterStemmer()
def stem_tokens(tokens, stemmer):
    stemmed =[]
    for item in tokens:
        stemmed.append(stemmer.stem(item))
    return stemmed

def tokenize(text):
    text = re.sub("[^a-zA-Z]", " ", text)
    tokens = nltk.word_tokenize(text)
    stems = stem_tokens(tokens, stemmer)
    return stems
	
vectorizer = CountVectorizer(analyzer='word', tokenizer=tokenize, lowercase = True)
train_values = train['Phrase'].tolist()
test_values = test[target].tolist()

for i in range(len(train_values)):
    train_values[i] = unicode(train_values[i], errors = 'ignore')
	
for i in range(len(test_values)):
    test_values[i] = unicode(test_values[i], errors = 'ignore')
	
nltk.download('punkt')
data = vectorizer.fit_transform(train_values + test_values)
data_array = data.toarray()
vocab = vectorizer.get_feature_names()
dist = np.sum(data_array, axis=0)

X_train, X_test, y_train, y_test = train_test_split( data_array[0:len(train)], train['Sentiment'], train_size=0.85, random_state=1234)
log_model = LogisticRegression()
log_model = log_model.fit(X=data_array[0:len(train)].astype(int), y=train['Sentiment'].astype(int))
test_pred = log_model.predict(data_array[len(train):])

out_pred = []
for i in range(len(test_pred)):
	if test_pred[i] == 0:
		out_pred.append(0.0)
	else:
		out_pred.append(test_pred[i]*0.25)

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

outcols=[]
outcols.append(target)
outcols.append('predicted')
df_out = pd.DataFrame(columns=outcols)

df_out[target] = test[target]
df_out['predicted'] = out_pred
df_out.to_csv(newtablename, index=False)
