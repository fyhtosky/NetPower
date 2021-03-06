package com.example.fanyuanhua.netpower.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CanvasFive extends View {
    private Paint mPaint = new Paint();
    private Path path=new Path();
    private int mWidth,mHeight;
    private Picture mPicture = new Picture();
    public CanvasFive(Context context) {
        this(context,null);
    }

    public CanvasFive(Context context,  @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasFive(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        path.reset();
        drawSkew();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth=w;
        this.mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawTranslate(canvas);
//        drawScale(canvas);
//        drawRotate(canvas);
        canvas.drawPicture(mPicture);

//        drawSkew(canvas);
//
//        path.lineTo(100, 100);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            path.arcTo(100, 100, 300, 300, -90, 90, true); // 强制移动到弧形起点（无痕迹）
//        }
//        canvas.drawPath(path,mPaint);
//
//        canvas.translate(100,200);
//        path.reset();
//        mPaint.setStrokeCap(Paint.Cap.ROUND);//连接处为圆点
//        path.lineTo(100, 100);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            path.arcTo(100, 100, 300, 300, -90, 90, false); // 强制移动到弧形起点（无痕迹）
//        }
//        path.lineTo(100, 100);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            path.addArc(100, 100, 300, 300, -90, 90); // 强制移动到弧形起点（无痕迹）
//        }
//        canvas.drawPath(path,mPaint);
//         path.reset();
////        path.quadTo(100,100,50,300);
//        path.cubicTo(100,100,50,300,100,400);
//        canvas.drawPath(path,mPaint);

    }

    private void drawSkew(Canvas canvas) {

     // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        RectF rect = new RectF(0,0,200,200);   // 矩形区域

        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect,mPaint);

        canvas.skew(1,0);                       // 水平错切 <- 45度

        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect,mPaint);
    }

    private void drawSkew() {
      // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        RectF rect = new RectF(0,0,200,200);   // 矩形区域

        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect,mPaint);

        canvas.skew(1,0);                       // 水平错切 <- 45度

        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect,mPaint);
        mPicture.endRecording();
    }

    /**
     * 旋转
     * @param canvas
     */
    private void drawRotate(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        canvas.drawCircle(0,0,400,mPaint);          // 绘制两个圆形
        canvas.drawCircle(0,0,380,mPaint);

        for (int i=0; i<=360; i+=10){               // 绘制圆形之间的连接线
            canvas.drawLine(0,380,0,400,mPaint);
            canvas.rotate(10);
        }
    }

    /**
     * 缩放
     * @param canvas
     */
    private void drawScale(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        RectF rect = new RectF(-400,-400,400,400);   // 矩形区域

        for (int i=0; i<=20; i++)
        {
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rect,mPaint);
        }
    }

    /**
     * 平移
     * @param canvas
     */
    private void drawTranslate(Canvas canvas) {
        /**
         * translate 位移
         * 1.基于当前位置移动，而不是每次基于屏幕左上角的（0，0）点移动
         * 2.两次移动是可以叠加的
         */
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);
//
//       // 在坐标原点绘制一个蓝色圆形
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);

        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        RectF rect = new RectF(0,-400,200,0);   // 矩形区域

        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect,mPaint);


//        canvas.scale(-0.5f,-0.5f);//-值翻转
//        canvas.scale(0.5f,0.5f);      // 画布缩放
        canvas.scale(-0.5f,-0.1f);
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        Log.i("CanvasFive","rect.left"+rect.left+";rect.right"+rect.right+";rect.top"+rect.top+";rect.bottom"+rect.bottom);
        canvas.drawRect(rect,mPaint);
    }
}
