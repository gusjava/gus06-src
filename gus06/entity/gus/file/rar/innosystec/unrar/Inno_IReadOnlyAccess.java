package gus06.entity.gus.file.rar.innosystec.unrar;

import java.io.IOException;

public interface Inno_IReadOnlyAccess {

	public long getPosition() throws IOException;
	public void setPosition(long pos) throws IOException;
	public int read() throws IOException;
	public int read(byte[] buffer, int off, int count) throws IOException;
	public int readFully(byte[] buffer, int count) throws IOException;
	public void close() throws IOException;
}