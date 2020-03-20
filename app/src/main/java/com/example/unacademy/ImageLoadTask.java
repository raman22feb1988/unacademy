package com.example.unacademy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {
    private String l_url;
    private ImageView imageView;

    public ImageLoadTask(String l_url, ImageView imageView) {
        this.l_url = l_url;
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            SSLContext sslcontext = SSLContext.getInstance("TLSv1");
            sslcontext.init(null, null, null);
            SSLSocketFactory NoSSLv3Factory = new NoSSLv3SocketFactory(sslcontext.getSocketFactory());

            URL urlConnection = new URL(l_url);
            HttpsURLConnection.setDefaultSSLSocketFactory(NoSSLv3Factory);
            HttpsURLConnection l_connection = (HttpsURLConnection) urlConnection.openConnection();
            l_connection.setDoInput(true);
            l_connection.connect();
            InputStream input = l_connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        imageView.setImageBitmap(result);
    }
}