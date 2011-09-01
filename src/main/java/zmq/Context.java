package zmq;

import zmq.patterns.SocketType;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:27 PM
 */
public class Context
{
  Context(int threads)
  {
    
  }

  public Socket socket(SocketType type)
  {
    return new Socket(this, type);
  }

  public Poller poller() {
    return new Poller(this);
  }

  public void term()
  {
    
  }
}
