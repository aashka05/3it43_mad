package com.example.a02_6_adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Spinner sp;
    GridView gv;
    TextView tv;
    String[] data = {"A", "B", "C", "D"};
    ArrayAdapter<String> adap_lv, adap_sp, adap_gv;
    int posl;
    String posg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        sp = findViewById(R.id.sp);
        gv = findViewById(R.id.gv);
        tv = findViewById(R.id.tv);

        adap_lv = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, data);
        lv.setAdapter(adap_lv);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        adap_sp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        sp.setAdapter(adap_sp);

        adap_gv = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        gv.setAdapter(adap_gv);
        gv.setOnItemClickListener((parent, view,position, id) -> {posg = data[position];});
    }
    public void display(View v) {
        String result = "";
        posl = lv.getCheckedItemPosition();
        if(posl != -1) {
            result += ("ListView: " + data[posl] + "\n");
        }
        result += ("Spinner: " + sp.getSelectedItem().toString() + "\n");
        result += ("GridView: " + posg + "\n");
        tv.setText(result);
    }
}