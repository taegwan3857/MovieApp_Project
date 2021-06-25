package com.example.movieapp_project;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button thumb_up_button;
    Button thumb_down_button;

//    RatingBar ratingBar;
//    TextView outputView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.print("*");

        final int[] flag = {1};
        final int[] flag2 = {1};
        final int[] flag3 = {0};
        final int[] flag4 = {0};

        thumb_up_button = (Button) findViewById(R.id.thumb_up_button);
        thumb_down_button = (Button) findViewById(R.id.thumb_down_button);

        TextView textView = (TextView) findViewById(R.id.thumb_up_score);
        TextView textView2 = (TextView) findViewById(R.id.thumb_down_score);

        final int[] count = {Integer.parseInt(textView.getText().toString())};
        final int[] count2 = {Integer.parseInt(textView2.getText().toString())};

        thumb_up_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                flag2[0] = 1;
                if (event.getAction() == event.ACTION_DOWN) {
                    switch (flag[0]) {
                        case 1:
                            thumb_up_button.setBackgroundResource(R.drawable.ic_thumb_up_selected);
                            thumb_down_button.setBackgroundResource(R.drawable.ic_thumb_down);
                            count[0] = count[0] + 1;
                            textView.setText(count[0] + "");
                            if (flag4[0] == 1) {
                                count2[0] = count2[0] - 1;
                                textView2.setText(count2[0] + "");
                                flag4[0] = 0;
                            }
                            flag[0] = 2;
                            flag3[0] = 1;
                            break;
                        case 2:
                            thumb_up_button.setBackgroundResource(R.drawable.ic_thumb_up);
                            flag[0] = 1;
                            flag3[0] = 0;
                            count[0] = count[0] - 1;
                            textView.setText(count[0] + "");
                            break;
                    }
                }
                return false;
            }
        });

        thumb_down_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                flag[0] = 1;
                if (event.getAction() == event.ACTION_DOWN) {
                    switch (flag2[0]) {
                        case 1:
                            thumb_down_button.setBackgroundResource(R.drawable.ic_thumb_down_selected);
                            thumb_up_button.setBackgroundResource(R.drawable.ic_thumb_up);
                            count2[0] = count2[0] + 1;
                            textView2.setText(count2[0] + "");
                            if (flag3[0] == 1) {
                                count[0] = count[0] - 1;
                                textView.setText(count[0] + "");
                                flag3[0] = 0;
                            }
                            flag2[0] = 2;
                            flag4[0] = 1;
                            break;
                        case 2:
                            thumb_down_button.setBackgroundResource(R.drawable.ic_thumb_down);
                            flag2[0] = 1;
                            flag4[0] = 0;
                            count2[0] = count2[0] - 1;
                            textView2.setText(count2[0] + "");
                            break;
                    }
                }
                return false;
            }
        });

//
//        // 104 ~ 138 인텐트 값 받아오기
//        outputView2 = (TextView) findViewById(R.id.outputView2);
//        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
//
//        Button button3 = (Button) findViewById(R.id.button5);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showCommentWriteActivity();
//            }
//        });
//    }
//
//    // 인텐트 받아오기 / 불러오기
//    public void showCommentWriteActivity(){
//        Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
//
//        startActivityForResult(intent, 101);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent intent) {
//        super.onActivityResult(requestCode, resultCode, intent);
//
//        if (requestCode == 101){
//            if (intent != null){
//                String contents = intent.getStringExtra("contents");
//                float rating = intent.getFloatExtra("rating", 0.0f);
//
//                outputView2.setText(contents);
//                ratingBar.setRating(rating);
//            }
//        }
//    }
    }
}