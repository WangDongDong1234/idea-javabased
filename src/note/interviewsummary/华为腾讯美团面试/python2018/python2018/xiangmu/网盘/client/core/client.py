from core.auth_client import Auth
def main():
    start_1=[('登陆','login'),('注册','register'),('退出','q')]
    for index,item in enumerate(start_1,1):
        print(index,item[0])
    while True:
        try:
            num=int(input('>>'))
            func_str=start_1[num-1][0]
            auth=Auth()

            if hasattr(auth,start_1[num-1][1]):
                getattr(auth,start_1[num-1][1])()
        except:
            print("你输入的信息有误")
            #字符串数据类型的方法login  register quit