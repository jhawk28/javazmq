package zmq.util;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:56 PM
 */
public class ZMQException extends RuntimeException
{
  public ZMQException()
  {
    super();
  }

  public ZMQException(String message)
  {
    super(message);
  }

  public ZMQException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public ZMQException(Throwable cause)
  {
    super(cause);
  }
}
