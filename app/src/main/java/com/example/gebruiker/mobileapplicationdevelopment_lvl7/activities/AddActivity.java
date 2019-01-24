package com.example.gebruiker.mobileapplicationdevelopment_lvl7.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.gebruiker.mobileapplicationdevelopment_lvl7.R;
import com.example.gebruiker.mobileapplicationdevelopment_lvl7.models.BucketListItem;
import com.example.gebruiker.mobileapplicationdevelopment_lvl7.viewmodels.BucketListItemViewModel;

public class AddActivity extends AppCompatActivity {
    private BucketListItemViewModel bucketListItemViewModel;
    private EditText itemName;
    private EditText itemDescription;
    private CheckBox itemCheckBox;
    private FloatingActionButton addBtn;
    private BucketListItem item;
    private boolean add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        bucketListItemViewModel = ViewModelProviders.of(this).get(BucketListItemViewModel.class);
        Intent intent = getIntent();

        itemName = findViewById(R.id.itemName);
        itemDescription = findViewById(R.id.itemDescription);
        itemCheckBox = findViewById(R.id.itemCheckBox);
        addBtn = findViewById(R.id.addBtn);


        if (intent.getSerializableExtra("Item") != null){
            item = (BucketListItem) intent.getSerializableExtra("Item");
            add = false;
            itemName.setText(item.getName());
            itemDescription.setText(item.getDescription());
            itemCheckBox.setChecked(item.getChecked());
        } else {
            add = true;

        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(add){
                    bucketListItemViewModel.insert(new BucketListItem(
                            itemName.getText().toString(),
                            itemDescription.getText().toString(),
                            itemCheckBox.isChecked()
                    ));
                    finish();
                }else{
                    item.setName(itemName.getText().toString());
                    item.setDescription(itemDescription.getText().toString());
                    item.setChecked(itemCheckBox.isChecked());
                    bucketListItemViewModel.update(item);
                    finish();
                }
            }
        });
    }
}

