package zmq;

import org.zeromq.ZMQ;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:28 PM
 */
public class Poller
{
  ZMQ.Poller poller;

  public int register(ZMQ.Socket socket)
  {
    return poller.register(socket);
  }

  public int register(ZMQ.Socket socket, int events)
  {
    return poller.register(socket, events);
  }

  public void unregister(ZMQ.Socket socket)
  {
    poller.unregister(socket);
  }

  public ZMQ.Socket getSocket(int index)
  {
    return poller.getSocket(index);
  }

  public int getSize()
  {
    return poller.getSize();
  }

  public int getNext()
  {
    return poller.getNext();
  }

  public long poll()
  {
    return poller.poll();
  }

  public long poll(long tout)
  {
    return poller.poll(tout);
  }

  public boolean pollin(int index)
  {
    return poller.pollin(index);
  }

  public boolean pollout(int index)
  {
    return poller.pollout(index);
  }

  public boolean pollerr(int index)
  {
    return poller.pollerr(index);
  }
}
