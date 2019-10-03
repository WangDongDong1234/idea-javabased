from core.user import User
from conf import settings
import pickle
import os

def login(msg):
    print(msg)

def register(msg):
    print(msg)
    #username password
    #创建一个属于这个用户的家目录，把用户名的密码写在userinfo
    #记录用户的初试磁盘配额，记录文件大小，记录用户当前所在的目录
    user_obj=User(msg['username'])#记录用户的信息
    pickle_path=os.path.join(settings.pickle_path,msg['username'])
    #保存对象的信息
    with open(pickle_path,'wb')as f:
        pickle.dump(user_obj,f)
    os.mkdir(user_obj.home)#创建一个家目录
    with open(settings.userinfo,'a')as f:
        f.write('%s|%s|%s'%(msg['username'],msg['password'],pickle_path))
    return True
def upload(msg):
    print(msg)

def download(msg):
    print(msg)