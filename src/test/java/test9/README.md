### Java工具类使用说明:
稍微简化了接口的调用，如需要完全嵌入自己的后台，可以做一下封装处理

1. MeThods类：接口调用管理类，初始化相关易联云配置信息
2. HttpUtil类：请求工具类，如果你自己有的话可以替换一下
3. ApiConst类：易联云baseUrl和接口url配置类
4. LAVApi类：接口调用类，包括了md5工具函数，Sign工具函数，uuid函数，可以直接用这个类直接进行接口调用


### 使用方式：
1. 需要先对Methods类进行init初始化设置，配置相关易联云信息
init方法分为开放式和自由式根据玩家需要进行相应的初始化即可
2. 然后在通过Methods获取token（开放式的code获取走网页的哦）
3. 之后即可调用相应的函数
	

### 开放式例子：
	Methods.getInstance().init("client_id","client_secret","code");
	Methods.getInstance().getToken();
	Methods.getInstance().refreshToken();
	Methods.getInstance().print("8888888","lilith","2");
	
### 自有式例子：
	Methods.getInstance().init("client_id","client_secret");
	Methods.getInstance().getFreedomToken();
	Methods.getInstance().refreshToken();
	Methods.getInstance().addPrinter("machine_code","msign")
	Methods.getInstance().print("8888888","lilith","2");
	
	
