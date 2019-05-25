package by.yarik.credit.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import by.yarik.credit.R;
import by.yarik.credit.presentation.viewmodel.CreditViewModel;

public class CreditListAdapter extends RecyclerView.Adapter<CreditListAdapter.CreditListViewHolder> {

    private List<CreditViewModel> models;

    public CreditListAdapter(List<CreditViewModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public CreditListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_credit, viewGroup, false);
        return new CreditListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditListViewHolder holder, int position) {
        CreditViewModel model = models.get(position);

        holder.title.setText(model.getGroupName());
        holder.maxAmount.setText(model.getMaxSize());
        holder.percent.setText(model.getPercents());
        holder.term.setText(model.getTerm());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class CreditListViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView maxAmount;
        TextView term;
        TextView percent;

        public CreditListViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_credit_title);
            maxAmount = itemView.findViewById(R.id.tv_credit_max_amount);
            term = itemView.findViewById(R.id.tv_credit_term);
            percent = itemView.findViewById(R.id.tv_credit_percent);
        }
    }
}
