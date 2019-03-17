package com.example.mybrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    WebView webView;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText=findViewById(R.id.enter);
        button=findViewById(R.id.btn);
        webView=findViewById(R.id.web);

        Intent intent=getIntent();
        if(intent.getData()!=null)
        {
            string=intent.getData().toString();
            seturl(string);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                string=editText.getText().toString();
                seturl(string);
            }
        });

    }

    public  class  MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String string)
        {
            view.loadUrl(string);
            return true;
        }
    }

    public  void  seturl(String string)
    {
        editText.setText(string);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl(string);
    }

}
