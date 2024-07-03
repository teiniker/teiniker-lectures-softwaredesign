# Deserialize Object Structures from JSON

To configure complex object structures compactly we can use 
**JSON deserialization**.

_Example:_ JSON definition of an object 
```JSON
{
  "isbn" : "9780132350884",
  "author" : "Robert C. Martin",
  "title" : "Clean Code"
}
```

_Example:_ Load an object from a JSON file
```Java
	protected Book loadBookFromJson(String filename)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(new File("src/test/resources", filename), Book.class);
		}
		catch (IOException e)
		{
			throw new IllegalStateException("Can't load " + filename + "!", e);
		}
	}
```

Note that this deserialization works for very complex object structures too.

## References

* [Jackson Project Home](https://github.com/FasterXML/jackson)

*Egon Teiniker, 2016-2024, GPL v3.0*