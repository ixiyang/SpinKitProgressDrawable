package com.ixy.progressdrawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.animation.AccelerateInterpolator;

public class SpinKitDrawable2 extends AbSpinDrawable {

	private static final long ANIMATION_DURATION = 600;


	protected static final String TAG = "SpinKitDrawable2";

	private float mFirstScale;
	private float mSecondScale;
	private float mThirdScale;
	private float mRadius;
	private Context mContext;
	private float mPadding;

	public SpinKitDrawable2(Context context) {
		mContext = context;
		mRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, mContext.getResources()
				.getDisplayMetrics());
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.WHITE);
		initAnimation();
	}

	private void initAnimation() {
		final AnimatorSet animationSet = new AnimatorSet();
		final ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this, "firstScale", 0, 1,0);
		final ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this, "secondScale", 0, 1,0);
		final ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(this, "thirdScale", 0, 1,0);

		objectAnimator1.setInterpolator(new AccelerateInterpolator());
		objectAnimator1.setDuration(ANIMATION_DURATION);
		objectAnimator2.setDuration(ANIMATION_DURATION);
		objectAnimator2.setStartDelay(ANIMATION_DURATION*2/5);
		objectAnimator3.setDuration(ANIMATION_DURATION);
		objectAnimator3.setStartDelay(ANIMATION_DURATION*3/5);
		
		
		
		animationSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3);
		animationSet.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				animationSet.start();
			}
		});
		animationSet.setDuration(800);
		animationSet.start();
	}

	@Override
	public void draw(Canvas canvas) {
		drawFirst(canvas);
		drawSecond(canvas);
		drawThird(canvas);

	}

	private void drawFirst(Canvas canvas) {
		Matrix matrix = new Matrix();
		canvas.save();
		matrix.preScale(mFirstScale, mFirstScale, mRadius, getBounds().height() / 2);
		canvas.concat(matrix);
		canvas.drawCircle(mRadius, getBounds().height() / 2, mRadius, mPaint);
		canvas.restore();
	}

	private void drawSecond(Canvas canvas) {
		Matrix matrix = new Matrix();
		canvas.save();
		matrix.preScale(mSecondScale, mSecondScale, 3 * mRadius + mPadding,
				getBounds().height() / 2);
		canvas.concat(matrix);
		canvas.drawCircle(3 * mRadius + mPadding, getBounds().height() / 2, mRadius, mPaint);
		canvas.restore();
	}

	private void drawThird(Canvas canvas) {
		Matrix matrix = new Matrix();
		canvas.save();
		matrix.preScale(mThirdScale, mThirdScale, 5 * mRadius + mPadding, getBounds().height() / 2);
		canvas.concat(matrix);
		canvas.drawCircle(5 * mRadius + mPadding, getBounds().height() / 2, mRadius, mPaint);
		canvas.restore();
	}

	@Override
	public void setAlpha(int alpha) {
		mPaint.setAlpha(alpha);

	}

	@Override
	public void setColorFilter(ColorFilter cf) {
		mPaint.setColorFilter(cf);

	}

	@Override
	protected void onBoundsChange(Rect bounds) {
		super.onBoundsChange(bounds);
	}

	@Override
	public int getOpacity() {
		return PixelFormat.TRANSPARENT;
	}

	public void setFirstScale(float scale) {
		mFirstScale = scale;
	}

	public void setSecondScale(float scale) {
		mSecondScale = scale;
	}

	public void setThirdScale(float scale) {
		mThirdScale = scale;
	}
}
