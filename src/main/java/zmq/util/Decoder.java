package zmq.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:53 PM
 */
public class Decoder
{
  private ByteBuffer temp = ByteBuffer.allocate(258); //start...

  public void readOne(ReadableByteChannel channel) throws IOException
  {
    temp.limit(1);
    channel.read(temp);

    readEight(channel);
  }

  public void readEight(ReadableByteChannel channel) throws IOException
  {
    temp.limit(8);
    channel.read(temp);

  }
}
