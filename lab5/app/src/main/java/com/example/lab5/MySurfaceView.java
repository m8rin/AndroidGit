package com.example.lab5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public static boolean check = false;

    public static int a;

    private MyThread thread;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int cx, cy;

    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        getHolder().addCallback(this);
        thread = new MyThread(getHolder(), this);
        setFocusable(true); // make sure we get key events

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    private final int ANIMATION_TIME = 2_000; //анимация -  сек

    public long getTime() {
        return System.nanoTime() / 1_000_000;
    }

    @Override
    public void onDraw(Canvas canvas) {



        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.drawColor(Color.WHITE);

        long curTime = getTime() - 10;
        float fraction = (float) (curTime % ANIMATION_TIME) / ANIMATION_TIME;

        if (check == true) {
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(a * fraction * fraction, height * fraction, 100-a, paint);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(a*a*fraction, width * fraction * fraction, 180+a, paint);

            paint.setColor(Color.GREEN);
            canvas.drawCircle(width * fraction, 600+a, 200-2*a, paint);

            paint.setColor(Color.BLACK);
            canvas.drawCircle(width*fraction+a, width * fraction* fraction, 350-5*a, paint);

            paint.setColor(Color.MAGENTA);
            canvas.drawCircle(800-a, height * fraction, 260/a, paint);
            canvas.drawCircle(800, fraction*height, 10*a, paint);
        }
    }


}
