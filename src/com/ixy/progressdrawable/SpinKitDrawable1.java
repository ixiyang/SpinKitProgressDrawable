package com.ixy.progressdrawable;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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

public class SpinKitDrawable1 extends AbSpinDrawable {


	private static final long ANIMATION_DURATION = 1000;

	private static final long ANIMATION_DELAY = 150;

	private float mScale;
	private Context mContext;
	private  float mMinRadius;
	public SpinKitDrawable1(Context context) {
		mContext=context;
		mMinRadius=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics());
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.WHITE);
		initAnimation();
	}

	private void initAnimation() {
		PropertyValuesHolder pvh1 = PropertyValuesHolder.ofInt("alpha", 255, 0);
		PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scale", 0, 1);
		final ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, pvh1,
				pvh2);
		objectAnimator.setInterpolator(new AccelerateInterpolator());
		objectAnimator.setDuration(ANIMATION_DURATION);
		objectAnimator.setStartDelay(ANIMATION_DELAY);
		objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
		objectAnimator.start();
	}

	
	@Override
	public void draw(Canvas canvas) {
		Matrix matrix = new Matrix();
		canvas.save();
		matrix.preScale(mScale, mScale, getBounds().width() / 2, getBounds().width() / 2);
		canvas.concat(matrix);
		canvas.drawCircle(getBounds().width() / 2, getBounds().height() / 2,
				Math.max(Math.min(getBounds().width() / 2, getBounds().height() / 2),mMinRadius), mPaint);
		canvas.restore();
	}

	@Override
	public void setAlpha(int alpha) {
		mPaint.setAlpha(alpha);
	}

	@Override
	protected void onBoundsChange(Rect bounds) {
		super.onBoundsChange(bounds);
	}

	@Override
	public void setColorFilter(ColorFilter cf) {
		mPaint.setColorFilter(cf);
	}

	@Override
	public int getOpacity() {
		return PixelFormat.TRANSPARENT;
	}

	public float getScale() {
		return mScale;
	}

	public void setScale(float mScale) {
		this.mScale = mScale;
	}
	
}
