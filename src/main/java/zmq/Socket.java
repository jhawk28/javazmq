package zmq;

import org.zeromq.ZMQ;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:27 PM
 */
public class Socket
{
  ZMQ.Socket socket;

  public void close()
  {
    socket.close();
  }

  public int getType()
  {
    return socket.getType();
  }

  public long getLinger()
  {
    return socket.getLinger();
  }

  public long getReconnectIVL()
  {
    return socket.getReconnectIVL();
  }

  public long getBacklog()
  {
    return socket.getBacklog();
  }

  public long getReconnectIVLMax()
  {
    return socket.getReconnectIVLMax();
  }

  public long getMaxMsgSize()
  {
    return socket.getMaxMsgSize();
  }

  public long getSndHWM()
  {
    return socket.getSndHWM();
  }

  public long getRcvHWM()
  {
    return socket.getRcvHWM();
  }

  public long getHWM()
  {
    return socket.getHWM();
  }

  public long getSwap()
  {
    return socket.getSwap();
  }

  public long getAffinity()
  {
    return socket.getAffinity();
  }

  public byte[] getIdentity()
  {
    return socket.getIdentity();
  }

  public long getRate()
  {
    return socket.getRate();
  }

  public long getRecoveryInterval()
  {
    return socket.getRecoveryInterval();
  }

  public boolean hasMulticastLoop()
  {
    return socket.hasMulticastLoop();
  }

  public void setMulticastHops(long mcast_hops)
  {
    socket.setMulticastHops(mcast_hops);
  }

  public long getMulticastHops()
  {
    return socket.getMulticastHops();
  }

  public void setReceiveTimeOut(long timeout)
  {
    socket.setReceiveTimeOut(timeout);
  }

  public long getReceiveTimeOut()
  {
    return socket.getReceiveTimeOut();
  }

  public void setSendTimeOut(long timeout)
  {
    socket.setSendTimeOut(timeout);
  }

  public long getSendTimeOut()
  {
    return socket.getSendTimeOut();
  }

  public long getSendBufferSize()
  {
    return socket.getSendBufferSize();
  }

  public long getReceiveBufferSize()
  {
    return socket.getReceiveBufferSize();
  }

  public boolean hasReceiveMore()
  {
    return socket.hasReceiveMore();
  }

  public long getFD()
  {
    return socket.getFD();
  }

  public long getEvents()
  {
    return socket.getEvents();
  }

  public void setLinger(long linger)
  {
    socket.setLinger(linger);
  }

  public void setReconnectIVL(long reconnectIVL)
  {
    socket.setReconnectIVL(reconnectIVL);
  }

  public void setBacklog(long backlog)
  {
    socket.setBacklog(backlog);
  }

  public void setReconnectIVLMax(long reconnectIVLMax)
  {
    socket.setReconnectIVLMax(reconnectIVLMax);
  }

  public void setMaxMsgSize(long maxMsgSize)
  {
    socket.setMaxMsgSize(maxMsgSize);
  }

  public void setSndHWM(long sndHWM)
  {
    socket.setSndHWM(sndHWM);
  }

  public void setRcvHWM(long rcvHWM)
  {
    socket.setRcvHWM(rcvHWM);
  }

  public void setHWM(long hwm)
  {
    socket.setHWM(hwm);
  }

  public void setSwap(long swap)
  {
    socket.setSwap(swap);
  }

  public void setAffinity(long affinity)
  {
    socket.setAffinity(affinity);
  }

  public void setIdentity(byte[] identity)
  {
    socket.setIdentity(identity);
  }

  public void subscribe(byte[] topic)
  {
    socket.subscribe(topic);
  }

  public void unsubscribe(byte[] topic)
  {
    socket.unsubscribe(topic);
  }

  public void setRate(long rate)
  {
    socket.setRate(rate);
  }

  public void setRecoveryInterval(long recovery_ivl)
  {
    socket.setRecoveryInterval(recovery_ivl);
  }

  public void setMulticastLoop(boolean mcast_loop)
  {
    socket.setMulticastLoop(mcast_loop);
  }

  public void setSendBufferSize(long sndbuf)
  {
    socket.setSendBufferSize(sndbuf);
  }

  public void setReceiveBufferSize(long rcvbuf)
  {
    socket.setReceiveBufferSize(rcvbuf);
  }

  public void bind(java.lang.String addr)
  {
    socket.bind(addr);
  }

  public void connect(java.lang.String addr)
  {
    socket.connect(addr);
  }

  public boolean send(byte[] msg, int flags)
  {
    return socket.send(msg, flags);
  }

  public byte[] recv(int flags)
  {
    return socket.recv(flags);
  }

  public int recv(byte[] buffer, int offset, int len, int flags)
  {
    return socket.recv(buffer, offset, len, flags);
  }
}
