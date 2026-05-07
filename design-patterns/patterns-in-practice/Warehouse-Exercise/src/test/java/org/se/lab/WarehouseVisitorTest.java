package org.se.lab;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WarehouseVisitorTest
{
    @Test
    public void testVisitProductBundle()
    {
        ProductBundle bundle = new ProductBundle("Milch", 10);

        Visitor visitor = new InventoryVisitor();
        bundle.accept(visitor);
        Map<String, Integer> map = visitor.getInventoryList();

        Assert.assertEquals(Integer.valueOf(10), map.get("Milch"));
    }

    @Test
    public void testVisitLocation()
    {
        Location location = new Location();
        location.addProduct(new ProductBundle("Milch", 5));
        location.addProduct(new ProductBundle("Käse", 10));

        Visitor visitor = new InventoryVisitor();
        location.accept(visitor);
        Map<String, Integer> map = visitor.getInventoryList();

        Assert.assertEquals(Integer.valueOf(5), map.get("Milch"));
        Assert.assertEquals(Integer.valueOf(10), map.get("Käse"));
    }


    @Test
    public void testVisitArea()
    {
        Area foodFreeze = new Area("Tiefkühlbereich");

        Location loc2 = new Location();
        loc2.addProduct(new ProductBundle("Pizza", 15));
        loc2.addProduct(new ProductBundle("Germknödel", 10));
        foodFreeze.addLocation(loc2);

        Location loc4 = new Location();
        loc4.addProduct(new ProductBundle("Pizza", 7));
        loc4.addProduct(new ProductBundle("Germknödel", 5));
        foodFreeze.addLocation(loc4);

        Visitor visitor = new InventoryVisitor();
        foodFreeze.accept(visitor);
        Map<String, Integer> map = visitor.getInventoryList();

        Assert.assertEquals(Integer.valueOf(15+7), map.get("Pizza"));
        Assert.assertEquals(Integer.valueOf(10+5), map.get("Germknödel"));
    }

    @Test
    public void testWarehouse()
    {
        Warehouse warehouse = new Warehouse("Lager-001");

        Area foodCool = new Area("Kühlbereich");
        warehouse.addArea(foodCool);

        Location loc1 = new Location();
        loc1.addProduct(new ProductBundle("Milch", 10));
        loc1.addProduct(new ProductBundle("Käse", 10));
        foodCool.addLocation(loc1);

        Location loc3 = new Location();
        loc3.addProduct(new ProductBundle("Milch", 6));
        loc3.addProduct(new ProductBundle("Käse", 4));
        foodCool.addLocation(loc3);

        Visitor visitor = new InventoryVisitor();
        warehouse.accept(visitor);
        Map<String, Integer> map = visitor.getInventoryList();

        System.out.println(map);
        Assert.assertEquals(Integer.valueOf(10+6), map.get("Milch"));
        Assert.assertEquals(Integer.valueOf(10+4), map.get("Käse"));
    }
}
