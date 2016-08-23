package com.example.tuionf.noticationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button send;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button) findViewById(R.id.send_notication);
        btn = (Button) findViewById(R.id.btn);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.获取通知管理器
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //2.实例化通知栏构造器
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                //3. 在builder中配置通知的标题内容等
                builder.setContentTitle("这是通知");
                builder.setContentText("这是通知的内容");
                builder.setTicker("通知来了");
                //通知产生的时间，一般是获取系统的时间
                builder.setWhen(System.currentTimeMillis());
                //设置通知的优先级
                builder.setPriority(Notification.PRIORITY_DEFAULT);
                //设置通知的铃声 震动等 最简单是设置系统默认
                builder.setDefaults(Notification.DEFAULT_VIBRATE);
                //最为重要的一个参数，如果不设置，通知不会出现在状态栏中。
                builder.setSmallIcon(R.drawable.a);

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //第⼀一个参数依旧是Context，不⽤用多做解释。
                // 第⼆个参数 ⼀一般⽤用不到，通常都是传⼊入0即可
                // 第三个参数是⼀一个Intent对象，我们可以通过这个对象构建 出PendingIntent的“意图”
                // 第四个参数⽤用于确定PendingIntent的行为，
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_ONE_SHOT);
                builder.setContentIntent(pendingIntent);

                //4. 发出通知
                notificationManager.notify(1,builder.build());

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.获取通知管理器
                NotificationManager notificationManager2 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //2.实例化通知栏构造器
                NotificationCompat.Builder builder2 = new NotificationCompat.Builder(MainActivity.this);
                //3. 在builder中配置通知的标题内容等
                builder2.setContentTitle("这是通知2");
                builder2.setContentText("这是通知的内容2");
                builder2.setTicker("通知来了2");

                builder2.setSmallIcon(R.drawable.a);
                //通知产生的时间，一般是获取系统的时间
                builder2.setWhen(System.currentTimeMillis());
                notificationManager2.notify(21,builder2.build());
            }
        });
    }
}
