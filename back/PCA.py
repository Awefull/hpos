import numpy as np
import pandas as pd
from sklearn.decomposition import PCA

#参数初始化
inputfile = './data.xlsx'
outputfile = './out.txt' #降维后的数据

data = pd.read_excel(inputfile, header = None) #读入数据
X = np.array(data)
pca = PCA(n_components=3)
newX = pca.fit_transform(X)
print(pca.explained_variance_ratio_)
f = open(outputfile,'w')
f.write(str(pca.explained_variance_ratio_))
f.close()

