package info.jbcs.minecraft.utilities;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public abstract class Sounds {
	SoundLoadEvent event;

    @ForgeSubscribe
    public void onSound(SoundLoadEvent evt){
		event=evt;

		try {
			addSounds();
		} catch (Exception e) {
			System.err.println("Failed to register one or more sounds: "+e);
		}
	}

    public abstract void addSounds();

    protected void addSound(String path){
		event.manager.soundPoolSounds.addSound(path);
    }
}
