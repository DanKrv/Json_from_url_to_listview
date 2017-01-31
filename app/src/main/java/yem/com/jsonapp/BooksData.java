package yem.com.jsonapp;

import android.graphics.Bitmap;

/**
 * Created by DanKravitz on 30/01/2017.
 */

public class BooksData {
    String book_title, author;
    Bitmap bitmap;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
