package gus06.entity.gus.file.rar.innosystec.unrar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Inno_ReadOnlyAccessFile extends RandomAccessFile implements Inno_IReadOnlyAccess{

	public Inno_ReadOnlyAccessFile(File file) throws FileNotFoundException {
		super(file, "r");
	}

	public int readFully(byte[] buffer, int count) throws IOException {
        assert (count > 0) : count;
        this.readFully(buffer, 0, count);
        return count;
    }

	public long getPosition() throws IOException {
        return this.getFilePointer();
	}

	public void setPosition(long pos) throws IOException {
        this.seek(pos);
	}
}