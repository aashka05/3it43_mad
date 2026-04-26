package com.example.a05_2_firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    TextView tv;
    String docId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        FirebaseApp.initializeApp(this);
        db = FirebaseFirestore.getInstance();
    }
    String l = "";
    public void sel(View v) {

        db.collection("users")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                        //System.out.println(doc.getId() + " => " + doc.getData());
                        l += (doc.getId() + " => " + doc.getData() + "\n");
                    }
                })
                .addOnFailureListener(e -> {
                    System.out.println("Error: " + e.getMessage());
                });
        tv.setText(l);
    }
    public void ins(View v) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Aashka");
        user.put("age", 20);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    docId = documentReference.getId();
                    System.out.println("Data added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    System.out.println("Error: " + e.getMessage());
                });
    }
    public void upd(View v) {
        String docId = "your_doc_id";

        db.collection("users")
                .document(docId)
                .update("age", 21)
                .addOnSuccessListener(aVoid -> {
                    System.out.println("Updated");
                });
    }
    public void del(View v) {
        db.collection("users")
                .document(docId)
                .delete()
                .addOnSuccessListener(aVoid -> {
                    System.out.println("Deleted");
                });
    }
}