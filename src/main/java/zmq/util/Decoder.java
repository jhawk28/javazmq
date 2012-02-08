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
  public static byte connect(ReadableByteChannel channel) throws IOException
  {
    // challenge
    ByteBuffer buffer = ByteBuffer.allocate(5);
    channel.read(buffer);
    buffer.flip();
    if (buffer.get() != 0x4 || buffer.get() != 0x0)
    {
      throw new ZMQException("invalid challenge");
    }
    if (buffer.get() != 0x11)
    {
      throw new ZMQException("invalid version");
    }
    byte socketType = buffer.get();
    byte[] identity;

    // anonymous or identity

    return socketType;
  }
}
