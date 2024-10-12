package com.example.my_health;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.HashMap;

public class medicines extends AppCompatActivity {
    WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtest);

        // Initialize the WebView
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);

        // Enable JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Ensure the web page fits the screen size
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        // Handle URL loading and interaction with MetaMask
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, @NonNull WebResourceRequest request) {
                String url = request.getUrl().toString();

                if (url.startsWith("intent://")) {
                    try {
                        Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                        if (intent != null) {
                            startActivity(intent);
                            return true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (url.startsWith("ethereum:") || url.startsWith("https://metamask.app.link/")) {
                    // Direct the user to MetaMask
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // Default WebView behavior
                view.loadUrl(url);
                return true;
            }
        });
        // Set a WebChromeClient to handle progress updates
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
//

        // Load your initial URL
        webView.loadUrl("https://dainty-crepe-7f8341.netlify.app/medicine");
    }
}
//
//
//        Button myorders,back;
//    ListView list;
//    SimpleAdapter adapt;
//    ArrayList lists;
//    HashMap<String, String> item;
//    private String[][] packages={{"Xalatan Eye Drop 2.5ml ","1691"},
//            {"Cosopt Eye Drop 5ml ","1405 "},
//            {"Acefyl 125ml Syp " , "107 "},
//            {"Acenac Sr Tablets 200mg 30's " , "470 "},
//            {"Augmentin Suspension 156.25mg 90ml " , "192 "},
//            {"Babynol Cough Syrup 60ml " , "58"},
//
//
//    };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_medicines);
//        list =findViewById(R.id.art_list);
//        myorders =findViewById(R.id.tomyorders_med);
//        back =findViewById(R.id.art_back);
//        lists = new ArrayList();
//        for(int i = 0 ; i < packages.length;i++){
//            item = new HashMap<String, String>();
//            item.put("name",packages[i][0]);
//            item.put("price","PRICE = "+packages[i][1]);
//            lists.add(item);
//        }
//
//        adapt= new SimpleAdapter(this,lists,R.layout.medicine_adap,new String[]{"name","price"},
//                new int[]{R.id.m_name, R.id.m_price});
//
//        list.setAdapter(adapt);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                Intent intent = new Intent(medicines.this,medicine.class);
//                intent.putExtra("name",packages[i][0]);
//                intent.putExtra("price",packages[i][1]);
//                startActivity(intent);
//            }
//        });
//        myorders.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(medicines.this,myorders.class) );
//            }
//        });
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(medicines.this,Home.class));
//            }
//        });
//    }
//}