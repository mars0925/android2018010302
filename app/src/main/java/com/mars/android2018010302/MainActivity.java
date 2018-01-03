package com.mars.android2018010302;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb, pb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar)findViewById(R.id.progressBar);
        pb2 = (ProgressBar)findViewById(R.id.progressBar2);
    }
    public void click1(View v)
    {
        pb.setVisibility(View.VISIBLE);
        //創立一個副執行緒讓他停住三秒鐘
        new  Thread()
        {
            public void  run()
            {
                super.run();
                try{
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //讓副執行緒再回到主程式來執行
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();
    }

    public void click2(View v)//讓進度條增加
    {
        switch (v.getId())
        {
            case R.id.button2:
                pb2.setProgress(pb2.getProgress()-10);//取回自己的progress再減10
                break;
            case R.id.button3:
                pb2.setProgress(pb2.getProgress()+10);//取回自己的progress再加10
                break;

        }

    }


}
