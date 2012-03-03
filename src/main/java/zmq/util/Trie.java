package zmq.util;

/**
 * TODO Description
 *
 * @author jhawk28
 *         Date: 8/31/11
 *         Time: 10:28 PM
 */
public class Trie
{
  private Trie[] links;
  private int count;
  private int word_count;

  public Trie()
  {
    links = new Trie[256];
  }

  public boolean add(byte[] data)
  {
    Trie t = this;
    for (byte index : data)
    {
      if (t.links[index] == null)
      {
        t.links[index] = new Trie();
      }
      t = t.links[index];
      t.count++;
    }
    t.word_count++; // last one is a word
    return false;
  }

  public boolean remove(byte[] data)
  {
    // TODO only remove if data is a full work
    if (contains(data))
    {
      Trie t = this;
      for (byte index : data)
      {
        if (t != null)
        {
          t = t.links[index];
        }

        if (t != null)
        {
          t.count--;
          if (t.count == 0)
          {
            t.links[index] = null;
          }
        }
      }

      if (t != null)
      {
        t.word_count--;
      }

      return true;
    }
    return false;
  }

  public boolean contains(byte[] data)
  {
    Trie t = this;
    for (byte index : data)
    {
      if (t.links[index] == null)
      {
        return false;
      }
      t = t.links[index];
    }
    // Only match on prefix, not full word
    return t.count > 0;
  }
}
