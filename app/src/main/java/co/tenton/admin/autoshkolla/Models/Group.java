package co.tenton.admin.autoshkolla.Models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by herolindsopjani on 11/25/16.
 */

public class Group {
    public int id;
    public String name;
    public String description;
    public Imager imager = null;
    public List<Sign> signs = new ArrayList<Sign>();

    public static Group createFromJSON(JSONObject r) {
        Group g = new Group();

        g.name = r.optString("n");
        g.description = r.optString("d");
        if (!r.isNull("i")){
            g.imager = Imager.createFromString(r.optString("i"), false);
        }

        if (!r.isNull("ss")){
            JSONArray ss = r.optJSONArray("ss");
            for(int i=0; i<ss.length(); i++){
                JSONObject jS = ss.optJSONObject(i);
                Sign s = Sign.createFromJSON(jS);
                g.signs.add(s);
            }
        }

        return g;
    }

    public List<Subgroup> subgroups(){
        List<Subgroup> ss = new ArrayList<>();

        for (Sign s: signs) {
            if (s.subgroup != null){
                Subgroup sg_created = hasSubGroup(s.subgroup, ss);
                if (sg_created != null){
                    sg_created.AddSign(s);
                }else {
                    Subgroup sg_new = new Subgroup();
                    sg_new.id = s.subgroup.id;
                    sg_new.name = s.subgroup.name;
                    sg_new.description = s.subgroup.description;
                    sg_new.AddSign(s);
                    ss.add(sg_new);
                }
            }
        }
        
        return ss;
    }
    public Subgroup hasSubGroup(Subgroup element, List<Subgroup> elements){
        for(Subgroup s: elements){
            if (s.id == element.id){
                return s;
            }
        }
        return null;
    }
//    private func hasGroup(element: Subgroup, elements: [Subgroup])->Subgroup? {
//        for e in elements {
//            if e.id == element.id {
//                return e
//            }
//        }
//
//        return nil
//    }
//    func subgroups() -> [Subgroup]? {
//        if let ss = signs  {
//            var subgroups = [Subgroup]()
//
//            for s in ss {
//                if let subgroup = s.subgroup {
//                    if let sg_created = hasGroup(element: subgroup, elements: subgroups){
//                        sg_created.addSign(sign: s)
//                    }else{
//                        //create subgroup
//                        let sg_new = Subgroup()
//                        sg_new.id = subgroup.id
//                        sg_new.description = subgroup.description
//                        sg_new.name = subgroup.name
//                        subgroups.append(sg_new)
//                        sg_new.addSign(sign: s)
//                    }
//                }
//            }
//
//            return subgroups
//        }
//        return nil
//    }

}
