# MaterialFrame
  此项目对app开发中常用的MVC架构进行抽取。项目以materia design为基准，进行相关抽取。项目中尽可能模块化处理，如网络请求、图片处理、搜索框封装
  等。
  整体UI架构：RadioGroup+Fragment+沉浸式菜单+MaterialDesign; 
  整体逻辑架构：OKHttp+Fresco+Gson; 
# 项目要点
  1. RecyclerView加上headView/FootView的深度抽取，即下拉刷新和上拉加载更多逻辑抽取；
  2. 网络请求LoadingMorePager处理；
  3. 以Fragment代替部分Activity，并把Fragment加入BackStack中；
  4. 加入LeakCanary/UncaughtExceptionHandler,以及UnitTest的处理；
  5. 避免内在的泄露；
  6. 数据加密处理；
  7. 图片省流量加载；
  
# 项目值得探索点
  1. apk下载好后自动安装（Accessibility）；
  2. app的检查更新；
  
# 项目过程中的Bug
