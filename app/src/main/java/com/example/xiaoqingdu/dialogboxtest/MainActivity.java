package com.example.xiaoqingdu.dialogboxtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(com.example.xiaoqingdu.dialogboxtest.R.id.buttontest);
        Button btn=(Button)findViewById(com.example.xiaoqingdu.dialogboxtest.R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater=getLayoutInflater();
                final View view=inflater.inflate(com.example.xiaoqingdu.dialogboxtest.R.layout.login_dialog,null);
                builder.setView(view)
                        .setTitle("Login")
                        .setPositiveButton(com.example.xiaoqingdu.dialogboxtest.R.string.login,new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialogInterface,int id){
                                EditText editText=(EditText)view.findViewById(com.example.xiaoqingdu.dialogboxtest.R.id.editTextUserId);
                                EditText editText1=(EditText)view.findViewById(com.example.xiaoqingdu.dialogboxtest.R.id.editTextPwd);

                                String str=editText.getText().toString();
                                String string=editText1.getText().toString();
                                if(str.equals("abc")&&string.equals("123")){
                                    Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton(com.example.xiaoqingdu.dialogboxtest.R.string.cancel,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface,int id){
                        Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个普通的对话框")
                .setTitle("对话框");
                builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface,int which){
                        Toast.makeText(MainActivity.this,"用户按下了确定按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface,int which){
                        Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
    }
}
