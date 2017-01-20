package co.tenton.admin.autoshkolla.Models;

import org.json.JSONObject;

/**
 * Created by herolindsopjani on 11/25/16.
 */

public class Sign {
    public int id;
    public String name;
    public String description;
    public Imager imager = null;
    public Subgroup subgroup = null;
    public int group_id;

    public static Sign createFromJSON(JSONObject r){
        Sign s = new Sign();

        s.name = r.optString("n");
        s.description = r.optString("d");

        if (!r.isNull("sgid")){
            Integer sgid = r.optInt("sgid");

            for (Subgroup sg : This.subgroups){
                if (sg.id == sgid){
                    s.subgroup = sg;
                    break;
                }
            }
        }

        if (!r.isNull("i")){
            s.imager = Imager.createFromString(r.optString("i"), false);
        }

        return s;
    }
}
