# NoticationTest
# 通知的基本布局
![enter description here][1]

在默认情况下，Notification仅显示消息标题、消息内容、送达时间这3项内容

元素：
1. 标题   Title/Name
2. 大图标  Icon/Photo
3. 内容文字   
4. 内容信息   MESSAGE
5. 小图标 Secondary Icon
6. 通知的时间 Timestamp,默认为系统发出通知的时间，也可通过setWhen()来设置

# 发出通知的步骤
                //1.获取通知管理器
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //2.实例化通知栏构造器
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                //3. 在builder中配置通知的标题内容等
                
                //**最为重要的一个参数，如果不设置，通知不会出现在状态栏中。**
                builder.setSmallIcon(R.drawable.a);
                
                builder.setContentTitle("这是通知");
                builder.setContentText("这是通知的内容");
                builder.setTicker("通知来了");
                //通知产生的时间，一般是获取系统的时间
                builder.setWhen(System.currentTimeMillis());
                //设置通知的优先级
                builder.setPriority(Notification.PRIORITY_DEFAULT);
                //设置通知的铃声 震动等 最简单是设置系统默认
                builder.setDefaults(Notification.DEFAULT_VIBRATE);
                builder.setSmallIcon(R.drawable.a);

                //4. 发出通知
                notificationManager.notify(1,builder.build());



# 发出可点击的通知


                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //第⼀一个参数依旧是Context，不⽤用多做解释。
                // 第⼆个参数 ⼀一般⽤用不到，通常都是传⼊入0即可
                // 第三个参数是⼀一个Intent对象，我们可以通过这个对象构建 出PendingIntent的“意图”
                // 第四个参数⽤用于确定PendingIntent的行为，
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_ONE_SHOT);
                builder.setContentIntent(pendingIntent);
                
#  演示                 
 ![enter description here][1]               
