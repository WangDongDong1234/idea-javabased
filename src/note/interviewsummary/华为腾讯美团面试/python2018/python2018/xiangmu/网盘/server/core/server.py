

import json
import socketserver
from core import views
from conf import settings
class MyFTPServer(socketserver.BaseRequestHandler):
    def handle(self):
        msg=self.my_recv()
        #消息的转发  把任务转给views文件对应的方法
        op_str=msg['operation']#从收到的字典中取出操作行为
        if hasattr(views,op_str):
            func=getattr(views,op_str)
            ret=func(msg)
            self.my_send(ret)

    def my_recv(self):#派生出方法
        msg=self.request.recv(1024)
        msg=msg.decode(settings.code)
        msg=json.loads(msg)
        return msg

    def my_send(self,msg):
        msg=json.dumps(msg).encode(settings.code)
        self.request.send(msg)