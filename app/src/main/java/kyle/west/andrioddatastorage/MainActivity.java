package kyle.west.andrioddatastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = this.getPreferences(Context.MODE_PRIVATE);
        int count = pref.getInt("count", 0);
        TextView c = (TextView) findViewById(R.id.count);
        c.setText("" + count);
    }

    public void advance(View v) {
        TextView c = (TextView) findViewById(R.id.count);
        int count = Integer.parseInt("" + c.getText());
        c.setText("" + ++count);
    }

    public void save(View v){
        SharedPreferences pref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        TextView c = (TextView) findViewById(R.id.count);
        int count = Integer.parseInt("" + c.getText());
        edit.putInt("count", count);
        edit.commit();
    }
}
