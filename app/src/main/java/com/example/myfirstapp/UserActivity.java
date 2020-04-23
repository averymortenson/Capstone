package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class UserActivity extends AppCompatActivity {
    TextView profileName;
    ImageView profileImg;
    Button changeImg, editBioBtn, saveBioBtn;
    EditText bioText;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    StorageReference storageReference;
    StorageReference profileImgRef;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        saveBioBtn = findViewById(R.id.saveBioButton);
        editBioBtn = findViewById(R.id.editBioButton);
        profileName = findViewById(R.id.profileNameTV);
        profileImg = (ImageView) findViewById(R.id.profileIV);
        changeImg = findViewById(R.id.changeImageBTN);
        bioText = findViewById(R.id.bioEditText);
        bioText.setEnabled(false);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        profileImgRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/Profile.jpg");

        // get the user profile image from the database.
        profileImgRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).rotate(270).into(profileImg);
            }
        });

        userID = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference1 = fStore.collection("bios/"+ fAuth.getCurrentUser().getUid() + "/bio").document(userID);
        documentReference1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@androidx.annotation.Nullable DocumentSnapshot documentSnapshot, @androidx.annotation.Nullable FirebaseFirestoreException e) {
                bioText.setText(documentSnapshot.getString("bioText"));
            }
        });

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                profileName.setText(documentSnapshot.getString("fullName"));
            }
        });

        // open the users phone gallery and let them select an image.
        changeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open users gallery.
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery,1000);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavBar);
        android.view.Menu menu = bottomNavigationView.getMenu();
        android.view.MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.searchIcon:
                        Intent toSearchActivity = new Intent(UserActivity.this,SearchActivity.class);
                        startActivity(toSearchActivity);
                        break;
                    case R.id.homeIcon:
                        Intent toHomeActivity = new Intent(UserActivity.this,HomeActivity.class);
                        startActivity(toHomeActivity);
                        break;
                    case R.id.messageIcon:
                        Intent toMessageActivity = new Intent(UserActivity.this,MessageActivity.class);
                        startActivity(toMessageActivity);
                        break;
                    case R.id.userIcon:
                        break;
                }
                return false;
            }
        });

        editBioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bioText.setEnabled(true);
            }
        });

        // save the bio to the database and retrieve it back to the Edit text.
        saveBioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bioText.setEnabled(false);
                String getBioText = bioText.getText().toString();
                userID = fAuth.getCurrentUser().getUid();
                DocumentReference documentReference = fStore.collection("bios/"+ fAuth.getCurrentUser().getUid() + "/bio").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("bioText", getBioText);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Tag", "On success: user bio is created for " + userID);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Tag", "On failure: " + e.toString());
                    }
                });
            }
        });
    }

    // get the image from the database and set it to the image view.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                profileImg.setImageURI(imageUri);
                uploadImageToFirebase(imageUri);
            }
        }
    }

    private void uploadImageToFirebase(Uri imageUri) {
        final StorageReference fileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/Profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).rotate(270).into(profileImg);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UserActivity.this, "Image upload failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
