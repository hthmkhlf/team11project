package music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import map.ErrorMessage;

public class MusicPlayer {
	private Clip clip;
	
	public MusicPlayer(String fileName){
		try{
			File file = new File(fileName);
			if(file.exists()){
				clip = AudioSystem.getClip();
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(file.toURI().toURL());
				clip.open(inputStream);
			}
		}catch(LineUnavailableException lue){
			ErrorMessage.addError("clip not available due to resource restrictions");
		}catch (SecurityException se) {
			ErrorMessage.addError("Clip not available, security reasons");
		}catch(IllegalArgumentException iae){
			ErrorMessage.addError("Clip not supported");
		}catch(UnsupportedAudioFileException usafe){
			ErrorMessage.addError("URL does not point to valid audio file");
		}catch(IOException ioe){
			ErrorMessage.addError("I/O error MusicPlayer");
		}
	}
	
	
	public void play(boolean toLoop){
		clip.setFramePosition(0);  // Must always rewind!
		if(toLoop){
			loop();
		}
        clip.start();
	}
	public void loop(){
		clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
      
    public boolean playing(){
    	return clip.isActive();
    }
      
      
    public void stop(){
        clip.stop();
    }
}