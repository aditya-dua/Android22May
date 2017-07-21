package com.adityadua.socialmediaintegration;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        printKeyHash(this);
    }

    public static  String printKeyHash(Activity context){
        PackageInfo packageInfo;
        String key=null;

        try{
            String packageName=context.getApplicationContext().getPackageName();

            packageInfo=context.getPackageManager().getPackageInfo(packageName,PackageManager.GET_SIGNATURES);
             for (Signature signature:packageInfo.signatures){
                 MessageDigest messageDigest= MessageDigest.getInstance("SHA");
                 messageDigest.update(signature.toByteArray());
                 key=new String(Base64.encode(messageDigest.digest(),0));
                 Log.i("Key Is :",key);
             }



        }catch (PackageManager.NameNotFoundException e){

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return  key;

    }
}
