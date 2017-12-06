package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.CharacterDto;
import com.vnspectre.marvelcharacters.data.network.marvelapi.model.MarvelImage;
import com.vnspectre.marvelcharacters.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Spectre on 12/4/17.
 */

public class CharactersAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = CharactersAdapter.class.getName();

    public static final int VIEW_TYPE_LIST = 1;
    public static final int VIEW_TYPE_LOADING = 2;

    private Callback mCallback;
    private List<CharacterDto> mCharacterList;

    private int mViewType;

    public CharactersAdapter(List<CharacterDto> mCharacterList) {
        this.mCharacterList = mCharacterList;
        mViewType = VIEW_TYPE_LIST;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public int getItemViewType(int position) {
        return mCharacterList.get(position) == null ? VIEW_TYPE_LOADING : mViewType;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_LOADING) {
            return new ProgressBarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress_bar, parent, false));
        }
        return new CharacterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_landscape, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_LOADING) {
            return;
        }
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public boolean removeLoadingView() {
        if (mCharacterList.size() > 1) {
            int loadingViewPosition = mCharacterList.size() - 1;
            if (getItemViewType(loadingViewPosition) == VIEW_TYPE_LOADING) {
                remove(loadingViewPosition);
                return true;
            }
        }
        return false;
    }

    public void remove(int position) {
        if (mCharacterList.size() < position) {
            Log.w(TAG, "The item at position: " + position + " doesn't exist");
            return;
        }
        mCharacterList.remove(position);
        notifyItemRemoved(position);
    }

    public void removeAll() {
        mCharacterList.clear();
        notifyDataSetChanged();
    }

    public boolean addLoadingView(RecyclerView recyclerView) {
        if (getItemViewType(mCharacterList.size() - 1) != VIEW_TYPE_LOADING) {
            add(null, recyclerView);
            return true;
        }
        return false;
    }

    public void add(CharacterDto item, RecyclerView recyclerView) {
        add(null, item, recyclerView);
    }

    public void add(@Nullable Integer position, CharacterDto item, RecyclerView recyclerView) {
        if (position != null) {
            mCharacterList.add(position, item);
            notifyItemInserted(position);
        } else {
            mCharacterList.add(item);
            recyclerView.post(new Runnable() {
                @Override
                public void run() {
                    notifyItemInserted(mCharacterList.size() - 1);
                }
            });
        }
    }

    public int getViewType() {
        return mViewType;
    }

    public void setViewType(int viewType) {
        mViewType = viewType;
    }

    public class ProgressBarViewHolder extends BaseViewHolder {

        public final ProgressBar progressBar;

        public ProgressBarViewHolder(View view) {
            super(view);
            progressBar = view.findViewById(R.id.progress_bar);
        }

        @Override
        protected void clear() {
        }
    }

    public class CharacterViewHolder extends BaseViewHolder {

        final ImageView imgCharacter;
        final TextView txtCharacterName;
        final TextView txtCharacterDescription;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            imgCharacter = itemView.findViewById(R.id.iv_characterPicture_landscape);
            txtCharacterName = itemView.findViewById(R.id.tv_characterName_landscape);
            txtCharacterDescription = itemView.findViewById(R.id.tv_description_landscape);
        }

        @Override
        protected void clear() {
            imgCharacter.setImageDrawable(null);
            txtCharacterName.setText("");
            txtCharacterDescription.setText("");
        }

        @Override
        public void onBind(final int position) {
            super.onBind(position);

            final CharacterDto character = mCharacterList.get(position);

            if (character.getThumbnail() != null) {
                Picasso.with(imgCharacter.getContext())
                        .load(character.getThumbnail().getImageUrl(MarvelImage.Size.PORTRAIT_INCREDIBLE))
                        .fit()
                        .into(imgCharacter);
            }

            if (character.getName() != null) {
                txtCharacterName.setText(character.getName());
            }

            if (character.getDescription() != null) {
                txtCharacterDescription.setText(character.getDescription());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onCharacterViewClick(character.getName());
                }
            });

        }
    }

    public void updateMarvelCharacters(List<CharacterDto> mListCharacters) {
        this.mCharacterList.addAll(mListCharacters);
//        notifyDataSetChanged();
        notifyItemRangeInserted(getItemCount(), mCharacterList.size() - 1);
    }

    public interface Callback {
        void onCharacterViewClick(String text);
    }

}
