//swucafe_2020111324_김한선_2022-12-15
package com.android.swucafe;

import android.view.View;

public interface OnNoteItemClickListener {
    public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position);

}
