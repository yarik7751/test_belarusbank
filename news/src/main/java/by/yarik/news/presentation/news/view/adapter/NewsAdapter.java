package by.yarik.news.presentation.news.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import by.yarik.news.R;
import by.yarik.news.presentation.news.model.NewsViewModel;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private static final int EMPTY_LIST_SIZE = 0;

    private List<NewsViewModel> list;

    public NewsAdapter(List<NewsViewModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NewsViewModel model = list.get(position);
        viewHolder.newsTitle.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : EMPTY_LIST_SIZE;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView newsTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.tv_news_title);
        }
    }
}
