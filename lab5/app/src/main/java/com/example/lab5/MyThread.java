package com.example.lab5;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

    private SurfaceHolder myThreadSurfaceHolder;
    private MySurfaceView myThreadSurfaceView;
    public static boolean myThreadRun = false;

    public MyThread(SurfaceHolder surfaceHolder, MySurfaceView surfaceView) {
        myThreadSurfaceHolder = surfaceHolder;
        myThreadSurfaceView = surfaceView;
    }

    public void setRunning(boolean b) {
        myThreadRun = b;
    }

    @SuppressLint("WrongCall")
    @Override
    public void run() {
        while(myThreadRun){
            Canvas c = null;

            try{
                c = myThreadSurfaceHolder.lockCanvas(null);
                synchronized (myThreadSurfaceHolder){
                    myThreadSurfaceView.onDraw(c);
                }
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally{
                if (c != null) {
                    myThreadSurfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }
    }
}
