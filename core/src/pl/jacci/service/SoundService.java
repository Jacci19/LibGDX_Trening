package pl.jacci.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundService {
    private Sound moneySound, jump, book, pick;;
    private Music music;

    public SoundService(){
        init();
    }

    private void init() {
        moneySound = Gdx.audio.newSound(Gdx.files.internal("android/assets/sound/money1.mp3"));
        jump = Gdx.audio.newSound(Gdx.files.internal("android/assets/sound/jump.wav"));
        book = Gdx.audio.newSound(Gdx.files.internal("android/assets/sound/book.wav"));
        pick = Gdx.audio.newSound(Gdx.files.internal("android/assets/sound/pick.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("android/assets/sound/music.mp3"));
    }

    public void playPickSound(){
        pick.play();
    }

    public void playJumpSound(){
        jump.play();
    }

    public void playBookSound(){
        book.play();
    }

    public void playMoneySound(){
        moneySound.play();
    }

    public void startPlayingMusic(boolean looped){
        music.setVolume(0.1f);
        music.play();
        music.setLooping(looped);
    }
}
