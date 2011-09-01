package zmq;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:23 PM
 */
public class ZMQ
{
  public static Context context(int threads)
  {
    return new Context(threads);
  }
}
