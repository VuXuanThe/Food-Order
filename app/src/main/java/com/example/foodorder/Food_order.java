package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Food_order extends AppCompatActivity {
    ListView lvFood;
    Button btnOrder;
    food food1, food2, food3, food4, food5, food6;
    static List<food> foodList;
    Adapter_Food adapterFood;
    TextView tvTotalMoney, tvTotalFood;
    int money = 0, numFood = 0;
    View viewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_food_order);
        inIt();
        clickItemFood();
        clickCart();
    }

    private void inIt(){
        lvFood          = findViewById(R.id.lvFood);
        btnOrder        = findViewById(R.id.btnOrder);
        tvTotalMoney    = findViewById(R.id.tvTotalMoney);
        tvTotalFood     = findViewById(R.id.tvTotalFood);
        viewCart        = findViewById(R.id.viewCart);

        foodList = new ArrayList<>();

        food1 = new food("Pizza Panda", 10, 0);
        food2 = new food("KFC Super", 10, 0);
        food3 = new food("Bread Eggs", 10, 0);
        food4 = new food("Coca Cola", 10, 0);
        food5 = new food("Chicken super", 10, 0);
        food6 = new food("Cup Cake", 10, 0);

        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        foodList.add(food6);

        adapterFood = new Adapter_Food(foodList);
        lvFood.setAdapter(adapterFood);
    }

    private void clickItemFood(){
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                money += foodList.get(position).getPrice();
                foodList.get(position).setAmount(foodList.get(position).getAmount() + 1);
                numFood++; tvTotalFood.setText(String.valueOf(numFood));
                tvTotalMoney.setText(String.valueOf(money) + "$");
            }
        });
    }

    private  void clickCart(){
        viewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ShowFoodOrder.class);
                startActivity(intent);
            }
        });
    }
}
