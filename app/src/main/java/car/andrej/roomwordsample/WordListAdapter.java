package car.andrej.roomwordsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {


    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }


    private final LayoutInflater mInflater;
    private List<Word> mWords; // Cached copy of words

    public WordListAdapter(Context context) {
        mInflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemview=mInflater.inflate(R.layout.recyclerview_item,parent,false);

        return new WordViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int i) {
        if (mWords != null) {
            Word current = mWords.get(i);
            holder.wordItemView.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }

    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }


}
