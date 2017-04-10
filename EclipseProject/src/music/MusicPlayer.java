package music;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
		}catch(Exception e){
			e.printStackTrace();
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