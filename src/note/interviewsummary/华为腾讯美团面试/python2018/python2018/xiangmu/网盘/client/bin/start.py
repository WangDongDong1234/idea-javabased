import os
import sys
# print(os.getcwd())D:\wdd\pycharm\python_code\项目案例\网盘\client\bin
# print(os.path.dirname(os.getcwd()))D:\wdd\pycharm\python_code\项目案例\网盘\client
#把client目录全部导入到sys.path下
sys.path.append(os.path.dirname(os.getcwd()))

from core import client
if __name__=='__main__':
    client.main()