package com.ivan.pertemuan5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {


    Button button1,button2,button3,button4,button5,button6,btStart;
    ProgressDialog progressDialog;
    private NotificationUtils mNotificationUtils;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btStart = (Button)findViewById(R.id.btStart);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(
                        R.color.transparent
                );
            }
        });

        mNotificationUtils = new NotificationUtils(this);

        final EditText editTextTitleAndroid = (EditText) findViewById(R.id.et_android_title);
        final EditText editTextAuthorAndroid = (EditText) findViewById(R.id.et_android_author);
        Button buttonAndroid = (Button) findViewById(R.id.btn_send_android);

        buttonAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitleAndroid.getText().toString();
                String author = editTextAuthorAndroid.getText().toString();

                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(author)) {
                    Notification.Builder nb = mNotificationUtils.getAndroidChannelNotification(title, "By " + author);
                    mNotificationUtils.getManager().notify(101, nb.build());
                }
            }
        });

        Button buttonAndroidNotifSettings = (Button) findViewById(R.id.btn_android_notif_settings);
        buttonAndroidNotifSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                i.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                i.putExtra(Settings.EXTRA_CHANNEL_ID, NotificationUtils.ANDROID_CHANNEL_ID);
                startActivity(i);
            }
        });










        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDenganTombol(v);
            }
        });

        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDenganTombol2(v);
            }
        });

        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDenganTombol3(v);
            }
        });

        button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTunggal(v);
            }
        });

        button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogGanda(v);
            }
        });

        button6=(Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDenganLayoutKhusus(v);
            }
        });





    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
    }

    public void dialogDenganTombol(View view){
        AlertDialog.Builder peringatan = new AlertDialog.Builder(this);
        peringatan.setIcon(R.mipmap.ic_launcher);
        peringatan.setTitle("Assalamualaikum");
        peringatan.setMessage("Selamat belajar android");

        peringatan.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "hayoo", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog pesan = peringatan.create();
        pesan.show();
    }

    public void dialogDenganTombol2(View view){
        AlertDialog.Builder peringatan = new AlertDialog.Builder(this);
        peringatan.setIcon(R.mipmap.ic_launcher);
        peringatan.setTitle("Assalamualaikum");
        peringatan.setMessage("Selamat belajar android");

        peringatan.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "hayoo", Toast.LENGTH_SHORT).show();
            }
        });
        peringatan.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Gagal",Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog pesan = peringatan.create();
        pesan.show();
    }


    public void dialogDenganTombol3(View view){
        AlertDialog.Builder peringatan = new AlertDialog.Builder(this);
        peringatan.setIcon(R.mipmap.ic_launcher);
        peringatan.setTitle("Assalamualaikum");
        peringatan.setMessage("Selamat belajar android");

        peringatan.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "hayoo", Toast.LENGTH_SHORT).show();
            }
        });
        peringatan.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Gagal",Toast.LENGTH_SHORT).show();
            }
        });
        peringatan.setNeutralButton("on", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "hahahaha", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog pesan = peringatan.create();
        pesan.show();
    }

    public void dialogTunggal(View view){
        final String pilihan[] = {"Merah","Kuning","Hijau","Biru"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Silahkan pilih warna dibawah ini")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(pilihan, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "choose color "+ pilihan[which], Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }


    ArrayList selectedItems = new ArrayList();
    public void dialogGanda(View view){
        final String pilihan[] = {"Merah","Kuning","Hijau","Biru"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Silahkan pilih warna dibawah ini")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(pilihan, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            selectedItems.add(which);
                        }else if(selectedItems.add(which)){
                            selectedItems.remove(Integer.valueOf(which));
                        }
                    }
                })
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

    public void dialogDenganLayoutKhusus(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.layout_mask,null))
                .setPositiveButton("Masuk", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();




    }







}