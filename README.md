### Regex in Java
[docs](https://docs.oracle.com/javase/tutorial/essential/regex/index.html)

### Escaping
```java
String st = "+{._ ])";
assertThat(st, matchesPattern("\\+\\{\\._ ]\\)") );

```

#### Backslash
To find backslash in string `"abc\"`, regex would be `"\\"` but in java each backslash should be escaped: 
`Pattern.compile("\\\\");`

#### Matcher methods  
`matches()` attempts to match the entire region against the pattern SO use `.*pattern.*`  
`lookingAt()` same as matches method but it does not require that the entire region be matched  
`find()` attempts to find the next subsequence of the input sequence  

#### Pattern  
`Pattern.quote()` to escape input 

#### Flags  
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


### Unicode
Use UNICODE_CHARACTER_CLASS flag  
```java
String chinese = "四";
assertTrue(Pattern.compile("\\w", Pattern.UNICODE_CHARACTER_CLASS).matcher(chinese).matches()); // matches word
assertTrue(Pattern.compile("(?U)\\w").matcher(chinese).matches()); // matches word
assertTrue(Pattern.compile("\\w").matcher(chinese).matches()); // fails
```
Use unicode classes for Unicode scripts, blocks, categories.
[link](http://www.unicode.org/reports/tr18/)
```java
String greek="Ω Δ";
String mixed="Λ d";
String latinUpper="O D";

assertTrue(greek.matches("(?U)\\p{InGreek} \\w")); // matches
assertTrue(greek.matches("(?U)\\p{Lu} \\p{Lu}")); // matches Greek Uppercase

assertTrue(mixed.matches("(?U)\\p{IsLatin} \\p{IsLatin}")); // fails
assertTrue(latinUpper.matches("\\p{Lu} \\p{Lu}")); // matches Latin Uppercase
assertTrue(mixed.matches("\\P{IsLatin} \\p{IsLatin}")); // matches non latin and latin
assertTrue(mixed.matches("\\P{IsLatin} \\p{IsLatin}")); // matches non latin and latin
```
