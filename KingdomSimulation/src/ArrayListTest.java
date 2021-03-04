import ProducerConsumerAdapter.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest
{
  private ArrayList arrayList;
  @org.junit.jupiter.api.BeforeEach void setUp()
  {
    arrayList = new ArrayList();
  }

  @Test
  public void addElementIndexZero()
  {
    //When list is empty
    arrayList.add(0,"A");
    assertTrue(arrayList.contains("A"));

    //When list is empty
      arrayList.add(0,null);
      assertEquals(arrayList.get(0),null);
  }

  @Test
  public void addElementIndexOne()
  {
    //One if is empty
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.add(1,"A");
    });

    //One if index 0 occupied
    arrayList = new ArrayList();
    arrayList.add(0,"Something");
    arrayList.add(1, "A");
    assertTrue(arrayList.contains("A"));

    //One if A is already in list
    arrayList = new ArrayList();
    arrayList.add(0,"A");
    arrayList.add(1,"A");
    assertTrue(arrayList.contains("A"));
  }

  @Test
  public void addElementIndexMany()
  {
    //When previous elements not defined
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.add(7,"A");
    });

    //When previous elements defined
    arrayList = new ArrayList();
    for (int i = 0; i < 5; i++)
    {
      arrayList.add(i,"Something");
    }
    arrayList.add(5,"A");
    assertTrue(arrayList.contains("A"));

    //When previous elements defined and are also A
    arrayList = new ArrayList();
    for (int i = 0; i < 5 ; i++)
    {
      arrayList.add(i,"A");
    }
    arrayList.add(5,"A");
    assertTrue(arrayList.contains("A"));

  }

  @Test
  public void addElementIndexBoundary()
  {
    //Lower Bound
    assertThrows(IndexOutOfBoundsException.class, () -> {
      arrayList.add(-1, "A");
    });

    //Upper bound
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.add(101,"A");
    });

    //Upper bound with null
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.add(101,null);
    });

    //Lower bound with null
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.add(-1,null);
    });
  }

  @Test
  public void addElementIndexException()
  {
    //When we are out of Array bounds
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.add(102,"A");
    });
  }

    @Test
    public void addElementZero()
  {
    //When array list is empty
   arrayList.add("A");
   assertTrue(arrayList.contains("A"));
  }

  @Test
  public void addElementOne()
  {
    //When already has one element
  arrayList.add("B");
  arrayList.add("A");
  assertTrue(arrayList.contains("A"));
  }

  @Test
  public void addElementMany()
  {
    //When there are already many elements
    for (int i = 0; i < 5; i++)
    {
      arrayList.add("Something");
    }
    arrayList.add("A");
    assertTrue(arrayList.contains("A"));

    //When there are already many elements
    arrayList = new ArrayList();
    for (int i = 0; i < 14; i++)
    {
      arrayList.add("Something");
    }
    arrayList.add("A");
    assertTrue(arrayList.contains("A"));
  }

  @Test
  public void addElementBoundary()
  {
    //When default capacity is already reached
    for (int i = 0; i < 99; i++)
    {
      arrayList.add("Something");
    }
    arrayList.add("A");
    assertTrue(arrayList.contains("A"));
  }

  @Test
  public void addElementException()
  {
    //Any
  }

  @Test
  public void setIndexObjectZero()
  {
    //If array is empty
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.set(1,"A");
    });
  }

  @Test
  public void setIndexObjectOne()
  {
    //If there is one item
    arrayList.add("A");
    arrayList.set(0,"B");
    assertTrue(arrayList.contains("B"));

  }

  @Test
  public void setIndexObjectMany()
  {
    //If there are multiple objects
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    arrayList.add("D");
    arrayList.set(2,"Z");
    assertTrue(arrayList.contains("Z"));

    //If there are multiple objects
    arrayList = new ArrayList();
    arrayList.add("1");
    arrayList.add("2");
    arrayList.set(1,"5");
    assertTrue(arrayList.contains("5"));
  }

  @Test
  public void setIndexObjectBoundary()
  {
    //Lower boundary
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.set(-1,"A");
    });

    //Higher boundary
    arrayList = new ArrayList();
    for (int i = 0; i < 101; i++)
    {
      arrayList.add("A");
    }
    arrayList.set(100,"B");
    assertTrue(arrayList.contains("B"));
  }

  @Test
  public void setIndexObjectException()
  {
    //When out of bounds
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.set(120,"A");
    });
  }

  @Test
  public void getZero()
  {
    //When array list is empty
    assertThrows(IllegalStateException.class, ()->
    {
      arrayList.get(1);
    });
  }

  @Test
  public void getOne()
  {
    //When array list has one item already
    arrayList.add("A");
    assertEquals("A",arrayList.get(0));

  }

  @Test
  public void getMany()
  {
    //When array list has more items
    for (int i = 0; i < 10; i++)
    {
      arrayList.add("A");
    }
    assertEquals("A",arrayList.get(8));

    //When array list has more items
    arrayList = new ArrayList();
    for (int i = 0; i < 30; i++)
    {
      arrayList.add("A");
    }
    assertEquals("A",arrayList.get(12));
  }

  @Test
  public void getBoundary()
  {
    //Lower boundary
    assertThrows(IllegalStateException.class, ()->{
      arrayList.get(-1);
    });

    //Higher boundary
    for (int i = 0; i < 101; i++)
    {
      arrayList.add("A");
    }
    assertEquals("A",arrayList.get(100));
  }

  @Test
  public void getException()
  {
    //When out of bounds
    assertThrows(IllegalStateException.class, ()->
    {
      arrayList.get(150);
    });
  }

