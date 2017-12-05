package com.vnspectre.marvelcharacters.ui.home.secondhome.characters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    private Callback mCallback;
    private List<CharacterDto> mCharacterList;

    public CharactersAdapter(List<CharacterDto> mCharacterList) {
        this.mCharacterList = mCharacterList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CharacterViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_landscape, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
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
        this.mCharacterList = mListCharacters;
        notifyDataSetChanged();
    }

    public interface Callback {
        void onCharacterViewClick(String text);
    }

}
