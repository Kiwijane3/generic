package kiwijane3.generic.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URI;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by janef on 13/01/17.
 */

public class NetImageTask extends WeakTask<URI, Bitmap, ImageView> {

    private static OkHttpClient client;

    public NetImageTask(ImageView target){
        super(target);
        // Ensure client is initialised.
        if (client == null){
            client = new OkHttpClient();
        }
    }


    @Override
    protected Bitmap doInBackground(URI... params) {
        try {
            Request request = new Request.Builder().url(params[0].toURL()).get().build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200){
                byte[] data = response.body().bytes();
                return BitmapFactory.decodeByteArray(data, 0, data.length);
            } else {
                return null;
            }
        } catch (MalformedURLException murle){
            return null;
        } catch (IOException ioe){
            return null;
        }
    }

    @Override
    protected void onFinish(ImageView target, Bitmap result) {
        target.setImageBitmap(result);
    }
}
