
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

    }


    @Override
    protected void onResume() {
        super.onResume();
        transaction = findViewById(R.id.transactions);


        ArrayList<TransactionClass> listTrans =  new ArrayList<TransactionClass>();

        listTrans.add(new TransactionClass(R.drawable.chat,"first one"));
        listTrans.add(new TransactionClass(R.drawable.info,"second one "));
        listTrans.add(new TransactionClass(R.drawable.dietician,"third one"));
        listTrans.add(new TransactionClass(R.drawable.family_physicians,"fourth one"));


        TransactionAdapter adapter = new TransactionAdapter(this,R.layout.activity_transaction,listTrans);

        transaction.setAdapter(adapter);





    }

}