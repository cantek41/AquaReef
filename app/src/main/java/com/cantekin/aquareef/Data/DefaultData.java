package com.cantekin.aquareef.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cantekin on 19.7.2017.
 */

public class DefaultData {

    public static final String colorRed = "Red";
    public static final String colorGreen = "Green";
    public static final String colorRoyal = "Royal Blue";
    public static final String colorBlue = "Blue";
    public static final String colorWhite = "White";
    public static final String colorDWhite = "D.White";
    public static final String colorUV = "UV";
    public static final String colorMoon = "Moon";

    public static final String colorRedC = "#ef473a";
    public static final String colorGreenC = "#33cd5f";
    public static final String colorRoyalC = "#11c1f3";
    public static final String colorBlueC = "#387ef5";
    public static final String colorWhiteC = "#b2b2b2";
    public static final String colorDWhiteC = "#ffc900";
    public static final String colorUVC = "#886aea";
    public static final String colorMoonC = "#040404";

    public static final char codeRedC = 'a';
    public static final char codeGreenC = 'b';
    public static final char codeRoyalC = 'c';
    public static final char codeBlueC = 'd';
    public static final char codeWhiteC = 'e';
    public static final char codeDWhiteC = 'f';
    public static final char codeUVC = 'g';
    public static final char codeMoonC = 'h';

    public DefaultData() {
    }

    public Map<String, Data> getFavorites() {
        Map<String, Data> favorites = new HashMap<>();
        Data blue = new Data();
        blue.setBlue(100);
        favorites.put("Blue", blue);

        Data allBlue = new Data();
        allBlue.setBlue(100);
        allBlue.setRoyalBlue(100);
        favorites.put("All Blues", allBlue);

        Data wihteRoyal = new Data();
        wihteRoyal.setBlue(100);
        wihteRoyal.setWhite(100);
        favorites.put("White & Royal", wihteRoyal);


        Data White = new Data();
        White.setWhite(100);
        favorites.put("White", White);


        Data WhiteRed = new Data();
        WhiteRed.setRed(100);
        WhiteRed.setWhite(100);
        favorites.put("White & Red", WhiteRed);


        Data Red = new Data();
        Red.setRed(100);
        favorites.put("Red", Red);

        return favorites;
    }

    public static String getNameForKey(char key) {
        String result = null;
        switch (key) {
            case 'a':
                result = colorRed;
                break;
            case 'b':
                result = colorGreen;
                break;
            case 'c':
                result = colorRoyal;
                break;
            case 'd':
                result = colorBlue;
                break;
            case 'e':
                result = colorWhite;
                break;
            case 'f':
                result = colorDWhite;
                break;
            case 'g':
                result = colorUV;
                break;
            case 'h':
                result = colorMoon;
                break;
        }
        return result;
    }

    public static String getColorForKey(char key) {
        String result = null;
        switch (key) {
            case 'a':
                result = colorRedC;
                break;
            case 'b':
                result = colorGreenC;
                break;
            case 'c':
                result = colorRoyalC;
                break;
            case 'd':
                result = colorBlueC;
                break;
            case 'e':
                result = colorWhiteC;
                break;
            case 'f':
                result = colorDWhiteC;
                break;
            case 'g':
                result = colorUVC;
                break;
            case 'h':
                result = colorMoonC;
                break;
            default:
                result = colorBlue;
                break;
        }
        return result;
    }

