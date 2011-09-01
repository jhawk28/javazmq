package zmq.util;

import zmq.transport.TransportType;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:54 PM
 */
public class Address
{
  private TransportType type;
  private String host;
  private int port;

  public Address(TransportType type, String host, int port)
  {
    this.type = type;
    this.host = host;
    this.port = port;
  }

  public TransportType getType()
  {
    return type;
  }

  public String getHost()
  {
    return host;
  }

  public int getPort()
  {
    return port;
  }

  public static Address parse(String address)
  {
    return null;
  }
}
