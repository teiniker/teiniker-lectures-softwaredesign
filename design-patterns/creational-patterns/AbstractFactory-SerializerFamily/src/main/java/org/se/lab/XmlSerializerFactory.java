package org.se.lab;

class XmlSerializerFactory // package private
    extends SerializerFactory
{
    public ArticleSerializer createArticleSerializer()
    {
        return new ArticleXmlSerializer();
    }

    // Usually, there are some more createXXXSerializer() methods
}
