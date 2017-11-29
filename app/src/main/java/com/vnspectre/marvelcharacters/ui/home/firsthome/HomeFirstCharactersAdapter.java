package com.vnspectre.marvelcharacters.ui.home.firsthome;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vnspectre.marvelcharacters.R;
import com.vnspectre.marvelcharacters.model.marvel.entities.CharacterDto;
import com.vnspectre.marvelcharacters.model.marvel.entities.MarvelImage;

import java.util.List;

/**
 * Created by Spectre on 11/24/17.
 */

public class HomeFirstCharactersAdapter extends RecyclerView.Adapter<HomeFirstCharactersAdapter.CharacterViewHolder> {

    //private final Context mContext;
    private final HomeFirstCharactersAdapterOnClickHandler mClickHandler;
    private List<CharacterDto> mListCharacters;
    private int position;

    public HomeFirstCharactersAdapter(List mListCharacters, HomeFirstCharactersAdapterOnClickHandler mClickHandler) {
        this.mListCharacters = mListCharacters;
        //this.mContext = mContext;
        this.mClickHandler = mClickHandler;
    }

    public interface HomeFirstCharactersAdapterOnClickHandler {
        void onClickCharacterAdapter(String selectedCharacterName);
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.home_first_container_character_layout, parent, false);
        CharacterViewHolder characterViewHolder = new CharacterViewHolder(view);

        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mListCharacters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ImageView imgCharacter;
        final TextView txtCharacterName;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            imgCharacter = itemView.findViewById(R.id.iv_characterPicture);
            txtCharacterName = itemView.findViewById(R.id.tv_characterName);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mClickHandler.onClickCharacterAdapter(mListCharacters.get(getAdapterPosition()).getName());
        }

        protected void clear() {
            imgCharacter.setImageDrawable(null);
            txtCharacterName.setText("");
        }

        public void onBind(int position) {
            final CharacterDto characterDto = mListCharacters.get(position);
            clear();
            Picasso.with(imgCharacter.getContext()).load(characterDto.getThumbnail().getImageUrl(MarvelImage.Size.PORTRAIT_INCREDIBLE)).into(imgCharacter);
            txtCharacterName.setText(characterDto.getName());
        }
    }

    public void updateMarvelCharacters(List<CharacterDto> mListCharacters) {
        this.mListCharacters = mListCharacters;
        notifyDataSetChanged();
    }
}
