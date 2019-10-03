import json
from core.socket_client import MySocketClient

class Auth:
    def __init__(self):
        self.sk=MySocketClient()#感觉这里直接用self=MySocketClient()
        self.username=None

    def register(self):
        username=input('username:')
        password=input('password:')
        if username.strip() and password.strip():
            self.sk.mysend({'username':username,'password':password,'operation':'register'})
        else:
            print("用户名密码不能为空")