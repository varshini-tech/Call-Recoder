package com.blogspot.atifsoftwares.v_record;

import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.File;

public class Recoder extends AppCompatActivity {


    private MediaRecorder rec;
    private boolean recordstarted;
    private File file;
    //String path="Internal shared storage\MIUI\sound_recoder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoder);


        file=Environment.getExternalStoragePublicDirectory(Environment.MEDIA_UNKNOWN);
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


    }
    }

