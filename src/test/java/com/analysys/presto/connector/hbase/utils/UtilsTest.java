package com.analysys.presto.connector.hbase.utils;

import com.analysys.presto.connector.hbase.schedule.ConditionInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UtilsTest {

  @Test
  public void testAddZeroPrefix() {
    Assert.assertEquals("fooBar", Utils.addZeroPrefix("fooBar", 0));
    Assert.assertEquals("0fooBar", Utils.addZeroPrefix("fooBar", 1));
  }

  @Test
  public void testArrayCopy() {
    Assert.assertArrayEquals(new byte[]{8, 16}, Utils.arrayCopy(new byte[]{1, 2, 4, 8, 16, 32}, 3, 2));
  }

  @Test
  public void testIsBatchGetReturnFalse() {
    final ArrayList<ConditionInfo> conditions = new ArrayList<>();
    final ConditionInfo conditionInfo = new ConditionInfo("fooBar", null, null, null);
    conditions.add(conditionInfo);

    Assert.assertFalse(Utils.isBatchGet(conditions, "fooBar"));
  }

  @Test
  public void testIsBatchGetReturnTrue() {
    final ArrayList<ConditionInfo> conditions = new ArrayList<>();
    final ConditionInfo conditionInfo = new ConditionInfo("fooBar", Constant.CONDITION_OPER.EQ, null, null);
    conditions.add(conditionInfo);

    Assert.assertTrue(Utils.isBatchGet(conditions, "fooBar"));
  }

}
