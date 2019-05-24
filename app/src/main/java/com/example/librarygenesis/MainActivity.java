package com.example.librarygenesis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner filterSpinner;
    private Spinner formatSpinner;
    private Spinner sortBySpinner;
    private ArrayAdapter<String> filterAdapter;
    private ArrayAdapter<String> formatAdapter;
    private ArrayAdapter<String> sortByAdapter;
    private EditText searchInput;
    private Button searchButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateInputBoxes();
        CreateSpinners();
        CreateButtons();
    }

    private void CreateInputBoxes() {
        this.searchInput = findViewById(R.id.search_bar);

    }

    private void CreateSpinners() {
        // initialize the filter, format and sort by drop down menu's
        this.filterSpinner = findViewById(R.id.filter_drop_down_menu);
        this.formatSpinner = findViewById(R.id.format_drop_down_menu);
        this.sortBySpinner = findViewById(R.id.sort_by_drop_down_menu);

        this.filterAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.filter_choices));
        this.formatAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.format_choices));
        this.sortByAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sort_by_choices));

        this.filterAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.formatAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.sortByAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        this.filterSpinner.setAdapter(this.filterAdapter);
        this.formatSpinner.setAdapter(this.formatAdapter);
        this.sortBySpinner.setAdapter(this.sortByAdapter);
    }

    private void CreateButtons() {
        this.searchButton = findViewById(R.id.search_button);
        this.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenResultsActivity();
            }
        });
    }

    private void OpenResultsActivity() {
        this.intent = new Intent(this, ResultsActivity.class);
        startActivity(this.intent);

    }
}
