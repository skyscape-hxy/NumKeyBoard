package com.example.numkeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class NumKeyBoardView extends LinearLayout implements View.OnClickListener {
    private Context context;
    private OnKeyPressLinster linster;

    public NumKeyBoardView(Context context) {
        this(context, null);
    }

    public NumKeyBoardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumKeyBoardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.num_key_board, this);
        this.context = context;
        initAction();
    }


    private void initAction() {
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (linster==null){
            return;
        }
        if (v.getId() == R.id.back) {
            //走back
            linster.onBackPress();
        } else {
            //走数据结果通知
            if (v instanceof TextView){
                TextView textView= (TextView) v;
                String  text = ((TextView) v).getText().toString().trim();
                linster.onNumberPress(Integer.parseInt(text));
            }
        }
    }

    public void setLinster(OnKeyPressLinster linster) {
        this.linster = linster;
    }

    public interface OnKeyPressLinster {
        void onNumberPress(int number);

        void onBackPress();
    }
}
