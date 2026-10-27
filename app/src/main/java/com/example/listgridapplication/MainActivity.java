package com.example.listgridapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etData;
    Button btnAdd;
    ListView listView;
    GridView gridView;

    ArrayList<String> array1 = new ArrayList<>();
    ArrayList<String> array2 = new ArrayList<>();

    ArrayAdapter<String> listAdapter;
    ArrayAdapter<String> gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.etData);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        listAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                array1
        ) {
            @Override
            public View getView(
                    int position,
                    View convertView,
                    ViewGroup parent) {

                View view = super.getView(
                        position, convertView, parent);

                TextView textView = (TextView) view;
                textView.setTextColor(Color.BLACK);

                return view;
            }
        };

        gridAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                array2
        ) {
            @Override
            public View getView(
                    int position,
                    View convertView,
                    ViewGroup parent) {

                View view = super.getView(
                        position, convertView, parent);

                TextView textView = (TextView) view;
                textView.setTextColor(Color.BLACK);

                return view;
            }
        };

        listView.setAdapter(listAdapter);
        gridView.setAdapter(gridAdapter);

        btnAdd.setOnClickListener(v -> {

            String data = etData.getText()
                    .toString().trim();

            if (!data.isEmpty()) {

                array1.add(data);
                array2.add(data);

                listAdapter.notifyDataSetChanged();
                gridAdapter.notifyDataSetChanged();

                etData.setText("");

            } else {

                Toast.makeText(
                        MainActivity.this,
                        "Please enter data",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}