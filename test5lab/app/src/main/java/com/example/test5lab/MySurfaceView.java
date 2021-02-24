package com.example.test5lab;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public static boolean check = false;

    private MySurfaceThread thread;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int cx, cy;

    public MySurfaceView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    private void init() {
        getHolder().addCallback(this);
        thread = new MySurfaceThread(getHolder(), this);
        setFocusable(true); // make sure we get key events

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.WHITE);

    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        canvas.drawRGB(0, 0, 0);
        canvas.drawCircle(cx, cy, 3, paint);

        if (check == true) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            int rad = 10;

            canvas.drawColor(Color.BLACK);

            long curTime = getTime() - 10;
            float fraction = (float) (curTime % ANIMATION_TIME) / ANIMATION_TIME;

            //int color = (int) mArgbEvaluator.evaluate(fraction, Color.RED, Color.BLACK);
            paint.setColor(Color.RED);

            canvas.drawCircle(width * fraction * fraction, height * fraction, 100, paint);

            paint.setColor(Color.BLUE);
            canvas.drawCircle(500, 2000 * fraction * fraction, 80, paint);

            paint.setColor(Color.GREEN);
            canvas.drawCircle(width * fraction, 600, 60, paint);
        }
    }
}
