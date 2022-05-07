package org.se.lab;

class JsonSerializerFactory // package private
    extends SerializerFactory
{

    @Override
    public ArticleSerializer createArticleSerializer()
    {
        return new ArticleJsonSerializer();
    }
    
    // Usually, there are some more createXXXSerializer() methods
}
