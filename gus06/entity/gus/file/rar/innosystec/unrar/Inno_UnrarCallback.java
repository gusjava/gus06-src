package gus06.entity.gus.file.rar.innosystec.unrar;

import java.io.File;

public interface Inno_UnrarCallback {

	boolean isNextVolumeReady(File nextVolume);
	void volumeProgressChanged(long current, long total);
}