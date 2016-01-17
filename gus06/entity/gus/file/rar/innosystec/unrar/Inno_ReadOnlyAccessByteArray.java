package gus06.entity.gus.file.rar.innosystec.unrar;

import java.io.EOFException;
import java.io.IOException;

public class Inno_ReadOnlyAccessByteArray implements Inno_IReadOnlyAccess{

	private int positionInFile;
	private byte[] file;
	
	public Inno_ReadOnlyAccessByteArray(byte[] file){
		if(file == null){
			throw new NullPointerException("file must not be null!!");
		}
		this.file = file;
		this.positionInFile = 0;
	}

    public long getPosition() throws IOException {
		return positionInFile;
	}

	public void setPosition(long pos) throws IOException {
		if (pos < file.length && pos >= 0){
			this.positionInFile = (int)pos;
		}
        else{
			throw new EOFException();
		}
	}

    public int read() throws IOException {
        return file[positionInFile++];
    }

    public int read(byte[] buffer, int off, int count) throws IOException {
        int read = Math.min(count, file.length-positionInFile);
        System.arraycopy(file, positionInFile, buffer, off, read);
        positionInFile += read;
        return read;
    }

	public int readFully(byte[] buffer, int count) throws IOException {
		if(buffer == null ){
			throw new NullPointerException("buffer must not be null");
		}
		if(count == 0){
			throw new IllegalArgumentException("cannot read 0 bytes ;-)");
		}
		int read = Math.min(count, file.length-(int)positionInFile-1);	
		System.arraycopy(file, (int)positionInFile, buffer, 0, read );
		positionInFile+=read;
		return read;
	}

    public void close() throws IOException {
    }
}