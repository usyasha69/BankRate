package com.example.pk.bankrate.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pk.bankrate.R;
import com.example.pk.bankrate.models.BankRateModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(BankRateModel.Organization organization, int position);
    }

    private Context context;
    private BankRateModel bankRateModel;
    private OnItemClickListener onItemClickListener;

    public RVAdapter(Context context, BankRateModel bankRateModel) {
        this.context = context;
        this.bankRateModel = bankRateModel;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View root = layoutInflater.inflate(R.layout.banks_rv_item, parent, false);

        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bank.setText(bankRateModel.organizations.get(position).title);
    }

    @Override
    public int getItemCount() {
        return bankRateModel.organizations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.brvi_bank)
        TextView bank;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(bankRateModel.organizations.get(getAdapterPosition())
                        , getAdapterPosition());
            } else {
                throw new RuntimeException("Exception!");
            }
        }
    }
}
