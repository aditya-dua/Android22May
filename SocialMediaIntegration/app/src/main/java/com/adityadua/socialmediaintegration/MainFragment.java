package com.adityadua.socialmediaintegration;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by AdityaDua on 21/07/17.
 */

public class MainFragment extends Fragment implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener,GoogleApiClient.ConnectionCallbacks {

    LoginButton loginButton;
    CallbackManager callbackManager;
    ProgressDialog progressDialog;
    TextView first_name , last_name;
    GoogleApiClient mGoogleAPIApiClient;
    SignInButton signInButton;
    private static  final int RC_SIGN_IN=9001;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment,container,false);

        first_name =(TextView)view.findViewById(R.id.first_name);
        last_name=(TextView)view.findViewById(R.id.last_name);
        loginButton =(LoginButton)view.findViewById(R.id.login_button);
        loginButton.setFragment(this);


        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleAPIApiClient =new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .enableAutoManage((FragmentActivity)getActivity(),this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        signInButton =(SignInButton) view.findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(gso.getScopeArray());
        signInButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager =CallbackManager.Factory.create();

    }
    private Bundle getFacebookData(JSONObject object){
        return  null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sign_in_button :
                signIN();
                // call a method..
                break;
            case R.id.login_button :
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","public_profile"));

                loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.i("FB Login Success","SUccess");
                        progressDialog = new ProgressDialog(getActivity());
                        progressDialog.setMessage("Processingggg");
                        progressDialog.show();
                        String accessToken =loginResult.getAccessToken().getToken();
                        Log.i("access token",accessToken);

                        GraphRequest request=GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.i("Login Activity",response.toString());

                                Bundle bFBData=getFacebookData(object);
                                first_name.setText("FirstName:"+bFBData.getString("first_name"));
                                last_name.setText("SecondNmae :"+bFBData.getString("last_name"));

                            }
                        });

                        Bundle params=new Bundle();
                        params.putString("fields","id,first_name,last_name");
                        request.setParameters(params);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
        }

    }
    private void signIN(){
        Intent signIn= Auth.GoogleSignInApi.getSignInIntent(mGoogleAPIApiClient);
        startActivityForResult(signIn,RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }else{
            callbackManager.onActivityResult(requestCode,resultCode,data);
        }

    }
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount acct = result.getSignInAccount();
            first_name.setText("Display NAme :"+acct.getDisplayName());
            last_name.setText("Given Name :"+acct.getGivenName());
        }else{
            Toast.makeText(getActivity(),"Signin Failure",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mGoogleAPIApiClient.connect();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        mGoogleAPIApiClient.disconnect();
    }
}
