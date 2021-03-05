package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Task2 extends Activity {

    private final long  RECT_ANIMATION   = 1_000; //длительность анимации прямоугольника = 1 секунда

    private int mWidth; //ширина view
    private int mHeight; //высота view

    private Paint mCirclePaint;
    private Paint mRectPaint;

    private ArgbEvaluator mArgbEvaluator; //класс для анимации смены цветов

    private long  mStartTime; //время начала анимации

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint p;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect();

            mCirclePaint = new Paint();
            mCirclePaint.setAntiAlias(true);
            mCirclePaint.setColor(Color.WHITE);
            mCirclePaint.setStyle(Paint.Style.FILL);

            mRectPaint = new Paint(mCirclePaint);
            mRectPaint.setColor(Color.GREEN);
            mArgbEvaluator = new ArgbEvaluator();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) { //вызывается при изменении размера view
            mWidth = w; //запоминаем ширину view
            mHeight = h; //запоминаем высоту view
            mStartTime = getTime(); //начинаем отсчет времени
        }

        private long getTime() { //возвращает текущее время в миллисекундах
            return System.nanoTime() / 1_000_000;
        }

        private void moveAnimation(Canvas canvas) {
            canvas.save();

            float rectWidth = mWidth / 10;
            float rectHeight = mHeight / 13;

            long curTime = getTime() - mStartTime; //время с момента начала анимации в мс
            float fraction = (float) (curTime % RECT_ANIMATION) / RECT_ANIMATION; //дробь от 0 до 1, где 0 - начало анимации, 1 - ее завершение

            if ((curTime / RECT_ANIMATION) % 2 == 1)
                fraction = 1 - fraction; //делает обратную анимацию, если она завершилась

            canvas.translate((mWidth - rectWidth) * fraction, mHeight - rectHeight);
            canvas.drawRect(0, 0, rectWidth, rectHeight, mRectPaint);

            canvas.restore();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            float center_x, center_y;

            // заливка канвы цветом
            canvas.drawARGB(80, 102, 204, 255);
            p.setColor(Color.RED);

            // толщина линии
            p.setStrokeWidth(10);

            // рисуем линию
            canvas.drawLine(100, 130, 700, 50, p);

            // рисуем круги
            canvas.drawCircle(270, 270, 20, p);
            canvas.drawCircle(330, 270, 20, p);

            // рисуем прямоугольники
            rect.set(250, 300, 350, 450);
            canvas.drawRect(rect, p);
            rect.set(790, 650, 950, 500);
            canvas.drawRect(rect, p);

            //надпись
            Paint shadowPaint = new Paint();
            shadowPaint.setAntiAlias(true);
            shadowPaint.setColor(Color.GREEN);
            shadowPaint.setTextSize(120.0f);
            shadowPaint.setStrokeWidth(6.0f);
            shadowPaint.setStyle(Paint.Style.STROKE);
            shadowPaint.setShadowLayer(5.0f, 10.0f, 10.0f, Color.BLACK);
            canvas.drawText("С днем защитника", 10, 400, shadowPaint);
            canvas.drawText("Отечества!!!", 200, 600, shadowPaint);

            //рисуем полоск
            float w, h, cx, cy, radius;
            w = getWidth();
            h = getHeight();
            cx = w / 2;
            cy = h / 2;
            radius = w / 4;

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);

            paint.setColor(Color.LTGRAY);
            canvas.drawCircle(cx, cy, radius, paint);

            paint.setAntiAlias(true);
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);

            final RectF oval = new RectF();

            p.setStrokeWidth(50);
            canvas.drawLine(100, 1500, 1000, 2000, p);
            canvas.drawLine(400, 2000, 600, 1400, p);

            center_x = 550;
            center_y = 1740;
            oval.set(center_x - radius,center_y - radius, center_x + radius, center_y + radius);

            shadowPaint.setStrokeWidth(13.0f);
            canvas.drawArc(oval, 135, 270, false, shadowPaint);

            rect.set(690, 1650, 1050, 1500);
            canvas.drawRect(rect, p);

            rect.set(790, 1250, 1000, 1400);
            canvas.drawRect(rect, p);

            p.setColor(Color.GREEN);
            rect.set(750, 1450, 1050, 1450);
            canvas.drawRect(rect, p);

            moveAnimation(canvas); //демонстрация анимации движения
            invalidate(); //заставляет перерисовывать view, пока view находится в поле зрения пользователя
        }
    }
}