package music;

import map.ErrorMessage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Josh Schijins
 * This class is used to control music in the game.
 */

public class MusicPlayer {
	private Clip clip;
	
	public MusicPlayer(String fileName) {
		try {
			File file = new File(fileName);
			if(file.exists()) {
				clip = AudioSystem.getClip();
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(file.toURI().toURL());
				clip.open(inputStream);
			}
		} catch(LineUnavailableException lue) {
			ErrorMessage.addError("clip not available due to resource restrictions");
		} catch (SecurityException se) {
			ErrorMessage.addError("Clip not available, security reasons");
		} catch(IllegalArgumentException iae) {
			ErrorMessage.addError("Clip not supported");
		} catch(UnsupportedAudioFileException usafe) {
			ErrorMessage.addError("URL does not point to valid audio file");
		} catch(IOException ioe) {
			ErrorMessage.addError("I/O error MusicPlayer");
		}
	}
	
	/**
	 * This method rewinds the audio clip.
	 * @param toLoop if true will start the clip over.
	 */
	public void play(boolean toLoop) {
		clip.setFramePosition(0);
		if(toLoop) {
			loop();
		}
		clip.start();
	}
	
	/**
	 * This method loops the clip infinitely (until manually stopped).
	 */
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * This method is used to determine whether the audio clip is playing.
	 * @return clip.isActive() checks whether the clip is in use or not.
	 */
	public boolean playing() {
		return clip.isActive();
	}

	/**
	 * This method stops playing the clip.
	 */
	public void stop() {
		clip.stop();
	}

}
