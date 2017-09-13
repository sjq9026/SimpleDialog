package com.android.sjq.simpledialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dialogbtn = (Button) findViewById(R.id.dialog_btn);
        dialogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyDiaLog().setLayoutId(R.layout.itemlayout).setOnContentLayoutEventChangedListener(new OnContentLayoutEventChangedListener() {
                    @Override
                    public int OnContentLayoutEventChanged(ViewHolder vh,final BaseFragmentDialog dialog) {
                       vh.getViewById(R.id.ysw_tv).setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               Toast.makeText(MainActivity.this,"已售完",Toast.LENGTH_LONG).show();
                               dialog.dismiss();
                           }
                       });
                        vh.getViewById(R.id.next_tv).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"下一步",Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        });
                        vh.getViewById(R.id.fq_tv).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"放弃",Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        });
                        return 0;
                    }
                }).show(getSupportFragmentManager());
            }
        });
    }
}
