package zmq.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;


/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:53 PM
 */
public class Encoder
{
  static byte MORE = 0x1;
  static byte FINAL = 0x0;

  public static void connect(WritableByteChannel channel, byte[] identity) throws IOException
  {
    if (identity != null)
    {
      identity(channel, identity);
    }
    else
    {
      anonymous(channel);
    }
  }

  private static void identity(WritableByteChannel channel, byte[] identity) throws IOException
  {
    if (identity == null || identity.length < 1 || identity.length > 255)
    {
      throw new ZMQException("Invalid identity");
    }

    send(channel, ByteBuffer.wrap(identity), false);
  }

  private static void anonymous(WritableByteChannel channel) throws IOException
  {
    byte[] anonymous = {0x1, FINAL};
    channel.write(ByteBuffer.wrap(anonymous));
  }

  public static void send(WritableByteChannel channel, ByteBuffer data, boolean more) throws IOException
  {
    int size = data.limit();
    ByteBuffer buffer;
    if (size > 254)
    {
      buffer = ByteBuffer.allocate(9);
      buffer.put((byte) 0xFF);
      buffer.putLong(size);
    }
    else
    {
      buffer = ByteBuffer.allocate(1);
      buffer.put((byte) size);
    }
    buffer.flip();
    channel.write(buffer); //length

    buffer.clear();
    if (more)
    {
      buffer.put(MORE);
    }
    else
    {
      buffer.put(FINAL);
    }
    buffer.flip();
    channel.write(buffer);
    channel.write(data);
  }


}
