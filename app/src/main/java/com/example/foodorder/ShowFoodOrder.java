package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowFoodOrder extends AppCompatActivity {
    ListView lvFoodOrder;
    ImageButton btnBack;
    List<food> foodOrder;
    Adapter_Food_Order foodOk;
    TextView tvTotalMoneyOrder;
    int totalMoney = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_food_order);
        inIt();
        clickButtonback();
        showFood();
    }

    private void showFood() {
        foodOrder = new ArrayList<>();
        for(int i = 0; i < Food_order.foodList.size(); i++){
            if(Food_order.foodList.get(i).getAmount() > 0){
                foodOrder.add(Food_order.foodList.get(i));
                totalMoney += Food_order.foodList.get(i).getPrice() * Food_order.foodList.get(i).getAmount();
            }
        }
        tvTotalMoneyOrder.setText(String.valueOf(totalMoney) + "$");
        foodOk = new Adapter_Food_Order(foodOrder);
        lvFoodOrder.setAdapter(foodOk);
    }

    private void clickButtonback() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void inIt(){
        btnBack = findViewById(R.id.btnBack);
        lvFoodOrder = findViewById(R.id.lvFoodOrder);
        tvTotalMoneyOrder = findViewById(R.id.tvTotalMoneyOrder);
    }
}
