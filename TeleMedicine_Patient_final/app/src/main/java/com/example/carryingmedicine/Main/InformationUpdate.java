package com.example.carryingmedicine.Main;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import static com.example.carryingmedicine.Main.MainActivity.userID;

public class InformationUpdate extends StringRequest {
    //서버 URL 설정(Php파일 연동)
    final static private String URL ="http://ghksdh587.dothome.co.kr/Information_update.php";
    private Map<String, String> map;

    public InformationUpdate(int userHeight, int userWeight, String userPast_history, String userFamily_history,
                             String userSurgical_hisory, String userDrug, String userDrink, String userSmoke,
                             Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();

        map.put("userHeight",userHeight+"");
        map.put("userWeight",userWeight+"");
        map.put("userPast_history",userPast_history);
        map.put("userFamily_history",userFamily_history);
        map.put("userSurgical_hisory",userSurgical_hisory);
        map.put("userDrug",userDrug);
        map.put("userDrink",userDrink);
        map.put("userSmoke",userSmoke);
        map.put("userID",userID);
    }

    @Override
    protected Map getParams() throws AuthFailureError {
        return map;
    }
}