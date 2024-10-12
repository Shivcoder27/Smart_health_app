package com.example.my_health;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class findmydoc extends AppCompatActivity {
    //    CardView physician , dentist , cardiologist , dietitian, surgeon , back;
    WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findmydoc);
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


        // Load your initial URL
        webView.loadUrl("https://dainty-crepe-7f8341.netlify.app/patient-dashboard");
    }
}


//        physician = findViewById(R.id.Physician);
//        dentist = findViewById(R.id.dentist);
//        cardiologist = findViewById(R.id.cardiologist);
//        dietitian = findViewById(R.id.dietition);
//        surgeon= findViewById(R.id.surgeon);
//        back= findViewById(R.id.back);
//
//        physician.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(findmydoc.this,doctors_details.class);
//                intent.putExtra("title","PHYSICIAN");
//                startActivity(intent);
//            }
//        });
//
//        dentist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(findmydoc.this,doctors_details.class);
//                intent.putExtra("title","DENTIST");
//                startActivity(intent);
//            }
//        });
//
//        surgeon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(findmydoc.this,doctors_details.class);
//                intent.putExtra("title","SURGEON");
//                startActivity(intent);
//            }
//        });
//
//        dietitian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(findmydoc.this,doctors_details.class);
//                intent.putExtra("title","DIETITIAN");
//                startActivity(intent);
//            }
//        });
//
//        cardiologist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(findmydoc.this,doctors_details.class);
//                intent.putExtra("title","CARDIOLOGIST");
//                startActivity(intent);
//            }
//        });
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(findmydoc.this,Home.class));
//            }
//        });
//
//    }
//}