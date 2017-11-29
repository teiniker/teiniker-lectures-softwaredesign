package org.se.lab;


class TableFactoryImpl // package-private
    implements TableFactory
{
    public PersonTable createPersonTable()
    {
        return new PersonTableImpl();
    }
    
    //...
}
