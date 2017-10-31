package com.project.ics.d1031fragmentbestpractice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.ics.d1031fragmentbestpractice.NewsContentActivity;
import com.project.ics.d1031fragmentbestpractice.R;
import com.project.ics.d1031fragmentbestpractice.entity.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/31.
 * Email:gowufang@gmail.com
 */

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        RecyclerView newsTitleRcycleView= (RecyclerView) view.findViewById(R.id.news_title_recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        newsTitleRcycleView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRcycleView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            News news = new News();
            news.setTitle("this is news title " + i);
            news.setContent(getRandomLengthContent("this is news content"+i+"\n"));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String content) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(content);
        }
        return builder.toString();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_fragment)!=null){
            isTwoPane=true;

        }else{
            isTwoPane = false;
        }
    }
    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        private List<News> mNewsList;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final  ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                /*
                * 观察一下onCreateViewHolder() 方法中注册的点击事件， 首先获取
                到了点击项的News 实例， 然后通过isTwoPane 变量来判断当前是单页
                还是双页模式， 如果是单页模式， 就启动一个新的活动去显示新闻内
                容， 如果是双页模式， 就更新新闻内容碎片里的数据
                */
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPane){
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(),news.getContent());
                    }else {
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        public NewsAdapter(List<News> newsList){
            mNewsList=newsList;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleText;
            public ViewHolder(View view){
                super(view);
                newsTitleText = (TextView) view.findViewById(R.id.news_title);

            }
        }

    }
}
