import socket
import json
class MySocketClient:
    def __init__(self):
        self.sk=socket.socket()
        self.sk.connect(('127.0.0.1',8080))

    def mysend(self,msg):
        msg_json=json.dumps(msg)
        self.sk.send(msg_json.encode('utf-8'))