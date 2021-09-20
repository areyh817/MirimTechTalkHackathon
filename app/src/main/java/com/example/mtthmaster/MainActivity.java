package com.example.mtthmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnSearch;
    EditText editId;
    TextView name, location, bio, publicrepos, publicgits, followers, following;
    ImageView profileImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MirimTechTalkHackathon");

        // findViewById
        btnSearch = findViewById(R.id.btnSearch);
        editId = findViewById(R.id.editId);
        name = findViewById(R.id.name);
        location = findViewById(R.id.Location);
        bio = findViewById(R.id.bio);
        publicrepos = findViewById(R.id.Publicrepos);
        publicgits = findViewById(R.id.Publicgits);
        followers = findViewById(R.id.Followers);
        following = findViewById(R.id.Following);
        profileImage = findViewById(R.id.profileImage);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProfileRemoteService profileremoteservice = retrofit.create(ProfileRemoteService.class);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ProflieResponse> call = profileremoteservice.getPosts(editId.getText().toString());

                call.enqueue(new Callback<ProflieResponse>() {
                    @Override
                    public void onResponse(Call<ProflieResponse> call, Response<ProflieResponse> response) {
                        if(response.isSuccessful()){
                            ProflieResponse profile = response.body();

                            // String type
                            name.setText(profile.getName());
                            location.setText(profile.getLocation());
                            bio.setText(profile.getBio());

                            // Image
                            Glide.with(getApplicationContext()).load(profile.getAvatar_url()).into(profileImage);

                            // int type
                            publicgits.setText(Integer.toString(profile.getPublicGits()));
                            publicrepos.setText(Integer.toString(profile.getPublicRepos()));
                            followers.setText(Integer.toString(profile.getFollowers()));
                            following.setText(Integer.toString(profile.getFollowing()));

                        }
                    }

                    @Override
                    public void onFailure(Call<ProflieResponse> call, Throwable t) {

                    }

                });
            }
        });

    }
}