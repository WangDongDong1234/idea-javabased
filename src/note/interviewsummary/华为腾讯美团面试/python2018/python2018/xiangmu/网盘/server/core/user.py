import os
from conf import settings
class User:
    def __init__(self,name):
        self.name=name
        #自己的家目录
        self.home=os.path.join(settings.home_path,name)
        #记录当前位置
        self.cur_path=self.home
        #磁盘配额
        self.disk_space=settings.space