package com.cantekin.aquareef.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cantekin.aquareef.Data.Data;
import com.cantekin.aquareef.Data.DefaultData;
import com.cantekin.aquareef.Data.MyPreference;
import com.cantekin.aquareef.Data.Schedule;
import com.cantekin.aquareef.R;
import com.cantekin.aquareef.ui.Fragment.FavoritesListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * templatlerin listesi
 * TODO: burası fragment yapılabiniri
 */

public class TemplateListActivity extends _baseActivity {

    private List<Schedule> favorites;
    //private Map<String, Data> favorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_list);
    }

    @Override
    public void initActivity() {
        List<Schedule> defaultFavorites = new DefaultData().getScheduleFavorites();
        setList(defaultFavorites, R.id.fvrDefaultlists);

        String fav = MyPreference.getPreference(getApplicationContext()).getData(MyPreference.FAVORITESCHEDULE);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Schedule>>() {
        }.getType();
        favorites = new ArrayList<>();
        if (fav != null)
            favorites = gson.fromJson(fav, type);
        // setList(favorites, R.id.fvrFavoritLists);
        setListDeleted(favorites, R.id.fvrFavoritLists);
        getSupportActionBar().setTitle(getString(R.string.templates));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void setList(final List<Schedule> favoriList, int listView) {
        List<String> defaultList = new ArrayList<>();
        for (Schedule entry : favoriList) {
            defaultList.add(entry.getName());
        }
        ListView defaultListView = (ListView) findViewById(listView);
        ArrayAdapter<String> dfltAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, defaultList);
        defaultListView.setAdapter(dfltAdapter);
        defaultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) parent.getItemAtPosition(position);
                questionsDialog(value);
            }
        });
    }

    private void setListDeleted(final List<Schedule> favoriList, int listView) {
        List<String> defaultList = new ArrayList<>();
        for (Schedule entry : favoriList) {
            defaultList.add(entry.getName());
        }
        ListView defaultListView = (ListView) findViewById(listView);
        TemplateListAdapter dfltAdapter = new TemplateListAdapter(getApplicationContext(), R.layout.row_register_device, defaultList, this);
        defaultListView.setAdapter(dfltAdapter);
        defaultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) parent.getItemAtPosition(position);
                questionsDialog(value);
                //sendFavorites(favoriList.get(value).stringToSimpleArrayBufferFavorite());
            }
        });
    }

    private void questionsDialog(final String value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.emin_misiniz));
        Schedule scheduleData = null;
        for (Schedule item : favorites)
            if (item.getName().equals(value))
                scheduleData = item;
        if (scheduleData == null)
            for (Schedule item : new DefaultData().getScheduleFavorites())
                if (item.getName().equals(value))
                    scheduleData = item;
        Log.d("questionsDialog", value);
        final Schedule finalScheduleData = scheduleData;
        builder.setPositiveButton(getString(R.string.tamam), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MyPreference.getPreference(getApplicationContext()).setData(MyPreference.ACTIVESCHEDULE, finalScheduleData);
                finish();

            }
        });
        builder.setNegativeButton(getString(R.string.iptal), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    @Override
    public void deleteItem(String item) {
        Log.e("deleteItem", item);
        for (Schedule entry : favorites) {
            if (entry.getName().equals(item)) {
                favorites.remove(entry);
                break;
            }
        }
        MyPreference.getPreference(getApplicationContext()).setData(MyPreference.FAVORITESCHEDULE, favorites);
        setListDeleted(favorites, R.id.fvrFavoritLists);
    }
}