@Test
  public void removeIndexZero()
{
  //When array list is empty
  assertThrows(IndexOutOfBoundsException.class, ()->
  {
    arrayList.remove(0);
  });
}

@Test
    public void removeIndexOne()
{
  //When array list has one element
  arrayList.add("A");
  arrayList.remove(0);
  assertTrue(arrayList.isEmpty());
}

  @Test
  public void removeIndexMany()
  {
    //When array list has more elements
    for (int i = 0; i < 5; i++)
    {
      arrayList.add(i);
    }
    arrayList.remove(1);
    assertTrue(!arrayList.contains(1));

    //When array list has more elements
    arrayList = new ArrayList();
    for (int i = 0; i < 20; i++)
    {
      arrayList.add(i);
    }
    arrayList.remove(18);
    assertTrue(!arrayList.contains(18));
  }

  @Test
  public void removeIndexBoundary()
  {
    //When list contains some elements
    for (int i = 0; i < 10; i++)
    {
      arrayList.add(i);
    }
    //lower out of bounds
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.remove(-1);
    });
    //upper out of bounds
    assertThrows(IndexOutOfBoundsException.class, ()->
    {
      arrayList.remove(50);
    });

    arrayList.remove(9);
    assertTrue(!arrayList.contains(9));

    arrayList = new ArrayList();
    for (int i = 0; i < 10; i++)
    {
      arrayList.add(i);
    }
    arrayList.remove(0);
    assertTrue(!arrayList.contains(0));

  }

  @Test
  public void removeIndexException()
  {
  //When out of bounds
    assertThrows(IndexOutOfBoundsException.class,()->
    {
      arrayList.remove(150);
    });
  }

  @Test
  public void removeObjectZero()
  {
    //When array list is empty
    assertThrows(IllegalStateException.class, () -> {
      arrayList.remove("A");
    });
  }

    @Test
    public void removeObjectOne()
    {
      //When array list has one object
      arrayList.add("A");
      arrayList.remove("A");
      assertTrue(arrayList.isEmpty()) ;
   }

  @Test
  public void removeObjectMany()
  {
    //When array list has many objects
    for (int i = 0; i < 10; i++)
    {
      arrayList.add(i);
    }
    arrayList.remove(8);
    assertTrue(!arrayList.contains(8));

    //When array list has many objects
    arrayList = new ArrayList();
    for (int i = 0; i < 30; i++)
    {
      arrayList.add(i);
    }
    arrayList.remove(20);
    assertTrue(!arrayList.contains(20));
  }

  @Test
  public void removeObjectBoundary()
  {
    for (int i = 0; i < 20; i++)
    {
      String a = Integer.toString(i);
      arrayList.add(a);
    }
    arrayList.remove("19");
    assertTrue(!arrayList.contains(19));

    arrayList = new ArrayList();
    for (int i = 0; i < 20; i++)
    {
      String b = Integer.toString(i);
      arrayList.add(b);
    }
    arrayList.remove("0");
    assertTrue(!arrayList.contains(0));
  }

  @Test
  public void removeObjectException()
  {
    //When trying to remove object that is not in array list
    assertThrows(IllegalStateException.class, ()->
    {
      arrayList.remove("A");
    });
  }

  @Test
  public void containsZero()
  {
    assertEquals(false,arrayList.contains(0));
  }

  @Test
  public void containsOne()
  {
    arrayList.add("A");
    assertTrue(arrayList.contains("A"));
  }

  @Test
  public void containsMany()
  {
    for (int i = 0; i < 20; i++)
    {
      String a = Integer.toString(i);
      arrayList.add(a);
      arrayList.add("A");
    }
    assertTrue(arrayList.contains("17"));

    arrayList = new ArrayList();
    for (int i = 0; i < 10; i++)
    {
      String b = Integer.toString(i);
      arrayList.add(b);
    }
    assertTrue(arrayList.contains("4"));
  }

  @Test
  public void containsBoundary()
  {
    for (int i = 0; i < 20; i++)
    {
      String a = Integer.toString(i);
      arrayList.add(a);
    }
    assertTrue(arrayList.contains("19"));
    assertTrue(arrayList.contains("0"));
    assertTrue(!arrayList.contains("-1"));
    assertTrue(!arrayList.contains("50"));
  }

  @Test
  public void containsException()
  {
    //Any
  }

  @Test
  public void isEmptyZero()
  {
    assertTrue(arrayList.isEmpty());
  }
  @Test
  public void isEmptyOne()
  {
    arrayList.add("A");
    assertTrue(!arrayList.isEmpty());
  }
  @Test
  public void isEmptyMany()
  {
    for (int i = 0; i < 10; i++)
    {
      arrayList.add(i);
    }
    assertTrue(!arrayList.isEmpty());
  }
  @Test
  public void isEmptyBoundary()
  {
    //Any
  }

  @Test
  public void isEmptyException()
  {
    //Any
  }

  @Test
  public void isFullZero()
  {
    assertEquals(false, arrayList.isFull());
  }
  @Test
  public void isFullOne()
  {
    arrayList.add("A");
    assertEquals(false, arrayList.isFull());
  }
  @Test
  public void isFullMany()
  {
    for (int i = 0; i < 20; i++)
    {
      arrayList.add(i);
    }
    assertEquals(false,arrayList.isFull());
  }
  @Test
  public void isFullBoundary()
  {
    assertEquals(false,arrayList.isFull());

    for (int i = 0; i < 99; i++)
    {
      arrayList.add(i);
    }
    assertEquals(false, arrayList.isFull());
  }
  @Test
  public void isFullException()
  {
    //Any
  }

  @Test
  public void sizeZero()
  {
    assertEquals(0,arrayList.size());
  }

  @Test
  public void sizeOne()
  {
    arrayList.add("A");
    assertEquals(1,arrayList.size());
  }

  @Test
  public void sizeMany()
  {
    for (int i = 0; i < 20; i++)
    {
      arrayList.add(i);
    }
    assertEquals(20,arrayList.size());
  }

  @Test
  public void sizeBoundary()
  {
    //Any
  }

  @Test
  public void sizeException()
  {
    //Any
  }

  @Test
  public void toStringZero()
  {
    assertEquals("{}",arrayList.toString());
  }

  @Test
  public void toStringOne()
  {
  arrayList.add("A");
  assertEquals("{A}",arrayList.toString());
  }

  @Test
  public void toStringMany()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertEquals("{A, B, C}",arrayList.toString());
  }

  @Test
  public void toStringBoundary()
  {
  //Any
  }
  @Test
  public void toStringException()
  {
  //Any
  }

  @Test
  public void indexOfZero()
  {
    assertEquals(-1,arrayList.indexOf("A"));
  }

  @Test
  public void indexOfOne()
  {
    arrayList.add("A");
    assertEquals(0,arrayList.indexOf("A"));
  }

  @Test
  public void indexOfMany()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertEquals(2,arrayList.indexOf("C"));
  }

  @Test
  public void indexOfBoundary()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertEquals(1,arrayList.indexOf("B"));

    arrayList = new ArrayList();
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertEquals(0,arrayList.indexOf("A"));
  }

  @Test
  public void indexOfException()
  {
   //Any
  }
}