    public Schedule getSchedule() {
        Schedule sch = new Schedule();
        sch.setName("Default");
        List<DataSchedule> result = new ArrayList<>();
        DataSchedule red = new DataSchedule(colorRed, 'a', colorRedC, "11:00", "12:00", "17:00", "18:00", 50);
        DataSchedule green = new DataSchedule(colorGreen, 'b', colorGreenC, "11:00", "12:00", "17:00", "18:00", 40);
        DataSchedule rBlue = new DataSchedule(colorRoyal, 'c', colorRoyalC, "09:00", "10:30", "20:30", "22:00", 100);
        DataSchedule blue = new DataSchedule(colorBlue, 'd', colorBlueC, "09:30", "11:00", "20:00", "21:30", 100);
        DataSchedule white = new DataSchedule(colorWhite, 'e', colorWhiteC, "10:00", "11:00", "17:00", "19:00", 75);
        DataSchedule dWhite = new DataSchedule(colorDWhite, 'f', colorDWhiteC, "10:30", "11:30", "17:00", "19:00", 60);
        DataSchedule uv = new DataSchedule(colorUV, 'g', colorUVC, "10:30", "11:30", "18:00", "20:00", 80);
        DataSchedule moon = new DataSchedule(colorMoon, 'h', colorMoonC, "01:00", "00:00", "00:00", "07:00", 0);

        result.add(red);
        result.add(green);
        result.add(rBlue);
        result.add(blue);
        result.add(white);
        result.add(dWhite);
        result.add(uv);
        result.add(moon);
        sch.setData(result);
        return sch;
    }

