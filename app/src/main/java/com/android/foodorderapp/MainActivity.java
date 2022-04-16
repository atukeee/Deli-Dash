package com.android.foodorderapp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
//For the LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager;
//For the recyclerView
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

//adapter for the restaurant List
import com.android.foodorderapp.adapters.RestaurantListAdapter;
import com.android.foodorderapp.model.RestaurantModel;

//it provides a frameworks for converting between JSON strings and Java Objects
import com.google.gson.Gson;

//It buffers the characters in order to enable efficient reading of text data
import java.io.BufferedReader;
//It need to define a subclass of InputStream must always provide a method that returns the next byte of input
import java.io.InputStream;
// It reads bytes and decodes them into characters using a specified charset
import java.io.InputStreamReader;
//Creates a new character-stream reader whose critical sections will synchronize on the reader itself.
import java.io.Reader;
//collects its output in a string buffer, which can then be used to construct a string
import java.io.StringWriter;
//collects its output in a string buffer, which can then be used to construct a string
import java.io.Writer;
//to create and access Java arrays
import java.util.Arrays;
//is used to display the list of items in multiple rows and contains an adapter that automatically inserts the items into the list
import java.util.List;

public class MainActivity extends AppCompatActivity implements RestaurantListAdapter.RestaurantListClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to hide the actionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //getting the List of Restaurant from RecyclerView
        List<RestaurantModel> restaurantModelList =  getRestaurantData();

        initRecyclerView(restaurantModelList);
    }

    //This method is use to initialize the RecyclerView in android studio
    private void initRecyclerView(List<RestaurantModel> restaurantModelList ) {
        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RestaurantListAdapter adapter = new RestaurantListAdapter(restaurantModelList, this);
        recyclerView.setAdapter(adapter);
    }

    //It is method to read the input steam
    private List<RestaurantModel> getRestaurantData() {
        InputStream is = getResources().openRawResource(R.raw.restaurent);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try{
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while(( n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0,n);
            }
        }catch (Exception e) {

        }

        //This enables to read the json file and to call the objects here
        String jsonStr = writer.toString();
        Gson gson = new Gson();
        RestaurantModel[] restaurantModels =  gson.fromJson(jsonStr, RestaurantModel[].class);
        List<RestaurantModel> restList = Arrays.asList(restaurantModels);

        return  restList;

    }

    //It will go the the RestaurantMenuActivity.class or the another activity
    @Override
    public void onItemClick(RestaurantModel restaurantModel) {
        Intent intent = new Intent(MainActivity.this, RestaurantMenuActivity.class);
        intent.putExtra("RestaurantModel", restaurantModel);
        startActivity(intent);

    }
}
