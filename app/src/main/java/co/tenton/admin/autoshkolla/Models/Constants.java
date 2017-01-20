package co.tenton.admin.autoshkolla.Models;

import android.graphics.Color;

/**
 * Created by herolindsopjani on 1/7/17.
 */

public class Constants {
    public static int successColor = Color.argb(255,86,179,102);
    public static int failedColor = Color.argb(255,178,39,45);

    public static int headerColor = Color.argb(255,34,40,49);

    public static int cardColor = Color.argb(255,244,245,246);
    public static int backgroudColor = Color.argb(255,239,239,244);

    public static Boolean DEBUGMODE = true;

    public static String clientId = "72WTF776B71O6ZJWXAQ5WLB9VYZ54ZUG03BTH4XW9XL5AKUOX0GDVZ57SFNZK1EG";
    public static String clientDebugId = "7BWQ4B2I2QQYI92MRLRW47QNXIHI3LCHF6ON6VDOL1G3INKB0MCV7E6FJ503UJL7";

    public static String getToken() {
        return DEBUGMODE ? clientDebugId : clientId;
    }
}
