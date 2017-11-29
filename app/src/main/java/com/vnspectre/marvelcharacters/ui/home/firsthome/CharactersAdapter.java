package com.vnspectre.marvelcharacters.ui.home.firsthome;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.model.marvel.entities.CharacterDto;
import com.vnspectre.marvelcharacters.model.marvel.entities.MarvelImage;
import com.vnspectre.marvelcharacters.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Spectre on 11/29/17.
 */

public class CharactersAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Callback mCallback;
    private List<CharacterDto> mCharacterList;

    public CharactersAdapter(List<CharacterDto> characterList) {
        mCharacterList = characterList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CharacterViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.home_first_container_character_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }

    public void updateMarvelCharacters(List<CharacterDto> mListCharacters) {
        this.mCharacterList = mListCharacters;
        notifyDataSetChanged();
    }

    public interface Callback {
        void onCharacterViewClick(String text);
    }

    public class CharacterViewHolder extends BaseViewHolder {

        final ImageView imgCharacter;
        final TextView txtCharacterName;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            imgCharacter = itemView.findViewById(R.id.iv_characterPicture);
            txtCharacterName = itemView.findViewById(R.id.tv_characterName);

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
                        .into(imgCharacter);
            }

            if (character.getName() != null) {
                txtCharacterName.setText(character.getName());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onCharacterViewClick(character.getName());
                }
            });

        }
    }

}
