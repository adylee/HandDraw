package com.example.administrator.handdraw;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    EmbossMaskFilter emboss;
    BlurMaskFilter blur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setContentView(DrawView.this);
        emboss = new EmbossMaskFilter(new float[]{1.5f,1.5f,1.5f},0.6f,5,4.2f);
        blur = new BlurMaskFilter(8,BlurMaskFilter.Blur.NORMAL);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflator = new MenuInflater(this);
        inflator.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        DrawView dv = (DrawView)findViewById(R.id.draw);
        switch (mi.getItemId()){
            case R.id.red:
                dv.paint.setColor(Color.RED);
                mi.setChecked(true);
                break;
            case R.id.green:
                dv.paint.setColor(Color.GREEN);
                mi.setChecked(true);
                break;
            case R.id.blue:
                dv.paint.setColor(Color.BLUE);
                mi.setChecked(true);
                break;
            case R.id.width_1:
                dv.paint.setStrokeWidth(1);
                break;
            case R.id.width_3:
                dv.paint.setStrokeWidth(3);
                break;
            case R.id.width_5:
                dv.paint.setStrokeWidth(5);
                break;
            case R.id.blur:
                dv.paint.setMaskFilter(blur);
                break;
            case R.id.emboss:
                dv.paint.setMaskFilter(emboss);
                break;
        }
        return true;
    }

}