    public List<Schedule> getScheduleFavorites() {
        List<Schedule> resultList = new ArrayList<>();
        List<DataSchedule> item = new ArrayList<>();
        DataSchedule red = new DataSchedule("Red", 'a', "#ef473a", "10:00", "12:00", "17:00", "18:00", 20);
        DataSchedule green = new DataSchedule("Green", 'b', "#33cd5f", "10:30", "12:00", "17:00", "18:00", 20);
        DataSchedule rBlue = new DataSchedule("Royal Blue", 'c', "#11c1f3", "09:30", "10:30", "20:00", "21:30", 100);
        DataSchedule blue = new DataSchedule("Blue", 'd', "#387ef5", "09:30", "10:30", "20:30", "22:00", 100);
        DataSchedule white = new DataSchedule("White", 'e', "#b2b2b2", "10:30", "12:00", "17:00", "19:30", 70);
        DataSchedule dWhite = new DataSchedule("D.White", 'f', "#ffc900", "11:00", "12:00", "17:00", "18:30", 40);
        DataSchedule uv = new DataSchedule("UV", 'g', "#886aea", "10:30", "11:30", "18:30", "20:00", 80);
        DataSchedule moon = new DataSchedule("Moon", 'h', "#040404", "01:00", "00:00", "00:00", "07:00", 5);
        item.add(red);
        item.add(green);
        item.add(rBlue);
        item.add(blue);
        item.add(white);
        item.add(dWhite);
        item.add(uv);
        item.add(moon);
        Schedule schedule = new Schedule();
        schedule.setName("SPS Sert Mercan");
        schedule.setData(item);
        resultList.add(schedule);

        //Marine
        item = new ArrayList<>();
        red = new DataSchedule("Red", 'a', "#ef473a", "11:00", "12:00", "17:00", "18:00", 5);
        green = new DataSchedule("Green", 'b', "#33cd5f", "11:00", "12:00", "17:00", "18:00", 5);
        rBlue = new DataSchedule("Royal Blue", 'c', "#11c1f3", "09:30", "10:30", "20:00", "21:30", 100);
        blue = new DataSchedule("Blue", 'd', "#387ef5", "09:30", "10:30", "20:30", "22:00", 100);
        white = new DataSchedule("White", 'e', "#b2b2b2", "10:30", "12:00", "17:00", "18:30", 40);
        dWhite = new DataSchedule("D.White", 'f', "#ffc900", "11:00", "12:00", "16:00", "17:30", 20);
        uv = new DataSchedule("UV", 'g', "#886aea", "10:30", "11:30", "18:30", "20:00", 40);
        moon = new DataSchedule("Moon", 'h', "#040404", "01:00", "00:00", "00:00", "07:00", 5);
        item.add(red);
        item.add(green);
        item.add(rBlue);
        item.add(blue);
        item.add(white);
        item.add(dWhite);
        item.add(uv);
        item.add(moon);
        Schedule schedule1 = new Schedule();
        schedule1.setName("Marine");
        schedule1.setData(item);
        resultList.add(schedule1);

        //LPS+SPS Mix
        item = new ArrayList<>();
        red = new DataSchedule("Red", 'a', "#ef473a", "10:30", "12:00", "17:00", "18:00", 10);
        green = new DataSchedule("Green", 'b', "#33cd5f", "11:00", "12:00", "17:00", "18:00", 10);
        rBlue = new DataSchedule("Royal Blue", 'c', "#11c1f3", "09:30", "10:30", "20:00", "21:30", 100);
        blue = new DataSchedule("Blue", 'd', "#387ef5", "09:30", "10:30", "20:30", "22:00", 100);
        white = new DataSchedule("White", 'e', "#b2b2b2", "10:30", "12:00", "17:00", "18:30", 50);
        dWhite = new DataSchedule("D.White", 'f', "#ffc900", "11:00", "12:00", "16:00", "17:30", 30);
        uv = new DataSchedule("UV", 'g', "#886aea", "10:30", "11:30", "18:30", "20:00", 80);
        moon = new DataSchedule("Moon", 'h', "#040404", "01:00", "00:00", "00:00", "07:00", 5);
        item.add(red);
        item.add(green);
        item.add(rBlue);
        item.add(blue);
        item.add(white);
        item.add(dWhite);
        item.add(uv);
        item.add(moon);

        Schedule schedule2 = new Schedule();
        schedule2.setName("LPS+SPS Mix");
        schedule2.setData(item);
        resultList.add(schedule2);

        //"LPS Soft Mercan
        item = new ArrayList<>();
        red = new DataSchedule("Red", 'a', "#ef473a", "11:00", "12:00", "17:00", "18:00", 10);
        green = new DataSchedule("Green", 'b', "#33cd5f", "11:00", "12:00", "17:00", "18:00", 10);
        rBlue = new DataSchedule("Royal Blue", 'c', "#11c1f3", "09:30", "10:30", "20:00", "21:30",100);
        blue = new DataSchedule("Blue", 'd', "#387ef5", "09:30", "10:30", "20:30", "22:00",100);
        white = new DataSchedule("White", 'e', "#b2b2b2", "10:30", "12:00", "17:00", "18:30", 50);
        dWhite = new DataSchedule("D.White", 'f', "#ffc900", "11:00", "12:00", "16:00", "17:30", 30);
        uv = new DataSchedule("UV", 'g', "#886aea", "10:30", "11:30", "18:30", "20:00", 50);
        moon = new DataSchedule("Moon", 'h', "#040404", "01:00", "00:00", "00:00", "07:00", 5);
        item.add(red);
        item.add(green);
        item.add(rBlue);
        item.add(blue);
        item.add(white);
        item.add(dWhite);
        item.add(uv);
        item.add(moon);
        Schedule schedule3 = new Schedule();
        schedule3.setName("LPS Soft Mercan");
        schedule3.setData(item);
        resultList.add(schedule3);



        //"AquaReef Bitkili
        item = new ArrayList<>();
        red = new DataSchedule("Red", 'a', "#ef473a", "15:00", "16:00", "21:00", "22:00", 10);
        green = new DataSchedule("Green", 'b', "#33cd5f", "14:00", "15:00", "19:00", "20:00", 10);
        rBlue = new DataSchedule("Royal Blue", 'c', "#11c1f3", "14:00", "14:30", "22:30", "23:30",60);
        blue = new DataSchedule("Blue", 'd', "#387ef5", "14:00", "14:30", "21:30", "23:30",60);
        white = new DataSchedule("White", 'e', "#b2b2b2", "15:00", "16:00", "20:00", "22:00", 80);
        dWhite = new DataSchedule("D.White", 'f', "#ffc900", "15:00", "16:00", "19:00", "21:30", 40);
        uv = new DataSchedule("UV", 'g', "#886aea", "13:00", "14:00", "19:00", "21:30", 70);
        moon = new DataSchedule("Moon", 'h', "#040404", "01:00", "00:00", "00:00", "07:00", 5);
        item.add(red);
        item.add(green);
        item.add(rBlue);
        item.add(blue);
        item.add(white);
        item.add(dWhite);
        item.add(uv);
        item.add(moon);
        Schedule schedule4 = new Schedule();
        schedule4.setName("AquaReef Bitkili");
        schedule4.setData(item);
        resultList.add(schedule4);



        return resultList;
    }
}