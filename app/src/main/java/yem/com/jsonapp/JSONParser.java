package yem.com.jsonapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanKravitz on 29/01/2017.
 */
public class JSONParser {

    public List<BooksData> parse(JSONObject jsonObject) {
        List<BooksData> booksData = new ArrayList<>();
        BooksData bookData;

        try {
            JSONArray jsonArray = jsonObject.getJSONArray("book_array");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject books = jsonArray.getJSONObject(i);

                bookData = new BooksData();

                String book_title = books.getString("book_title");
                String image = books.getString("image");
                String author = books.getString("author");

                Bitmap authorBitmap = ImageBitmapUrl(image);
                bookData.setBitmap(authorBitmap);
                bookData.setBook_title(book_title);
                bookData.setAuthor(author);

                booksData.add(bookData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return booksData;
    }

    public Bitmap ImageBitmapUrl(String urlAuthor){
        URL url;
        try {
            url = new URL(urlAuthor);
            InputStream is = url.openConnection().getInputStream();
            return BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

