package com.example.carryingmedicine.Main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.carryingmedicine.AppRTC.ConnectActivity;
import com.example.carryingmedicine.Chat.ChatMainActivity;
import com.example.carryingmedicine.Clinic.ClinicData;
import com.example.carryingmedicine.Clinic.Clinic_List_Main;
import com.example.carryingmedicine.Clinic.ReservationRequest;

import com.example.carryingmedicine.News.Item;
import com.example.carryingmedicine.News.MyAdapter;
import com.example.carryingmedicine.R;
import com.example.carryingmedicine.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.annotation.Nullable;

import static com.example.carryingmedicine.login.LoginActivity.doctorName;

public class FragHome extends Fragment{
    private View view;
    private static String username;
    private static String userid;
    private TextView text_name;

    public static String userID,doctorID,doctorName,now_disease,reservation_date,reservation_number,reservation_time,userName;
    ArrayList<ClinicData> mArrayList=new ArrayList<ClinicData>();
    Response.Listener<String> responseListener;
    //???????????????
    RecyclerView recyclerView;
    ArrayList<Item> items= new ArrayList<>();
    MyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_home,container,false);
// ?????? ???????????????
        recyclerView=view.findViewById(R.id.recycler);
        adapter=new MyAdapter(items,getContext());
        recyclerView.setAdapter(adapter);
        //?????????????????? ??????????????? ??????
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        //????????? ????????? ????????????
        readRss();
// ????????? ?????? ??????
        text_name = view.findViewById(R.id.text_name);
        text_name.setText("???????????????  "+ LoginActivity.doctorName + "???");
///???????????? ?????? ??? ??????
        StartClinic();
        return view;
    }
//**********************************?????? ??????********************************************************/
    public void StartClinic(){
        mArrayList.clear();
        Button doctor_info_but = view.findViewById(R.id.doctor_info_but); // ???????????? ??????
        doctor_info_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("test");
                            mArrayList.clear();

                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject item = jsonArray.getJSONObject(i);
                                reservation_number = item.getString("reservation_number");
                                userName = item.getString("userName");
                                doctorName = item.getString("doctorName");
                                userID = item.getString("userID");
                                doctorID = item.getString("doctorID");
                                reservation_date = item.getString("reservation_date");
                                reservation_time = item.getString("reservation_time");
                                now_disease = item.getString("now_disease");
                                mArrayList.add(new ClinicData(reservation_number,userName,doctorName,userID,doctorID,reservation_date,reservation_time,now_disease));
                            }

                            Intent intent1 = new Intent(getActivity(), Clinic_List_Main.class);
                            intent1.putExtra("userID", userID);                           // ????????????
                            intent1.putExtra("userName", userName);
                            intent1.putExtra("doctorName",doctorName);
                            intent1.putExtra("doctor_id",doctorID);
                            intent1.putParcelableArrayListExtra("ArrayList", mArrayList); //?????????????????? ????????? ?????? ??????
                            startActivity(intent1);
                        } catch (
                                Exception e) {
                            e.printStackTrace();
                        }
                    }

                };
                ReservationRequest reservationRequest = new ReservationRequest(responseListener);
                RequestQueue queue= Volley.newRequestQueue(getActivity());
                queue.add(reservationRequest);
            }
        });
    }

    //???????????????###############################################################################################
    void readRss(){

        try {
            URL url = new URL("http://rss.hankyung.com/new/news_main.xml");

            //????????????????????? ????????? ???????????? : ????????? ????????? ????????? ????????? ???????????????.
            //Network????????? ????????? ????????? Thread??? ??? ??? ??????.
            //????????? Thread ?????? ??????
            RssFeedTask task= new RssFeedTask();
            task.execute(url); //doInBackground()???????????? ??????[thread??? start()??? ?????? ??????]
        } catch (MalformedURLException e) { e.printStackTrace();}

    }// readRss Method ..

    //?????? ?????????
    class RssFeedTask extends AsyncTask<URL, Void, String> {

        //Thread??? run()???????????? ?????? ??????
        @Override
        protected String doInBackground(URL... urls) { //...??? ???????????? ?????? ??????, ?????? task.execute(url, url2, url3); ????????? urls[3]??? ?????????.
            //???????????? URL ??????
            URL url= urls[0];

            //?????????(URL)?????? ???????????????(Stream) ?????????..
            try {
                InputStream is= url.openStream();

                //????????? xml??? ??????(??????)????????? ?????? ??????
                XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                XmlPullParser xpp= factory.newPullParser();

                //utf-8??? ????????? ???????????? ?????? ????????? ??????
                xpp.setInput(is, "utf-8");
                int eventType= xpp.getEventType();

                Item item= null;
                String tagName= null;

                while (eventType != XmlPullParser.END_DOCUMENT){
                    switch (eventType){
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            tagName=xpp.getName();

                            if(tagName.equals("item")){
                                item= new Item();
                            }else if(tagName.equals("title")){
                                xpp.next();
                                if(item!=null) item.setTitle(xpp.getText());
                            }else if(tagName.equals("link")){
                                xpp.next();
                                if(item!=null) item.setLink(xpp.getText());
                            }else if(tagName.equals("description")){
                                xpp.next();
                                if(item!=null) item.setDesc(xpp.getText());
                            }else if(tagName.equals("image")){
                                xpp.next();
                                if(item!=null) item.setImgUrl(xpp.getText());
                            }else if(tagName.equals("pubDate")){
                                xpp.next();
                                if(item!=null) item.setDate(xpp.getText());
                            }
                            break;
                        case XmlPullParser.TEXT:
                            break;
                        case XmlPullParser.END_TAG:
                            tagName=xpp.getName();
                            if(tagName.equals("item")){
                                //????????? ?????? ????????? ????????? ???????????? ??????
                                items.add(item);
                                item=null;

                                //?????????????????? ??????????????? ????????????
                                //?????????????????? ?????? ??????
                                publishProgress();

                            }
                            break;
                    }
                    eventType= xpp.next();
                }//while

                //?????? ????????? ???????????????!!
                //???????????? Toast??? ????????????, ??? ?????? ????????????
                //UI????????? ??????! ????????? runOnUiThread()??? ???????????????.
                //??? UI????????? ?????? ????????? ????????????
                //????????? ???????????? ????????? ??????

            } catch (IOException e) {e.printStackTrace();} catch (XmlPullParserException e) {e.printStackTrace();}

            return "????????????"; // ?????? ?????? onPostExecute(String s) s??? ????????????.
        }//doIBackground()
        //doInbackground ??????????????? ??????????????????????????? ???????????? ???????????? ???????????? ?????????
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            //??????????????? ????????? ??????????????????
            adapter.notifyItemInserted(items.size());
        }

        //doInBackground???????????? ????????? ???
        //UI????????? ?????? ?????? ???????????? ?????????
        //runOnUiThread()??? ????????? ??????
        @Override
        protected void onPostExecute(String s) { //?????? ?????? s??? ???????????? ?????? doIBackground()??? return ?????????.
            super.onPostExecute(s);

            //????????????????????? ???????????? ???????????? ?????? ??????????????? ???????????? ?????????????????? ??????
            //adapter.notifyDataSetChanged();

            //??? ????????? ???????????? UI?????? ?????? ??????
            Toast.makeText(getActivity(), s+":"+items.size(), Toast.LENGTH_SHORT).show();
        }
    }//RssFeedTask class

}
