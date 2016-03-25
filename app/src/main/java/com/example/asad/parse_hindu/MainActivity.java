package com.example.asad.parse_hindu;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String array[]=new String[200];
//    List<String> list=new ArrayList<>();
//    StringBuilder[] array=new StringBuilder[200];
     static int numberOfEntries=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="http://www.thehindu.com";
        new ParseHtml(this).execute(url);
    }
    public class ParseHtml extends AsyncTask<String,String,Void>
    {
        Context c;
        public ParseHtml(Context c)
        {
            this.c=c;
        }
        @Override
        protected Void doInBackground(String... params) {
            int i=0;
            String url=params[0];String str=null;
            try {
                Document doc = Jsoup.connect(url).get();
                Elements headlines = doc.getElementsByTag("h3");
                for (Element links : headlines) {
                    str=links.text();
                    array[i]=str;
//                    array.append(str);
//                    list.add(array[i]);
                    i++;
                }
                numberOfEntries=i;
                publishProgress(array);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        protected void onProgressUpdate(String[] values)
//protected void onProgressUpdate(ArrayList<String> values)

{
//          String arr[]=new String[200];
//            arr=values[0];

//    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
//    l.setAdapter(adapter);
            listView = (ListView)findViewById(R.id.listView);
            listView.setAdapter(new CustomAdapter(c,values));
        }
    }


}
