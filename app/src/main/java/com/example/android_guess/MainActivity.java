package com.example.android_guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    ImageButton button;
    TextView tv_name;
    ImageView iv_up;
    ImageView iv_down;
    int num= (int)(1+Math.random()*9999);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText) findViewById(R.id.et_input);
        button=(ImageButton) findViewById(R.id.btn_check);
        tv_name=(TextView) findViewById(R.id.tv_name);
        iv_up=(ImageView) findViewById(R.id.iv_up);
        iv_down=(ImageView) findViewById(R.id.iv_down);

        et.addTextChangedListener(textWatcher);
    }


    TextWatcher textWatcher = new TextWatcher() {

        // 输入文本之前的状态
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        // 输入文本中的状态
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        // 输入文本之后的状态
        @Override
        public void afterTextChanged(Editable s) {
            if(et.getText().length()!=0) {
                button.setBackgroundResource(R.drawable.check2);
            }else{
                button.setBackgroundResource(R.drawable.check1);
            }
            iv_down.setBackgroundResource(R.drawable.down1);
            iv_up.setBackgroundResource(R.drawable.up1);
            iv_down.setVisibility(View.INVISIBLE);
            iv_up.setVisibility(View.INVISIBLE);
        }
};


    public void click(View view) {

        String s=et.getEditableText().toString();
        if(et.getText().length()!=0) {
            int real=Integer.parseInt(et.getEditableText().toString());
            if(real==num){
                //Scenario 1: input values are different from random values
                tv_name.setText("You got it!");
                et.setEnabled(false);
                button.setBackgroundResource(R.drawable.right);
                button.setEnabled(false);
            }
            if(real>num){
                //Scenario 2: the input value is greater than the random value
                iv_down.setBackgroundResource(R.drawable.down);
                iv_down.setVisibility(View.VISIBLE);
                iv_up.setVisibility(View.VISIBLE);
                tv_name.setText("Lorem ipsum");
                button.setBackgroundResource(R.drawable.wrong);

            }
            if(real<num){
                //Scenario 3: the input value is less than the random value
                iv_up.setBackgroundResource(R.drawable.up);
                iv_up.setVisibility(View.VISIBLE);
                iv_down.setVisibility(View.VISIBLE);
                tv_name.setText("Lorem ipsum");
                button.setBackgroundResource(R.drawable.wrong);

            }
        }

        if(et.getText().length()==0){
            Toast.makeText(MainActivity.this, "please input your guess", Toast.LENGTH_SHORT).show();
        }
    }

}
