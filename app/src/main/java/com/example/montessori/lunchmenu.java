package com.example.montessori;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class lunchmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunchmenu);

        TableView tableView=findViewById(R.id.table_data_view);
        String[] headers={"DAY","MAIN COURSE","FRUITS","VEGETABLES","TREATS","DRINKS"};
        String[][] data={{"Monday","Egg Salad Sandwich","Apple","Carrots","Jello","Milk"},{"Tuesday","Pancakes","Oranges","Broccolli","Cookies","Lemonade"},{"Wednesday","Curdrice","Strawberries","Cucumbers","Brownie"}};

        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,headers));
        tableView.setDataAdapter(new SimpleTableDataAdapter(this,data));

    }
}