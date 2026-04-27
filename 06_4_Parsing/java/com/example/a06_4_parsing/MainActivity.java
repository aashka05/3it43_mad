package com.example.a06_4_parsing;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }
    public void toXml(View v) {
        try {
            InputStream is = getResources().openRawResource(R.raw.sample);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document doc = builder.parse(is);

            NodeList list = doc.getElementsByTagName("student");

            String result = "";

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                Element e = (Element) node;

                String name = e.getElementsByTagName("name").item(0).getTextContent();
                String age = e.getElementsByTagName("age").item(0).getTextContent();
                String course = e.getElementsByTagName("course").item(0).getTextContent();

                result += "Name: " + name + "\nAge: " + age + "\nCourse: " + course + "\n\n";
            }

            tv.setText(result);

        } catch (Exception e) {
            tv.setText(e.toString());
        }
    }
    public void toJson(View v) {
        try {
            InputStream is = getResources().openRawResource(R.raw.sample1);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            String json = new String(buffer);

            JSONObject obj = new JSONObject(json);
            JSONArray arr = obj.getJSONArray("students");

            String result = "";

            for (int i = 0; i < arr.length(); i++) {
                JSONObject student = arr.getJSONObject(i);

                String name = student.getString("name");
                int age = student.getInt("age");
                String course = student.getString("course");

                result += "Name: " + name + "\nAge: " + age + "\nCourse: " + course + "\n\n";
            }

            tv.setText(result);

        } catch (Exception e) {
            tv.setText(e.toString());
        }
    }
}