package sg.edu.rp.q.p10knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragRSS extends Fragment implements RssReader.RssCallback{

    Button btnChangeColour;
    ListView lvRss;
    List<RSS> rssList;
    ArrayList<String> titles;
    ArrayAdapter adapter;


    private RssReader rssReader = new RssReader(this);

    private String feed[] = {"https://www.gov.sg/rss/factuallyrss"};



    public FragRSS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myFragmentView = inflater.inflate(R.layout.fragment_rss, container, false);
        btnChangeColour = myFragmentView.findViewById(R.id.btnChangeColour);

        lvRss = myFragmentView.findViewById(R.id.lvRss);

        loadFeeds(feed);

        btnChangeColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomColour = new Random();
                myFragmentView.setBackgroundColor(Color.rgb(randomColour.nextInt(256), randomColour.nextInt(256), randomColour.nextInt(256)));
            }
        });

        return myFragmentView;


    }
    //load feeds
    private void loadFeeds(String[] urls) {
        rssReader.loadFeeds(urls);

    }

    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {
        // Feeds loaded, do whatever you want to do with them.
        Log.d("Feeds", rssList.size()+"");
        Log.d("Content", rssList.get(0).getChannel().getItems().get(0).getTitle());
        Log.d("Content1", rssList.get(0).getChannel().getItems().get(1).getTitle());
        titles = new ArrayList<String>();
        titles.add(rssList.get(0).getChannel().getItems().get(0).getTitle());
        titles.add(rssList.get(0).getChannel().getItems().get(1).getTitle());
        titles.add(rssList.get(0).getChannel().getItems().get(2).getTitle());
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, titles);
        lvRss.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {
        // Oops, library was unable to parse your feed url.
    }

}
