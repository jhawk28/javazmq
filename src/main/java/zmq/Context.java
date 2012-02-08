package zmq;

import org.zeromq.ZMQ;
import zmq.patterns.SocketType;
import zmq.util.ZMQException;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:27 PM
 */
public class Context
{
  ZMQ.Context context;

  public void term()
  {
    context.term();
  }

  public ZMQ.Socket socket(int type)
  {
    return context.socket(type);
  }

  public ZMQ.Poller poller()
  {
    return context.poller();
  }

  public ZMQ.Poller poller(int size)
  {
    return context.poller(size);
  }
}
