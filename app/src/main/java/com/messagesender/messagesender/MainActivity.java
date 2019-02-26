package com.messagesender.messagesender;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<DataModel> {
    private RecyclerView list;
    private TextView title;
    private TextView url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRecipe();
        list = findViewById(R.id.list);
        title = findViewById(R.id.title);
        url = findViewById(R.id.url);
    }

    private void getRecipe(){
        Call<DataModel> call = Service.getApi().getRecipe();
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel dataModel = response.body();

                title.setText(dataModel.getTitle());
                url.setText(dataModel.getHref());
                list.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                RecipeAdapter adapter = new RecipeAdapter();
                adapter.setList(dataModel.getResults());
                list.setAdapter(adapter);
                list.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                t.getMessage();
            }
        });
    }


    @Override
    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
        response.body();
    }

    @Override
    public void onFailure(Call<DataModel> call, Throwable t) {

    }
}
