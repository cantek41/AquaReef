package com.cantekin.aquareef.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cantekin.aquareef.Data.Data;
import com.cantekin.aquareef.Data.DataSchedule;
import com.cantekin.aquareef.Data.MyPreference;
import com.cantekin.aquareef.Data.Schedule;
import com.cantekin.aquareef.R;
import com.cantekin.aquareef.network.SendDataToClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllColorActivity extends AppCompatActivity {

    private Schedule scheduleData;
    private LinearLayout mainLayout;
    private int paddingLeft = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_color);
        init();
    }

    private void init() {
        loadData();
        initView();
    }

    private void initView() {
        mainLayout = (LinearLayout) findViewById(R.id.allColor_MainLayout);
        for (DataSchedule item : scheduleData.getData()) {
            addItem(item);
        }

        TextView save = (TextView) findViewById(R.id.allColor_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDialog();
            }
        });
        TextView send = (TextView) findViewById(R.id.allColor_Send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
        TextView temp = (TextView) findViewById(R.id.allColor_temp);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTemp();
            }
        });
    }

    private void showTemp() {
        startActivity(new Intent(this, TemplateListActivity.class));
    }

    private void sendData() {
        SendDataToClient clinetAdapter = new SendDataToClient(this);
        Toast.makeText(this, R.string.gonderiliyor, Toast.LENGTH_LONG).show();
        for (DataSchedule item : scheduleData.getData()) {
            try {
                clinetAdapter.send(item.getByte());
                for (int i = 0; i < item.getByte().length; i++)
                    Log.d("Gonderim", "=" + item.getByte()[i]);

                Log.w("Gonderim", item.getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    private void saveDialog() {
        String[] quastion = new String[]{getString(R.string.kaydet), getString(R.string.farkli_kaydet), getString(R.string.default_yap)};
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
        builderSingle.setTitle(getString(R.string.secenekler));
        builderSingle.setItems(quastion, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int position) {
                if (position == 1) {
                    saveAs();
                }
            }
        });
        AlertDialog alert = builderSingle.create();
        alert.show();
    }

    private void saveAs() {
        final String[] m_Text = {""};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.lutfen_isim_girin));

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);

        builder.setView(input);


        builder.setPositiveButton(getString(R.string.tamam), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text[0] = input.getText().toString();

                String fav = MyPreference.getPreference(getApplicationContext()).getData(MyPreference.FAVORITESCHEDULE);
                Gson gson = new Gson();
                Type type = new TypeToken<List<Schedule>>() {
                }.getType();
                List<Schedule> favorites = new ArrayList<>();
                if (fav != null)
                    favorites = gson.fromJson(fav, type);
                scheduleData.setName(m_Text[0]);
                favorites.add(scheduleData);
                MyPreference.getPreference(getApplicationContext()).setData(MyPreference.FAVORITESCHEDULE, favorites);
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

    private void addItem(DataSchedule item) {
        LinearLayout mainRow = new LinearLayout(this);
        mainRow.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(this);
        title.setText(item.getName());
        title.setPadding(paddingLeft, 0, 0, 0);
        title.setTextColor(Color.WHITE);
        title.setBackgroundColor(Color.parseColor(item.getColor()));
        mainRow.addView(title);


        mainRow.addView(preperToItemRow(item.getStart(), R.mipmap.start));
        if (item.getCode() != 'h') {
            mainRow.addView(preperToItemRow(item.getUp(), R.mipmap.icon_up));
            mainRow.addView(preperToItemRow(item.getDown(), R.mipmap.icon_down));
        }
        mainRow.addView(preperToItemRow(item.getStop(), R.mipmap.icon_stop));
        mainRow.addView(preperToItemRow(item.getLevel() + "", R.mipmap.icon_level));
        if (item.getCode() == 'h') {
            if (item.getBlue() == 0)
                mainRow.addView(preperToItemRow(getString(R.string.royalBlue), R.mipmap.icon_blue));
            else
                mainRow.addView(preperToItemRow(getString(R.string.mavi), R.mipmap.icon_blue));

            if (item.isMoon())
                mainRow.addView(preperToItemRow(getString(R.string.acik), R.mipmap.icon_moon));
            else
                mainRow.addView(preperToItemRow(getString(R.string.kapali), R.mipmap.icon_moon));

        }
        mainLayout.addView(mainRow);
    }

    @NonNull
    private LinearLayout preperToItemRow(String item, int image) {
        LinearLayout rowStart = new LinearLayout(this);
        rowStart.setOrientation(LinearLayout.HORIZONTAL);
        rowStart.setPadding(paddingLeft, 0, 0, 0);
        rowStart.setGravity(Gravity.CENTER_VERTICAL);

        ImageView iconStart = new ImageView(this);
        iconStart.setLayoutParams(new ViewGroup.LayoutParams(80, 80));
        iconStart.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(this).load(image).into(iconStart);
        rowStart.addView(iconStart);

        TextView start = new TextView(this);
        start.setText(item);
        start.setPadding(paddingLeft, 0, 0, 0);
        rowStart.addView(start);
        return rowStart;
    }

    private void loadData() {
        String data = MyPreference.getPreference(this).getData(MyPreference.ACTIVESCHEDULE);
        Gson gson = new Gson();
        scheduleData = gson.fromJson(data, Schedule.class);
    }
}
