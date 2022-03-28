package fr.antony_garcia.fuelfinder;

import android.view.View;

import java.util.List;

public interface RecyclerViewItemClickListener<T> {
        public void onItemClick(T item);
}
