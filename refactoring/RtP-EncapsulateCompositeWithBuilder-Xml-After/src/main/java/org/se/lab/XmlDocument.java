package org.se.lab;


public class XmlDocument
{
    public XmlDocument(String version, String encoding)
    {
        setVersion(version);
        setEncoding(encoding);
    }
    
    /*
     * Property: version:String
     */
    private String version;
    public String getVersion()
    {
        return version;
    }
    public void setVersion(String version)
    {
        if(version == null)
            throw new NullPointerException();
        this.version = version;
    }
    
    
    /*
     * Property: encoding:String
     */
    private String encoding;
    public String getEncoding()
    {
        return encoding;
    }
    public void setEncoding(String encoding)
    {
        if(encoding == null)
            throw new NullPointerException();
        this.encoding = encoding;
    }

    
    /*
     * Association: ---[1]-> root:XmlElement
     */
    private XmlElement root;
    public XmlElement getRoot()
    {
        return root;
    }
    public void setRoot(XmlElement root)
    {
        if(root == null)
            throw new NullPointerException();
        this.root = root;
    }
}
