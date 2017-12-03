### Regex in Java
[docs](https://docs.oracle.com/javase/tutorial/essential/regex/index.html)
### Notes:

#### Matcher methods  
`matches()` attempts to match the entire region against the pattern SO use `.*pattern.*`  
`lookingAt()` same as matches method but it does not require that the entire region be matched  
`find()` attempts to find the next subsequence of the input sequence  

#### Pattern  
`Pattern.quote()` to escape input 

##### Flags  
| Constant                 |  Equivalent Embedded Flag Expression| 
|--------------------------|-------------------------------------| 
| Pattern.CANON_EQ         | None                                | 
| Pattern.CASE_INSENSITIVE | (?i)                                | 
| Pattern.COMMENTS         | (?x)                                | 
| Pattern.MULTILINE        | (?m)                                | 
| Pattern.DOTALL           | (?s)                                | 
| Pattern.LITERAL          | None                                | 
| Pattern.UNICODE_CASE     | (?u)                                | 
| Pattern.UNIX_LINES       | (?d)                                | 

### Backslash
To find backslash in string "abc\", regex would be '\\' but in java each backslash should be escaped: 
`Pattern.compile("\\\\");`


