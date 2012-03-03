package zmq.util;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jhawk28
 * Date: 2/29/12
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrieTest
{
  @Test
  public void testAdd() throws Exception
  {
    Trie trie = new Trie();

    trie.add("hello".getBytes());
    Assert.assertTrue(trie.contains("h".getBytes()));
    Assert.assertTrue(trie.contains("he".getBytes()));
    Assert.assertTrue(trie.contains("hel".getBytes()));
    Assert.assertTrue(trie.contains("hell".getBytes()));
    Assert.assertTrue(trie.contains("hello".getBytes()));

    Assert.assertFalse(trie.contains("hello1".getBytes()));
  }

  @Test
  public void testRemove() throws Exception
  {
    Trie trie = new Trie();

    trie.add("hello".getBytes());
    trie.remove("hello".getBytes());
    Assert.assertFalse(trie.contains("hello".getBytes()));

    trie.add("hello".getBytes());
    trie.add("hello".getBytes());
    trie.remove("hello".getBytes());
    Assert.assertTrue(trie.contains("hello".getBytes()));

    trie.remove("hello".getBytes());
    Assert.assertFalse(trie.contains("hello".getBytes()));
  }
}
