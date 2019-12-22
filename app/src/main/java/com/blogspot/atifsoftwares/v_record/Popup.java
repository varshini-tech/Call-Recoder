package com.blogspot.atifsoftwares.v_record;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.io.File;

public class Popup extends AppCompatActivity implements Pop {


    Button btn1, btn2;


    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_popup);
        //setContentView(R.layout.popup);
        //setContentView(R.layout.popup);
        //  loadingPopup();
        // setContentView(loadingPopup());

        LayoutInflater inflater = this.getLayoutInflater();
        final View layout = inflater.inflate(R.layout.popup, null);

        final PopupWindow windows = new PopupWindow(layout, 300, 300, true);
        windows.setFocusable(false);
        windows.setTouchable(true);
        windows.setOutsideTouchable(true);
        layout.post(new Runnable() {
            @Override
            public void run() {
                windows.showAtLocation(layout, Gravity.CENTER, 0, 0);
            }
        });

        setContentView(R.layout.popup);
        btn1 = (Button) findViewById(R.id.rec_btn);
        btn2 = (Button) findViewById(R.id.can_btn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Popup.this, "Canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(Popup.this, "Recorder choosen", Toast.LENGTH_SHORT).show();

                Intent i1=new Intent(Popup.this,Recoder.class);
                startActivity(i1);

                Toast.makeText(Popup.this, "Recorder choosen", Toast.LENGTH_SHORT).show();
               /* file=Environment.getExternalStoragePublicDirectory(Environment.MEDIA_UNKNOWN);
                rec=new MediaRecorder();
                rec.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
                rec.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                rec.setOutputFile(file.getAbsolutePath()+"/"+"rec");
                rec.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);


                TelephonyManager manager=(TelephonyManager)getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
                manager.listen(new PhoneStateListener(){

                    @Override
                    public void onCallStateChanged(int state, String phoneNumber) {
                        super.onCallStateChanged(state, phoneNumber);{
                            if(TelephonyManager.CALL_STATE_IDLE==state && rec==null){
                                rec.stop();
                                rec.reset();
                                rec.release();
                                recordstarted=false;

                            }

                            else if(TelephonyManager.CALL_STATE_OFFHOOK==state){


                                try{
                                    rec.prepare();
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                }
                                rec.start();
                                recordstarted=true;



                            }
                        }
                    }
                },PhoneStateListener.LISTEN_CALL_STATE);


            }*/
            }

        });


    }
}