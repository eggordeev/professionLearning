package com.example.profession;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

/**
 * Created by egordeev on 16.11.14.
 */
public class ProfessionActivity extends Activity {

    ImageSwitcher imageSwitcher;
    Animation slide_in_left, slide_out_right;
    Animation fade_in, fade_out;
    int curIndex;
    int imageResources[] = {R.drawable.stub_picture};
    ImageButton button_prev_slide, button_next_slide;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profession);

        SetImageSwitcher();
    }
    private void SetImageSwitcher(){

        imageSwitcher = (ImageSwitcher) findViewById(R.id.image_switcher);

        slide_in_left = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        imageSwitcher.setInAnimation(slide_in_left);
        imageSwitcher.setOutAnimation(slide_out_right);

        imageSwitcher.setFactory(
                new ViewSwitcher.ViewFactory() {

                    @Override
                    public View makeView() {

                        ImageView imageView = new ImageView(ProfessionActivity.this);
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                        FrameLayout.LayoutParams params = new ImageSwitcher.LayoutParams(
                                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

                        imageView.setLayoutParams(params);
                        return imageView;

                    }
                });

        curIndex = 0;
        imageSwitcher.setImageResource(imageResources[curIndex]);

        button_prev_slide = (ImageButton) findViewById(R.id.image_button_prev_slide);
        button_prev_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.showPrevious();
            }
        });
        button_next_slide = (ImageButton) findViewById(R.id.image_button_next_slide);
        button_next_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.showNext();
            }
        });

    }
}