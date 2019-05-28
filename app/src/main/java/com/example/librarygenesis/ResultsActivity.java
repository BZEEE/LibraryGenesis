package com.example.librarygenesis;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    ListView resultsList;
    String bookTitles[];
    String bookURLs[];
    int bookImages[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // get intent from main activity that opened up this activity
        Intent intent = new Intent();
        // retrieve all information from intent and search results
        // place into bookTitles[]
        // place into bookURLs[]
        // place into bookImages[]

//        resultsList = findViewById(R.id.searchResultsListView);
//
//        // create an adapter class that converts search information to list items
//        ResultsAdapter adapter = new ResultsAdapter(this, bookTitles, bookURLs, bookImages);
//        resultsList.setAdapter(adapter);
//
//        // now set item click on list
//        resultsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//                    // selected first link on the page, so got to the URL
//                }
//            }
//        });


    }

    class ResultsAdapter extends ArrayAdapter<String> {
        Context context;
        String bookTitle[];
        String bookURL[];
        int bookImages[];

        ResultsAdapter(Context c, String title[], String URL[], int images[]) {
            super(c, R.layout.row, R.id.bookTitle, title);
            this.context = c;
            this.bookTitle = title;
            this.bookURL = URL;
            this.bookImages = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.rowImage);
            TextView title = row.findViewById(R.id.bookTitle);
            TextView URLLink = row.findViewById(R.id.URLLink);

            images.setImageResource(bookImages[position]);
            title.setText(bookTitle[position]);
            URLLink.setText(bookURL[position]);

            return row;
        }
    }
}
