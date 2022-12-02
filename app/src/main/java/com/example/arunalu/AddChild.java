package com.example.arunalu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.arunalu.db.DbHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;
import static com.example.arunalu.addSubUser.dbHelper;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddChild#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddChild extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String[] gender_array = {"Female","Male"};
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText userId, fName, age;
    Spinner gender;
    Button register;
    ImageView subUserPic;
    private Bitmap bitmap;
    public static final int RESULT_LOAD_IMAGE = 1;
    public AddChild() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddChild.
     */
    // TODO: Rename and change types and number of parameters
    public static AddChild newInstance(String param1, String param2) {
        AddChild fragment = new AddChild();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_child, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.userGender);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getActivity(), android.R.layout.simple_spinner_item, gender_array);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // Inflate the layout for this fragment
        userId = view.findViewById(R.id.userName);
        fName = view.findViewById(R.id.firstName);
        age = view.findViewById(R.id.userAge);
        gender = view.findViewById(R.id.userGender);
        subUserPic = view.findViewById(R.id.subUserPic);
        register = view.findViewById(R.id.register);

        return view;
    }

//    public void AddSubUser(){
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dbHelper.insertData("P001",userId.getText().toString(), fName.getText().toString(), gender.getSelectedItem().toString(), subUserPic, age.getText().toString());
//            }
//        });
//    }

    private void choosePicture(){
        subUserPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Profile Picture"),1);
            }
        });

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//
//        //Detects request codes
//        if(requestCode==RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK) {
//            Uri selectedImage = data.getData();
//            Bitmap bitmap = null;
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), selectedImage);
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void onActivityResult(int resquestCode, int resultCode, Intent data){
        super.onActivityResult(resquestCode,resultCode,data);
        if (resquestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri picturePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), picturePath);
                subUserPic.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }

            UploadPicture(String.valueOf(userId), getStringImage(bitmap));
        }
    }

    private void UploadPicture(final String id, final String photo) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Uploading...");
        progressDialog.show();

//        StringRequest stringRequest = new StringRequest
    }

    public String getStringImage(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] imageByteArray = byteArrayOutputStream.toByteArray();
        String encodedImage = Base64.encodeToString(imageByteArray, Base64.DEFAULT);
        return  encodedImage;
    }
}
