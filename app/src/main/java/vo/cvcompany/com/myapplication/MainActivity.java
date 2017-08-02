package vo.cvcompany.com.myapplication;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;
    private ClipDrawable     clipDrawable ;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        clipDrawable = (ClipDrawable) img.getDrawable();
        img.setImageLevel(100);

    }

    @OnClick(R.id.button)
    public void button(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                int a  = clipDrawable.getLevel()+500;
                if(a>10000){
                    a=0;
                }
                img.setImageLevel(a);
                handler.postDelayed(this, 1);
            }
        },2000);


    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    @OnClick(R.id.btnprogressBar)
    public void btnprogressBar(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int a =  progressBar.getProgress()+1;
                if(a>100)
                    a=0;
                progressBar.setProgress(a);
                handler.postDelayed(this,300);
            }
        }, 2000);
    }
}
