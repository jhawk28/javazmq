package zmq;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:28 PM
 */
public class Poller
{
  public static byte POLLIN = 1;
  public static byte POLLOUT = 2;
  public static byte POLLERR = 4;

  Poller(Context context)
  {

  }

  public int getNext()
  {
    return 0;
  }

  public int size()
  {
    return 0;
  }

  public long poll()
  {
    return poll(-1);
  }

  public long poll(long timeout)
  {
    return 0;
  }

  public int register(Socket socket)
  {
    return register(socket, POLLERR | POLLIN | POLLOUT);
  }

  public int register(Socket socket, int mask)
  {
    return 0;
  }

  public void unregister(Socket socket)
  {
    
  }

  public Socket getSocket(int index)
  {
    return null;
  }

  public boolean isPollin(int index)
  {
    return true;
  }

  public boolean isPollout(int index)
  {
    return true;
  }

  public boolean isPollerr(int index)
  {
    return true;
  }
}
