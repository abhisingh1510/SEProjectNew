package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class AdministratorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_page);
        Button assignCalls=findViewById(R.id.assignCalls_btn);
        Button billing=findViewById(R.id.billing_btn);
        Button logout=findViewById(R.id.logout_btn);
        assignCalls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent( AdministratorPage.this, AssignCallsPage.class));
            }
        });
        billing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    int n=1;//length/no. of query
                    int id[]=new int[n];//will store id of query
                    String tech[]=new String[n];//Plumer, etc. Technician type
                    int rate[]=new int[n];
                    int st[]=new int[n];//Start time
                    int end[]=new int[n];//end time
                    int cost[]=new int[n];

                    id[0]=1;
                    tech[0]="Plumber";
                    rate[0]=1000;
                    st[0]=1;
                    end[0]=1000;
                    cost[0]=10000;

                    String text="Dear Sir/Ma'am\\n Thank you for using IFB Services. Please find the payment details below-\\n";
                    text+="Id.\\t Technican\\t Start \\t End \\t Rate \\t Cost";
                    for(int i=0;i<n;i++)
                    {
                        text+=Integer.toString(id[0])+"\\t"+tech[0]+"\\t"+Integer.toString(st[i])+"\\t";
                        text+=Integer.toString(end[i])+"\\t"+Integer.toString(rate[i])+"\\t"+Integer.toString(cost[i])+"\\n";
                    }

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"f20160081@hyderabad.bits-pilani.ac.in"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "Bill of IFB Services");
                    i.putExtra(Intent.EXTRA_TEXT   , text);
                    try
                    {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        ex.getStackTrace();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            });
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent( AdministratorPage.this, FirstPage.class));
            }
        });


    }
}
