package com.ixy.progressdrawable;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;

public class SpinKitDrawable3 extends AbSpinDrawable {
	private static final long ANIMATION_DURATION = 1000;

	private Context mContext;

	private float mRadius;// 小圆的半径
	private float mOutCirRadius;// 区域内最大圆的半径
	private float mWidth, mHeight;
	private float mCircleRadius;// 小圆的圆心所在圆的半径
	private float mScale1, mScale2, mScale3, mScale4, mScale5, mScale6, mScale7, mScale8;

	public SpinKitDrawable3(Context context) {
		mContext = context;
		mRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, mContext.getResources()
				.getDisplayMetrics());
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.WHITE);
		initAnimation();
	}

	private void initAnimation() {
		final ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this, "scale1", 0, 1, 0);
		final ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this, "scale2", 0, 1, 0);
		final ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(this, "scale3", 0, 1, 0);
		final ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(this, "scale4", 0, 1, 0);
		final ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(this, "scale5", 0, 1, 0);
		final ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(this, "scale6", 0, 1, 0);
		final ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(this, "scale7", 0, 1, 0);
		final ObjectAnimator objectAnimator8 = ObjectAnimator.ofFloat(this, "scale8", 0, 1, 0);

		objectAnimator1.setInterpolator(new LinearInterpolator());
		objectAnimator1.setDuration(ANIMATION_DURATION);
		objectAnimator2.setDuration(ANIMATION_DURATION);
		objectAnimator2.setStartDelay(ANIMATION_DURATION / 16);
		objectAnimator3.setDuration(ANIMATION_DURATION);
		objectAnimator3.setStartDelay(ANIMATION_DURATION * 2 / 16);
		objectAnimator4.setDuration(ANIMATION_DURATION);
		objectAnimator4.setStartDelay(ANIMATION_DURATION * 3 / 16);
		objectAnimator5.setDuration(ANIMATION_DURATION);
		objectAnimator5.setStartDelay(ANIMATION_DURATION * 4 / 16);
		objectAnimator6.setDuration(ANIMATION_DURATION);
		objectAnimator6.setStartDelay(ANIMATION_DURATION * 5 / 16);
		objectAnimator7.setDuration(ANIMATION_DURATION);
		objectAnimator7.setStartDelay(ANIMATION_DURATION * 6 / 16);
		objectAnimator8.setDuration(ANIMATION_DURATION);
		objectAnimator8.setStartDelay(ANIMATION_DURATION * 7 / 16);

		objectAnimator1.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator2.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator3.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator4.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator5.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator6.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator7.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator8.setRepeatCount(ObjectAnimator.INFINITE);

		objectAnimator1.start();
		objectAnimator2.start();
		objectAnimator3.start();
		objectAnimator4.start();
		objectAnimator5.start();
		objectAnimator6.start();
		objectAnimator7.start();
		objectAnimator8.start();

	}

	@Override
	public void draw(Canvas canvas) {
		drawCircle1(canvas);
		drawCircle2(canvas);
		drawCircle3(canvas);
		drawCircle4(canvas);
		drawCircle5(canvas);
		drawCircle6(canvas);
		drawCircle7(canvas);
		drawCircle8(canvas);
	}

	@Override
	protected void onBoundsChange(Rect bounds) {
		super.onBoundsChange(bounds);
		mWidth = bounds.width();
		mHeight = bounds.height();
		mOutCirRadius = Math.min(mHeight, mWidth) / 2;
		mCircleRadius = mOutCirRadius - mRadius;

	}

	private void drawCircle1(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale1, mScale1, mWidth / 2 - mCircleRadius, mHeight / 2);
		canvas.concat(matrix);
		canvas.drawCircle(mWidth / 2 - mCircleRadius, mHeight / 2, mRadius, mPaint);
		canvas.restore();
	}

	private void drawCircle2(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale2, mScale2, (float) (mWidth / 2 - Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 - Math.sqrt(2) / 2 * mCircleRadius));
		canvas.concat(matrix);
		canvas.drawCircle((float) (mWidth / 2 - Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 - Math.sqrt(2) / 2 * mCircleRadius), mRadius, mPaint);
		canvas.restore();
	}

	private void drawCircle3(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale3, mScale3, mWidth / 2, mHeight / 2 - mCircleRadius);
		canvas.concat(matrix);
		canvas.drawCircle(mWidth / 2, mHeight / 2 - mCircleRadius, mRadius, mPaint);
		canvas.restore();
	}

	private void drawCircle4(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale4, mScale4, (float) (mWidth / 2 + Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 - Math.sqrt(2) / 2 * mCircleRadius));
		canvas.concat(matrix);
		canvas.drawCircle((float) (mWidth / 2 + Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 - Math.sqrt(2) / 2 * mCircleRadius), mRadius, mPaint);
		canvas.restore();
	}

	private void drawCircle5(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale5, mScale5, mWidth / 2 + mCircleRadius, mHeight / 2);
		canvas.concat(matrix);
		canvas.drawCircle(mWidth / 2 + mCircleRadius, mHeight / 2, mRadius, mPaint);
		canvas.restore();
	}

	private void drawCircle6(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale6, mScale6, (float) (mWidth / 2 + Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 + Math.sqrt(2) / 2 * mCircleRadius));
		canvas.concat(matrix);
		canvas.drawCircle((float) (mWidth / 2 + Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 + Math.sqrt(2) / 2 * mCircleRadius), mRadius, mPaint);
		canvas.restore();
	}

	private void drawCircle7(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale7, mScale7, mWidth / 2, mHeight / 2 + mCircleRadius);
		canvas.concat(matrix);
		canvas.drawCircle(mWidth / 2, mHeight / 2 + mCircleRadius, mRadius, mPaint);
		canvas.restore();
	}

	private void drawCircle8(Canvas canvas) {
		canvas.save();
		Matrix matrix = new Matrix();
		matrix.preScale(mScale8, mScale8, (float) (mWidth / 2 - Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 + Math.sqrt(2) / 2 * mCircleRadius));
		canvas.concat(matrix);
		canvas.drawCircle((float) (mWidth / 2 - Math.sqrt(2) / 2 * mCircleRadius),
				(float) (mHeight / 2 + Math.sqrt(2) / 2 * mCircleRadius), mRadius, mPaint);
		canvas.restore();
	}

	public void setScale1(float mScale1) {
		this.mScale1 = mScale1;
	}

	public void setScale2(float mScale2) {
		this.mScale2 = mScale2;
	}

	public void setScale3(float mScale3) {
		this.mScale3 = mScale3;
	}

	public void setScale4(float mScale4) {
		this.mScale4 = mScale4;
	}

	public void setScale5(float mScale5) {
		this.mScale5 = mScale5;
	}

	public void setScale6(float mScale6) {
		this.mScale6 = mScale6;
	}

	public void setScale7(float mScale7) {
		this.mScale7 = mScale7;
	}

	public void setScale8(float mScale8) {
		this.mScale8 = mScale8;
	}

}
