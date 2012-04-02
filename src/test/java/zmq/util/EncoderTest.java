package zmq.util;

import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Test for the Encoder
 *
 * @author jhawk28
 */
public class EncoderTest
{
  @Test
  public void testConnectIdentity() throws Exception
  {
    Pipe pipe = Pipe.open();

    WritableByteChannel input = pipe.sink();
    ReadableByteChannel output = pipe.source();

    byte[] identity = "hello".getBytes();

    Encoder.connect(input, identity);
    ByteBuffer buffer = ByteBuffer.allocate(identity.length + 2);

    output.read(buffer);

    ByteBuffer expected = ByteBuffer.allocate(identity.length + 2);
    expected.put((byte) identity.length);
    expected.put((byte) 0x0);
    expected.put(identity);
    Assert.assertArrayEquals(expected.array(), buffer.array());

    input.close();
    output.close();
  }

  @Test
  public void testConnectAnonymous() throws Exception
  {
    Pipe pipe = Pipe.open();

    WritableByteChannel input = pipe.sink();
    ReadableByteChannel output = pipe.source();

    Encoder.connect(input, null);
    ByteBuffer buffer = ByteBuffer.allocate(2);

    output.read(buffer);

    ByteBuffer expected = ByteBuffer.allocate(2);
    expected.put((byte) 0x1);
    expected.put((byte) 0x0);

    Assert.assertArrayEquals(expected.array(), buffer.array());

    input.close();
    output.close();
  }

  @Test
  public void testSendSmall() throws Exception
  {
    Pipe pipe = Pipe.open();

    WritableByteChannel input = pipe.sink();
    ReadableByteChannel output = pipe.source();

    byte[] bytes = "data".getBytes();
    ByteBuffer data = ByteBuffer.wrap(bytes);

    Encoder.send(input, data, true);

    ByteBuffer buffer = ByteBuffer.allocate(1);
    output.read(buffer);
    byte[] size = buffer.array();
    Assert.assertArrayEquals(new byte[]{(byte) data.array().length}, size); // size
    buffer.clear();
    output.read(buffer);
    Assert.assertArrayEquals(new byte[]{(byte) 0x1}, buffer.array()); // more flag

    buffer = ByteBuffer.allocate(data.array().length);
    output.read(buffer);
    Assert.assertArrayEquals(bytes, buffer.array());

    input.close();
    output.close();
  }

  @Test
  public void testSendBig() throws Exception
  {
    Pipe pipe = Pipe.open();

    WritableByteChannel input = pipe.sink();
    ReadableByteChannel output = pipe.source();

    ByteBuffer data = ByteBuffer.allocate(257);
    for (int i = 0; i < 257; i++)
    {
      data.put((byte) 0x7);
    }
    byte[] clone = data.array().clone();

    data.flip();

    Encoder.send(input, data, true);

    ByteBuffer buffer = ByteBuffer.allocate(1);
    output.read(buffer);
    byte[] size = buffer.array();
    Assert.assertArrayEquals(new byte[]{(byte) 255}, size); // size

    buffer = ByteBuffer.allocate(8);
    output.read(buffer);
    buffer.flip();
    long length = buffer.getLong();
    Assert.assertEquals(clone.length, length);

    buffer = ByteBuffer.allocate(1);
    output.read(buffer);
    Assert.assertArrayEquals(new byte[]{(byte) 1}, buffer.array()); // size

    buffer = ByteBuffer.allocate(clone.length);
    output.read(buffer);
    Assert.assertArrayEquals(clone, buffer.array());

    input.close();
    output.close();
  }
}
