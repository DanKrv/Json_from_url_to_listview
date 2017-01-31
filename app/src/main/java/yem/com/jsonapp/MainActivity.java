package yem.com.jsonapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    List<BooksData> books;
    ArrayAdapter booksAdapter;
    ListView booksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JSONAsync().execute();

    }

    class JSONAsync extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this, null, "Loading", true, false);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            JSONObject jsonObject = new JSONHttp().getJSONFromUrl();
            books = new JSONParser().parse(jsonObject);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            booksListView = (ListView)findViewById(R.id.books_listview);
            booksAdapter = new BooksAdapter(MainActivity.this, R.layout.listview_item, books);
            booksListView.setAdapter(booksAdapter);
            booksAdapter.notifyDataSetChanged();

            progressDialog.dismiss();
        }
    }
}
