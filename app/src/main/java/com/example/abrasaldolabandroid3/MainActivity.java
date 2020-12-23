package com.example.abrasaldolabandroid3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private AutoCompleteTextView actv_petType;
    private AutoCompleteTextView actv_petBreed;

    private Button btn_process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actv_petType = findViewById(R.id.autoCompleteType);
        actv_petBreed = findViewById(R.id.autoCompleteBreed);

        btn_process = findViewById(R.id.process);
        btn_process.setVisibility(View.INVISIBLE);
        btn_process.setOnClickListener(this);
        String[] petType = getResources().getStringArray(R.array.petType);

        ArrayAdapter<String> arrayAdapterPetType = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, petType);
        actv_petType.setAdapter(arrayAdapterPetType);

        actv_petType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String petType = parent.getAdapter().getItem(position).toString();
                String[] petBreed = new String[0];
                switch(petType) {
                    case "Dog":
                        petBreed = getResources().getStringArray(R.array.dogBreed);
                        break;
                    case "Cat":
                        petBreed = getResources().getStringArray(R.array.catBreed);
                        break;
                    case "Snake":
                        petBreed = getResources().getStringArray(R.array.snakeBreed);
                        break;
                    case "Pokemon":
                        petBreed = getResources().getStringArray(R.array.pokemonBreed);
                        break;
                }
                final ArrayAdapter<String> arrayAdapterPetBreed = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, petBreed);
                actv_petBreed.setAdapter(arrayAdapterPetBreed);
            }
        });
        actv_petBreed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btn_process.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.process:
                Toast.makeText(getApplicationContext(),
                        "Thank you for adopting this pet",
                        Toast.LENGTH_LONG).show();
                break;
        }
    }
}