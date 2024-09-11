package com.google.appinventor.components.runtime.util;

import android.media.AudioManager;
import com.google.appinventor.components.runtime.Player;

public class FroyoUtil {
    private FroyoUtil() {
    }

    public static Object setAudioFocusChangeListener(final Player player) {
        return new AudioManager.OnAudioFocusChangeListener() {
            private boolean vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj = false;

            public final void onAudioFocusChange(int i) {
                Player player;
                if (i == -3 || i == -2) {
                    Player player2 = player;
                    if (player2 != null && player2.playerState == Player.State.PLAYING) {
                        player.pause();
                        this.vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj = true;
                    }
                } else if (i == -1) {
                    this.vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj = false;
                    player.OtherPlayerStarted();
                } else if (i == 1 && (player = player) != null && this.vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj && player.playerState == Player.State.PAUSED_BY_EVENT) {
                    player.Start();
                    this.vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj = false;
                }
            }
        };
    }

    public static boolean focusRequestGranted(AudioManager audioManager, Object obj) {
        return audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) obj, 3, 1) == 1;
    }

    public static void abandonFocus(AudioManager audioManager, Object obj) {
        audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) obj);
    }
}
