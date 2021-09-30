package com.test.myviewpager2;

import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.viewpager2.widget.ViewPager2;

@RequiresApi(21)
public class DepthPageTransformer implements ViewPager2.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // このページは画面の左側にあります。
            view.setAlpha(0f);

        } else if (position <= 0) { // [-1,0]
            // 左側のページに移動するときは、デフォルトのスライドトランジションを使用してください
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setTranslationZ(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);

        } else if (position <= 1) { // (0,1]
            // ページをフェードアウトします。
            view.setAlpha(1 - position);

            // デフォルトのスライド遷移を打ち消す
            view.setTranslationX(pageWidth * -position);
            // 左のページの後ろに移動します
            view.setTranslationZ(-1f);

            // ページを縮小します（MIN_SCALEと1の間）
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // このページは画面の右側にあります。
            view.setAlpha(0f);
        }
    }
}