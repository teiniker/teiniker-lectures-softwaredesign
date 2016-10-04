package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class XmlCompositeTest
{
    private XmlDocument document;
    
    @Before
    public void startup()
    {
    	document = new XmlDocument();
    	XmlElement project = new XmlElement("project");
    	project.addAttribute(new XmlAttribute("name", "simple-ant-project"));
    	project.addAttribute(new XmlAttribute("default", "compile"));
    	document.setRoot(project);

    	XmlElement property1 = new XmlElement("property");
    	property1.addAttribute(new XmlAttribute("name", "src"));
    	property1.addAttribute(new XmlAttribute("location", "./src/java"));
    	project.addElement(property1);
    	
    	XmlElement property2 = new XmlElement("property");
    	property2.addAttribute(new XmlAttribute("name", "build"));
    	property2.addAttribute(new XmlAttribute("location", "./build"));
    	project.addElement(property2);
    	
    	XmlElement target = new XmlElement("target");
    	target.addAttribute(new XmlAttribute("name", "compile"));    	
    	project.addElement(target);
    	
    	XmlElement javac = new XmlElement("javac");
    	javac.addAttribute(new XmlAttribute("srcdir", "${src}")); 
    	javac.addAttribute(new XmlAttribute("destdir", "${build}")); 
    	target.addElement(javac);
    	
    }
    
    
    @Test
    public void testAntFile()
    {        
        XmlElement root = document.getRoot();
        Assert.assertEquals("project", root.getElementName());
        Assert.assertEquals("name", root.getAttributes().get(0).getAttributeName());
        Assert.assertEquals("simple-ant-project", root.getAttributes().get(0).getValue());
        Assert.assertEquals("default", root.getAttributes().get(1).getAttributeName());
        Assert.assertEquals("compile", root.getAttributes().get(1).getValue());
        
        XmlElement propertySrc = root.getElements().get(0);
        Assert.assertEquals("property", propertySrc.getElementName());
        Assert.assertEquals("name", propertySrc.getAttributes().get(0).getAttributeName());
        Assert.assertEquals("src", propertySrc.getAttributes().get(0).getValue());
        Assert.assertEquals("location", propertySrc.getAttributes().get(1).getAttributeName());
        Assert.assertEquals("./src/java", propertySrc.getAttributes().get(1).getValue());
        
        XmlElement propertyBuild = root.getElements().get(1);
        Assert.assertEquals("property", propertyBuild.getElementName());
        Assert.assertEquals("name", propertyBuild.getAttributes().get(0).getAttributeName());
        Assert.assertEquals("build", propertyBuild.getAttributes().get(0).getValue());
        Assert.assertEquals("location", propertyBuild.getAttributes().get(1).getAttributeName());
        Assert.assertEquals("./build", propertyBuild.getAttributes().get(1).getValue());
    
        XmlElement targetCompile = root.getElements().get(2);
        Assert.assertEquals("target", targetCompile.getElementName());
        Assert.assertEquals("name", targetCompile.getAttributes().get(0).getAttributeName());
        Assert.assertEquals("compile", targetCompile.getAttributes().get(0).getValue());
        
        XmlElement taskJavaC = targetCompile.getElements().get(0);
        Assert.assertEquals("javac", taskJavaC.getElementName());
        Assert.assertEquals("srcdir", taskJavaC.getAttributes().get(0).getAttributeName());
        Assert.assertEquals("${src}", taskJavaC.getAttributes().get(0).getValue());
        Assert.assertEquals("destdir", taskJavaC.getAttributes().get(1).getAttributeName());
        Assert.assertEquals("${build}", taskJavaC.getAttributes().get(1).getValue());        
    }
}
