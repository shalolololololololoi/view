package com.test.myviewpager2;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // このページは画面の左側にあります。
            view.setAlpha(0f);

        } else if (position <= 1) { // [-1,1]
            // デフォルトのスライドトランジションを変更して、ページも縮小します
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // ページを縮小します（MIN_SCALEと1の間）
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // サイズに応じてページをフェードします。
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // このページは画面の右側にあります。
            view.setAlpha(0f);
        }
    }
}
