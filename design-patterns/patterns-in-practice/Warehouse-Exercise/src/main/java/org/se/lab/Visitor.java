package org.se.lab;

import java.util.Map;

public interface Visitor 
{
	Map<String, Integer> getInventoryList();
	
	void visit(Warehouse warehouse);
	void visit(Area area);
	void visit(Location location);
	void visit(ProductBundle product);
}
