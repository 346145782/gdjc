# from java import jclass
from scipy import signal
import numpy as np
# import math 


def FilterY(data):
    return __filterInner(data,"y")

def FilterZ(data):
    return __filterInner(data,"z")



def __filterInner(data,yz):
    xx=[]
    print(type(data))
    # 遍历Java的ArrayList对象
    for i in range(data.size()):
        print(data.get(i))
        xx.append(data.get(i))

    
    xx = np.array(xx).astype(float)

    if yz == "y":
        filterXX = __filterYData(xx)
    else:
        filterXX = __filterZData(xx)

    # res = []
    # for i in range(len(filterXX)):
    #     # print( filterXX[i])
    #     res.append(str(filterXX[i]*100))

    avgXX = np.zeros(8)

    for i in range (8):
        tempXX = np.zeros(8) 
        for j in range(8):
            tempXX[j] = filterXX[i*8+j]
        avgXX[i] = np.average(tempXX)
        
    return np.max(np.abs(avgXX))

def __filterYData(xx):
    # 水加
    cf = 10
    fs = 250
    wn = 2*cf/fs
    n = 3
    # 去除趋势
    #xx = signal.detrend(xx)
    # 10hz低通滤波
    b, a = signal.butter(n, wn, 'lowpass')
    filterXX = signal.filtfilt(b, a, xx)  # data为要过滤的信号
    # 0.5-10带通滤波
    cf1 = 0.5
    cf2 = 10
    wn1 = 2*cf1/fs
    wn2 = 2*cf2/fs
    b, a = signal.butter(n, [wn1, wn2], 'bandpass')
    filterXXX = signal.filtfilt(b, a, filterXX)  # data为要过滤的信号
    
    return filterXXX

def __filterZData(xx):
    # 垂加
    cf = 20
    fs = 250
    wn = 2*cf/fs
    n = 3
    # 去除趋势
    xx = signal.detrend(xx)
    # 20hz低通滤波
    b, a = signal.butter(n, wn, 'lowpass')
    filterXX = signal.filtfilt(b, a, xx)  # data为要过滤的信号
    return filterXX

# python调用Java类
#def get_java_bean():
#    JavaBean = jclass("com.example.fliter")#用自己的包名
#    jb = JavaBean("python")
#    jb.setData("json")
#    jb.setData("xml")
#    jb.setData("xhtml")
   # return jb