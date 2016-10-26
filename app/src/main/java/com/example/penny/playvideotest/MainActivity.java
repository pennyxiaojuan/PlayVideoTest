package com.example.penny.playvideotest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import java.io.File;

public class MainActivity extends Activity implements View.OnClickListener{
    private VideoView videoView;
    private Button play;
    private Button pause;
    private  Button replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate方法获取一些控件的实例
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button) findViewById(R.id.play);
        pause =(Button) findViewById(R.id.pause);
        replay = (Button) findViewById(R.id.relay);
        videoView = (VideoView) findViewById(R.id.video_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();
    }
    private void initVideoPath(){
        File file = new File(Environment.getExternalStorageDirectory(),"王德顺 - 当你老了.mp4");
        videoView.setVideoPath(file.getPath());//指定视频文件的路径
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.play:
                if (!videoView.isPlaying()){
                    videoView.start();//开始播放视频
                }break;
            case R.id.pause:
                if (videoView.isPlaying()){
                    videoView.pause();//暂停播放
                }break;
            case R.id.relay:
                if (videoView.isPlaying())
                    videoView.resume();//重新播放
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (videoView!=null){
            videoView.suspend();//将VidioView所占用的资源释放掉
        }
    }
}
