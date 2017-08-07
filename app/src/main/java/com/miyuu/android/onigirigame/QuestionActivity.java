package com.miyuu.android.onigirigame;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    int answerOnigiri;

    TextView questionTextView;
    ImageButton onigiriButton1;
    ImageButton onigiriButton2;
    ImageButton onigiriButton3;

    //配列に画像のリソースを入れておきます。0のとき梅、1のときたらこ、2のときこんぶが出るように準備しておきます。
    int[] onigiriImageResourse = {R.drawable.onigitri_ume, R.drawable.onigiri_tarako, R.drawable.onigiri_konbu};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        onigiriButton1 = (ImageButton) findViewById(R.id.onigiriButton1);
        onigiriButton2 = (ImageButton) findViewById(R.id.onigiriButton2);
        onigiriButton3 = (ImageButton) findViewById(R.id.onigiriButton3);

        //処理をまとめることが出来る　メソッド　と言うものを使います。
        //スタート処理をまとめた、startメソッドを呼び出します。
        start();
    }

    //startメソッド
    public void start() {

        //setImageResource　でImageViewに画像を設定できるよ！
        //初期の画像（具が見えないおにぎり）を設定
        onigiriButton1.setImageResource(R.drawable.onigiri);
        onigiriButton2.setImageResource(R.drawable.onigiri);
        onigiriButton3.setImageResource(R.drawable.onigiri);

        //正解のおにぎりの具をランダムに決定。AnswerOnigiri変数の中に0.1.2どれかの値を入れます
        //0:うめ　1:たらこ　2:こんぶ
        Random r = new Random();
        answerOnigiri = r.nextInt(3);

        //もし（if） answerOnigiri が0だったら梅、1だったらたらこ、2だったらこんぶ
        if (answerOnigiri == 0) {
            questionTextView.setText("うめを探せ！");
        } else if (answerOnigiri == 1) {
            questionTextView.setText("たらこを探せ！");
        } else if (answerOnigiri == 2) {
            questionTextView.setText("こんぶを探せ！");
        }
    }

    public void onigiriButton1Click(View v) {
        //ボタンをクリックしたらランダムな数を生成します
        Random r = new Random();
        int random = r.nextInt(3);

        /**
         * if(条件式){
         *   その条件の時にする処理
         * }
         * がif文の公式です
         */
        //もしランダムな数がanswerOnigiriと同じだったら、正解
        if (random == answerOnigiri) {
            //正解
            onigiriButton1.setImageResource(onigiriImageResourse[random]);
            questionTextView.setText("正解！");

            /**
             * if(条件式){
             *   その条件の時にする処理
             * } else {
             *   その条件以外の時にする処理
             * }
             *
             * elseをつけると、その条件以外の時にする処理を設定できます。
             */
            //正解の条件以外だったら、不正解
        } else {
            //不正解
            onigiriButton1.setImageResource(onigiriImageResourse[random]);
            questionTextView.setText("残念");
        }

        //次の問題に進む処理をまとめたnextQuestionメソッドを呼び出す
        nextQuestion();
    }

    public void onigiriButton2Click(View v) {
        Random r = new Random();
        int random = r.nextInt(3);

        if (random == answerOnigiri) {
            //正解
            onigiriButton2.setImageResource(onigiriImageResourse[random]);
            questionTextView.setText("正解！");

        } else {
            //不正解
            onigiriButton2.setImageResource(onigiriImageResourse[random]);
            questionTextView.setText("残念");
        }

        nextQuestion();
    }

    public void onigiriButton3Click(View v) {
        Random r = new Random();
        int random = r.nextInt(3);

        if (random == answerOnigiri) {
            //正解
            onigiriButton3.setImageResource(onigiriImageResourse[random]);
            questionTextView.setText("正解！");

        } else {
            //不正解
            onigiriButton3.setImageResource(onigiriImageResourse[random]);
            questionTextView.setText("残念");
        }

        nextQuestion();
    }

    //nextQuestionメソッド
    public void nextQuestion() {
        //Handlerと言うものを使って、１秒待って次の問題に進むようにしています。
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // 1秒後に次の問題
                start();
            }
        }, 1000);
    }

}
