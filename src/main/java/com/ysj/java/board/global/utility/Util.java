package com.ysj.java.board.global.utility;

import java.util.ArrayList;
import java.util.List;

public class Util
{
  public static <T> void swapListComponent(List<T> list, int index1, int index2)
  {
    T temp = list.get(index1);
    list.set(index1, list.get(index2));
    list.set(index2, temp);
  }

  public static <T> List<T> reverseList(List<T> list)
  {
    List<T> copyList = new ArrayList<>(list);

    int len = copyList.size();
    int times = len / 2;
    for(int a = 0; a < times; a++)
    {
      swapListComponent(copyList, a, (len - 1) - a);
    }

    return copyList;
  }
}
