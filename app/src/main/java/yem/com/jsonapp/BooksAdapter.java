package yem.com.jsonapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static yem.com.jsonapp.BooksAdapter.ViewHolder.*;

/**
 * Created by DanKravitz on 30/01/2017.
 */

public class BooksAdapter extends ArrayAdapter<BooksData> {

    public BooksAdapter(Context context, int resource, List<BooksData> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        BooksData booksData = getItem(position);
        holder.bookTitle.setText(booksData.getBook_title());
        holder.bookAuth.setText(booksData.getAuthor());
        holder.bookImage.setImageBitmap(booksData.getBitmap());

        return convertView;
    }

    class ViewHolder {
        private TextView bookTitle;
        private TextView bookAuth;
        private ImageView bookImage;

        public ViewHolder(View view) {
            bookTitle = (TextView) view.findViewById(R.id.book_title);
            bookAuth = (TextView) view.findViewById(R.id.auth_name);
            bookImage = (ImageView) view.findViewById(R.id.iv_author);
        }
    }
}
