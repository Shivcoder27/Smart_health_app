package com.example.my_health;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OederConfirme extends AppCompatActivity {

    EditText cstmr_name1,c_phone1,adress1,trnx_id1,prudct_code1;
    Button confirm_button1,cancel_button1;
    ImageView number_copy3;
    public static String usernameprdct="";
    public static String finalTotalamount="";
    private WebView webView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oeder_confirme);

//        // Initialize the WebView
//        webView = findViewById(R.id.webView);
//
//        // Enable JavaScript
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        // Ensure the web page fits the screen size
//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setUseWideViewPort(true);

//        // Load the URL
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("https://e-hcm.netlify.app/");

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        // Load the URL that will trigger MetaMask
        String metaMaskUrl = "https://metamask.app.link/dapp/YOUR_DAPP_URL";
        webView.loadUrl(metaMaskUrl);






















//        cstmr_name1=findViewById(R.id.cstmr_name1);
//        c_phone1=findViewById(R.id.c_phone1);
//        adress1=findViewById(R.id.adress1);
//        trnx_id1=findViewById(R.id.trnx_id1);
//        prudct_code1=findViewById(R.id.prudct_code1);
//        confirm_button1=findViewById(R.id.confirm_button1);
//        cancel_button1=findViewById(R.id.cancel_button1);
//        number_copy3=findViewById(R.id.number_copy3);
//
//        number_copy3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","01613120090", null));
//                startActivity(intent);
//
//
//
//
//            }
//        });
//
//        cancel_button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(OederConfirme.this,myorders.class));
//            }
//        });
//
//        confirm_button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                String cstmr_name=cstmr_name1.getText().toString();
//                String c_phone=c_phone1.getText().toString();
//                String adress=adress1.getText().toString();
//                String trnx_id=trnx_id1.getText().toString();
//                String prudct_name=prudct_code1.getText().toString();
//
//
//
//                if (prudct_name.length()==0){
//                    prudct_code1.setError("Enter product name");
//                }
//               else if (cstmr_name.length()==0){
//                    cstmr_name1.setError("Enter your name");
//                }
//
//                else if (c_phone.length()==0){
//                    c_phone1.setError("Enter your phone number");
//                }
//                //  else if (cstmr_gmail.length()==0){
//                //     cstmr_gmail1.setError("Enter your gmail");
//                //  }
//                else if (adress.length()==0){
//                    adress1.setError("Enter your full adress");
//                }
//
//                else if (trnx_id.length()==0){
//                    adress1.setError("Enter your trnx_id");
//                }
//                else {
//
//                    String url = "http://onlineshp.scopesoftwarecompany.com/greentest/orderlist.php?cstmr_name=" + cstmr_name
//                            + "&c_phone=" + c_phone + "&adress=" + adress + "&trnx_id=" + trnx_id+ "&prudct_name=" + prudct_name  + "&finalTotalamount=" + finalTotalamount;
//                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                          //  simpleProgressBar.setVisibility(View.GONE);
//
//
//
//
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//
//                        }
//                    });
//
//                    RequestQueue requestQueue = Volley.newRequestQueue(OederConfirme.this);
//                    requestQueue.add(stringRequest);
//                    Toast.makeText(OederConfirme.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(OederConfirme.this,Home.class));
//                }
//
//
//
//
//            }
//        });
//
//


    }
}