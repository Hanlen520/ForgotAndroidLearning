package tech.fuge.www.forgotheadfirstandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import tech.fuge.www.forgotheadfirstandroid.R;

public class ActionbarActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
//        ActionBar actionBar = getActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.actionbar_bar);
        toolbar.setTitle("toobar");
        toolbar.setLogo(R.mipmap.ic_launcher);
//        toolbar.setLogo(R.drawable.ic_action_share);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.title_menu, menu);
//        MenuItem menuItem = menu.findItem(R.id.title_menu_share);
//        shareActionProvider =(ShareActionProvider)menuItem.getActionProvider();
//        setIntent("This is example text");
        return super.onCreateOptionsMenu(menu);
    }

    private void setIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.title_menu_share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND)
//                        .setType("text/plain")
//                        .putExtra(Intent.EXTRA_TEXT, "选择器：发送给别人的消息");
//                String chosenTitle = getString(R.string.chooser);
//                Intent chosenIntent = Intent.createChooser(intent, chosenTitle);
//                startActivity(chosenIntent);
//                Snackbar.make(item.getActionView(),"press share",Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.title_menu_setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(Intent.EXTRA_TEXT, "选择器：发送给别人的消息");
                String chosenTitle = getString(R.string.chooser);
                Intent chosenIntent = Intent.createChooser(intent, chosenTitle);
                startActivity(chosenIntent);
//                Snackbar.make(item.getActionView(),"press setting",Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.title_menu_add:
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
//                Snackbar.make(item.getActionView(),"press add",Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.title_menu_minus:
                Toast.makeText(this, "minus", Toast.LENGTH_SHORT).show();
//                Snackbar.make(item.getActionView(),"press minus",Snackbar.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
